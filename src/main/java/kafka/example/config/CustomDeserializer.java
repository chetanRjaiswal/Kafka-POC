package kafka.example.config;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.example.entity.OrderDetails;

public class CustomDeserializer implements Deserializer<OrderDetails> {

	@Override
	public OrderDetails deserialize(String topic, byte[] data) {

		final ObjectMapper objectMapper = new ObjectMapper();

		try {
			if (data == null) {
				System.out.println("Null received at deserializing");
				return null;
			}
			System.out.println("Deserializing...");
			return objectMapper.readValue(new String(data, "UTF-8"), OrderDetails.class);
		} catch (Exception e) {
			throw new SerializationException("Error when deserializing byte[] to orderDetails");
		}
	}
}
