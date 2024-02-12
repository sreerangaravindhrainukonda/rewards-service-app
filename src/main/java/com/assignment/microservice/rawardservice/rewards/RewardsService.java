package com.assignment.microservice.rawardservice.rewards;

import com.assignment.microservice.rawardservice.model.Customer;
import com.assignment.microservice.rawardservice.model.CustomerDTO;
import com.assignment.microservice.rawardservice.model.CustomerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RewardsService {
    private final CustomerRepository customerRepository;

    @Autowired
    public RewardsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getCustomerAll() {
        List<Customer> customers = customerRepository.findAll();
       return customers.stream().map(data->{
            CustomerDTO customerDTO=new CustomerDTO();
            customerDTO.setName(data.getName());
            customerDTO.setRewardPoints(calculateRewardPoints(data));
            customerDTO.setTotalPurchases(calculateTotalPurchases(data));
            return customerDTO;
        }).collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Integer customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            CustomerDTO customerDTO=new CustomerDTO();
            customerDTO.setTotalPurchases(calculateTotalPurchases(customer));
            customerDTO.setRewardPoints(calculateRewardPoints(customer));
            customerDTO.setName(customer.getName());
            return customerDTO;
        }else {
            return null;
        }
    }

    public Long calculateRewardPoints(Customer customer) {
        if (customer.getTransactions() == null || customer.getTransactions().isEmpty()) {
            return 0L;
        }
        return customer.getTransactions().stream()
                .mapToLong(CustomerTransaction::getPoints)
                .sum();
    }

    public Double calculateTotalPurchases(Customer customer) {
        if (customer.getTransactions() == null || customer.getTransactions().isEmpty()) {
            return 0.0;
        }
        return customer.getTransactions().stream()
                .mapToDouble(CustomerTransaction::getTotal)
                .sum();
    }
}