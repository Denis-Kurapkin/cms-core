package ru.prostor.cms.core.backend.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "attribute")
public class AttributeEntity {
    @Id
    @Column(name = "attribute_id")
    @GeneratedValue
    private UUID attributeId;

    @Column
    private String title;

    @OneToMany(targetEntity = AttributeValueEntity.class, mappedBy = "attribute")
    private List<AttributeValueEntity> attributeValues;

    @OneToMany(targetEntity = FilterEntity.class)
    @JoinColumn(name = "attribute_id")
    private List<FilterEntity> filters;

    public AttributeEntity() {
    }

    public AttributeEntity(String title) {
        this.title = title;
    }

    public UUID getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(UUID attributeId) {
        this.attributeId = attributeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AttributeValueEntity> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValueEntity> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public List<FilterEntity> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterEntity> filters) {
        this.filters = filters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeEntity that = (AttributeEntity) o;
        return Objects.equals(attributeId, that.attributeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeId);
    }
}
