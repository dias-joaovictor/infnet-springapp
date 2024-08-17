package br.com.infnet.paymentapp.dao;

import br.com.infnet.paymentapp.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface FeeRepository extends JpaRepository<Fee, UUID> {

    @Query(
            value = """
                        select 
                            * 
                        from Fee
                        where fromDate <= :date
                        order by fromDate desc
                        limit 1
                    """,
            nativeQuery = true)
    Optional<Fee> findFeeForDate(@Param("date") LocalDate date);

}
