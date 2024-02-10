package kafka.example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import kafka.example.entity.OrderDetails;


@Configuration
public class KafkaConsumeConfig {
	
	@Bean
	public ConsumerFactory<String, OrderDetails> consumerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "kafka.example.config.CustomDeserializer");
		config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_ordershipment");
		config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new CustomDeserializer());
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, OrderDetails> kafkaListnerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory <String, OrderDetails> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	
}
