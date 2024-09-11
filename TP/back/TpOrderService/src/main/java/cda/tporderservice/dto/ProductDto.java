package cda.tporderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto
{
	String name;
	String description;
	double price;
	String category;
	int stock;
	int quantity;
}
