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
public class ShipmentDetails {

	private String product_code;
	private String product_short_name;
	private String quantity_shipped;
	private String order_item_number;
	private List<String> imei_list;
	
}
