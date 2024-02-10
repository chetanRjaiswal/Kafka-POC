package kafka.example.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetails { 
	
	private String epicor_order_number;
	private String salesforce_order_number;
	private String salesforce_account_id;
	private String packing_slip_number;
	private List<ShipmentDetails> shipment_details;
	
}
