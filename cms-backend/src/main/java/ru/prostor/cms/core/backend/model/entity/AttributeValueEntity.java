package ru.prostor.cms.core.backend.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "attribute_value")
public class AttributeValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attribute_value_id")
    private UUID id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private AttributeEntity attribute;

    public AttributeValueEntity() {
    }

    public AttributeValueEntity(String value, AttributeEntity attribute) {
        this.value = value;
        this.attribute = attribute;
    }

    public AttributeEntity getAttribute() {
        return attribute;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID attributeValueId) {
        this.id = attributeValueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeValueEntity that = (AttributeValueEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
