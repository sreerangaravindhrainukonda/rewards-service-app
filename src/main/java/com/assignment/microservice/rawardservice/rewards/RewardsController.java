package com.assignment.microservice.rawardservice.rewards;

import java.util.List;

import com.assignment.microservice.rawardservice.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RewardsController {

	@Autowired
	private RewardsService rewardsService;
	

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> findCustomerAll() {
		List<CustomerDTO> customerAll = rewardsService.getCustomerAll();
		return new ResponseEntity<List<CustomerDTO>>(customerAll, HttpStatus.OK);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer id) {
		CustomerDTO customerDTO = rewardsService.getCustomerById(id);
		if (customerDTO == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
	}
	
	
}




