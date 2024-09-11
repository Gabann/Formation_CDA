package cda.tpdeliveryservice.entity;

import cda.tpdeliveryservice.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "`delivery`")
public class Delivery
{
	@Transient
	public OrderDto orderDto;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "order_id", nullable = false)
	private Long orderId;

	@Column(name = "delivery_date", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate deliveryDate;

	@Column(name = "delivery_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;

	@Column(name = "delivery_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private DeliveryType deliveryType;

	public enum DeliveryStatus
	{
		DELIVERED,
		IN_DELIVERY,
		NOT_DELIVERED
	}

	public enum DeliveryType
	{
		EXPRESS,
		NORMAL,
		LOW_COST
	}
}
