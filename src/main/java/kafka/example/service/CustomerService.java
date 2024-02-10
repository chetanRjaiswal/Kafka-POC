package kafka.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import kafka.example.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public String add(List<Customer> customers) {
		if(!customers.isEmpty()) {
			for(Customer c: customers) {
				kafkaTemplate.send("TestTopic",c);
				System.out.println("*******msg published to kafka topic********");
			} 
		}
		return "customer record added to kafka queue";
	}
	
	
}
