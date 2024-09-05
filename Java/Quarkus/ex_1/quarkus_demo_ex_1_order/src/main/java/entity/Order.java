package entity;

import dto.ClientDto;
import dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private LocalDateTime orderDate;
    @Column(name= "product_id")
    private Long productId;
    @Column(name= "client_id")
    private Long clientId;

    @Transient
    public ProductDto productDto;

    @Transient
    public ClientDto clientDto;







}


