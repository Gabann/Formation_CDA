package cda.tpdeliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto
{
	Map<Long, Integer> productQuantities = new HashMap<>();
	Long userId;
}
