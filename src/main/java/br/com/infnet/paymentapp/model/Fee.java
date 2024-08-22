package br.com.infnet.paymentapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Fee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fee extends UUIDEntity {
    @Id
    @JdbcTypeCode(Types.CHAR)
    private UUID id;
    private BigDecimal feeAmount;
    private LocalDate fromDate;
}

