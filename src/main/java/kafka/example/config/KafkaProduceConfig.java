package kafka.example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;



@Configuration
public class KafkaProduceConfig {
	
	//this method is used to kafka producer config details
	@Bean
	public ProducerFactory<String, Object> producerFactory(){
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"kafka.example.config.CustomSerializer");
		configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	//this method is used to create kafkatemplate bean obj
	@Bean
	public 	KafkaTemplate<String,Object> kafkaTemplate(){
		return new KafkaTemplate<String,Object>(producerFactory());
	}
	
}
