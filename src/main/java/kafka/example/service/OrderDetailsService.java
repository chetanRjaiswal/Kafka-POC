package kafka.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import kafka.example.entity.OrderDetails;

@Service
public class OrderDetailsService {

	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;

	public String add(String  orderDetails) throws JsonMappingException, JsonProcessingException {
		OrderDetails order = new ObjectMapper().readValue(orderDetails, OrderDetails.class);  
		kafkaTemplate.send("OrderShipment",order);
		return "order added to kafka topic SuccessFully";
	}
}
