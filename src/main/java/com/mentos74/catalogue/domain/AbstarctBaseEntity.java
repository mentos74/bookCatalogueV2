package com.mentos74.catalogue.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
public  abstract  class AbstarctBaseEntity implements Serializable {

    @Column(name="deleted", columnDefinition = "boolean default false")
    private Boolean deleted;

    @Column(name = "secure_id", nullable = false, unique = true)
    private  String secureId = UUID.randomUUID().toString();
}
