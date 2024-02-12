package com.assignment.microservice.rawardservice.rewards;

import com.assignment.microservice.rawardservice.model.Customer;
import com.assignment.microservice.rawardservice.model.CustomerDTO;
import com.assignment.microservice.rawardservice.model.CustomerTransaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RewardsServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private RewardsService rewardsService;


    @Test
    public void testGetCustomerAll() {
        // Create mock customers
        Customer customer1 = new Customer(1, "Test1");
        Customer customer2 = new Customer(2, "Test2");
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(customer1);
        mockCustomers.add(customer2);
        CustomerTransaction transaction1 = new CustomerTransaction(1L,customer1,1.0,"",new Date());
        CustomerTransaction transaction2 = new CustomerTransaction(1L,customer1,1.0,"",new Date());
        HashSet<CustomerTransaction> customerTransactions1 = new HashSet<>();
        customerTransactions1.add(transaction1);
        HashSet<CustomerTransaction> customerTransactions2 = new HashSet<>();
        customerTransactions2.add(transaction2);
        customer1.setTransactions(customerTransactions1);
        customer2.setTransactions(customerTransactions2);
        when(customerRepository.findAll()).thenReturn(mockCustomers);
        List<CustomerDTO> result = rewardsService.getCustomerAll();
        verify(customerRepository).findAll();
        assertEquals(2, result.size());
        assertEquals("Test1", result.get(0).getName());
        assertEquals(0, result.get(0).getRewardPoints().longValue());
        assertEquals(1, result.get(0).getTotalPurchases(), 0.001);
        assertEquals("Test2", result.get(1).getName());
        assertEquals(0, result.get(1).getRewardPoints().longValue());
        assertEquals(1.0, result.get(1).getTotalPurchases(), 0.001);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer(1, "Test1");
        HashSet<CustomerTransaction> customerTransactions1 = new HashSet<>();
        CustomerTransaction transaction1 = new CustomerTransaction(1L,customer,1.0,"",new Date());
        customerTransactions1.add(transaction1);
        customer.setTransactions(customerTransactions1);
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        CustomerDTO result = rewardsService.getCustomerById(1);
        verify(customerRepository).findById(1);
        assertEquals("Test1", result.getName());
        assertEquals(0, result.getRewardPoints().longValue());
        assertEquals(1.0, result.getTotalPurchases(), 0.001);
    }
}