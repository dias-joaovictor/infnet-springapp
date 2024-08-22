package br.com.infnet.paymentapp.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public abstract class UUIDEntity implements ModelEntity<UUID> {

    @PrePersist
    public void prePersist() {
        if (getId() == null) {
            setId(UUID.randomUUID());
        }
    }

}
