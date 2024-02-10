package kafka.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kafka.example.entity.Customer;
import kafka.example.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	

	@PostMapping(value = "/addCustomer",consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public String addCustomer(@RequestBody List<Customer> customers) {
		return customerService.add(customers);
	}
	
}




/*----------------

@GetMapping(value = "/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAll(){
		Customer c1 = new Customer(1,"chetan","chetan@gmail.com");
		Customer c2 = new Customer(1,"chetan","chetan@gmail.com");
		Customer c3 = new Customer(1,"chetan","chetan@gmail.com");
		List<Customer> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		return list;
	}

*/