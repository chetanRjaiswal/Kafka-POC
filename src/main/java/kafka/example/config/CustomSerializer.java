package kafka.example.config;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.example.entity.OrderDetails;

public class CustomSerializer implements Serializer<OrderDetails> {

	@Override
	public byte[] serialize(String topic, OrderDetails data) 
	{
		final ObjectMapper objectMapper = new ObjectMapper();
		
		try 
		{
			if (data == null) {
				System.out.println("Null received at serializing");
				return null;
			}
			
			System.out.println("Serializing...");
			return objectMapper.writeValueAsBytes(data);
		}
		catch (Exception e) {
			throw new SerializationException("Error when serializing MessageDto to byte[]");
		}
	}
	
}
