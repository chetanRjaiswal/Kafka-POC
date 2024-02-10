package kafka.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kafka.example.entity.OrderDetails;

@Service
public class OrderDetailsService {

	@KafkaListener(topics = "OrderShipment", groupId = "group_ordershipment", containerFactory = "kafkaListnerContainerFactory")
	public OrderDetails listener(OrderDetails order) {
		System.out.println("****message recived from kafka topic ::" + order);
		System.out.println("****order shipment from kafka topic ::" + order.getShipment_details());
		return order;
	}
	
	/*
	 @KafkaListener( groupId = "group_json", containerFactory = "userKafkaListenerFactory", topicPartitions =
	         {@org.springframework.kafka.annotation.TopicPartition(topic = "Kafka_Topic", partitions = {"0"},
	                 partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "3")),
	                 @org.springframework.kafka.annotation.TopicPartition(topic = "Kafka_Topic_2", partitions = {"0"},
	                         partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "4"))
	         }) 
	 */
	

}
