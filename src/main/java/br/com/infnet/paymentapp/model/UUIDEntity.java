package br.com.infnet.paymentapp.model;

import jakarta.persistence.PrePersist;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@NoArgsConstructor
@SuperBuilder
public abstract class UUIDEntity implements ModelEntity {

    @PrePersist
    public void prePersist() {
        if (getId() == null) {
            setId(UUID.randomUUID());
        }
    }

    public abstract UUID getId();

    public abstract void setId(UUID id);

}
