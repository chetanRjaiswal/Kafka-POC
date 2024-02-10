package kafka.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	ArrayList<String> messages = new ArrayList<String>();
	
	@GetMapping("/consumeFromTopic")
	public List<String> getMessageFromTopic(){
		return messages;
	}
	
	/*
	 * @KafkaListener(groupId = "group_customer", topics = "TestKafka" ,
	 * containerFactory = "kafkaListnerContainerFactory") public List<String>
	 * consumeFromTopic(String data){ messages.add(data); return messages; }
	 */
	
}
