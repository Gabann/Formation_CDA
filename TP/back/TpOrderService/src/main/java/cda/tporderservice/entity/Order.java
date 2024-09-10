package cda.tporderservice.entity;

import cda.tporderservice.dto.ProductDto;
import cda.tporderservice.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
			name = "order_product_ids",
			joinColumns = @JoinColumn(name = "order_id")
	)
	@Column(name = "product_id")
	List<Long> productIds;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
}
