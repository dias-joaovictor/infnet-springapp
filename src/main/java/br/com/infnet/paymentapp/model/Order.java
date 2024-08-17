package br.com.infnet.paymentapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends UUIDEntity {

    @Id
    @JdbcTypeCode(Types.CHAR)
    private UUID id;
    private LocalDate orderDate;
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<Payment> payments;

    @Transient
    private UUID customerId;
}

