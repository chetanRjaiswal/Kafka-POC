package kafka.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kafka.example.entity.Customer;

@Service
public class CustomerService {

	@KafkaListener(topics = "TestTopic", groupId = "group_customer", containerFactory = "kafkaListnerContainerFactory")
	public Customer listener(Customer c) {
		System.out.println("****message recived from kafka topic ::" + c);
		return c;
	}

}
