package cda.tporderservice.entity;

import cda.tporderservice.dto.ProductDto;
import cda.tporderservice.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order
{
	@Transient
	public List<ProductDto> productsDto;

	@Transient
	public UserDto userDto;

	@Column(name = "user_id", nullable = false)
	Long userId;

	@ElementCollection
	@CollectionTable(
			name = "order_product_quantities",
			joinColumns = @JoinColumn(name = "order_id")
	)
	@MapKeyColumn(name = "product_id")
	@Column(name = "quantity")
	Map<Long, Integer> productQuantities = new HashMap<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
}
