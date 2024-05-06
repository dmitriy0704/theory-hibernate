package dev.folomkin.hibernate.starter.entity;

import java.io.Serializable;
import java.time.Instant;

public abstract class AuditableEntity<T extends Serializable> implements BaseEntity<T> {

    private Instant createdAt;

    private String createdBy;

}
