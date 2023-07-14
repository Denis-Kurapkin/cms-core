package ru.prostor.cms.core.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "filter")
public class FilterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "filter_id")
    private UUID filterId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "filter_type")
    private String filterType;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private AttributeEntity attribute;

    @ManyToMany(targetEntity = CategoryEntity.class)
    @JoinTable(name = "filter_j_category",
            joinColumns = @JoinColumn(name = "filter_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;

    public UUID getFilterId() {
        return filterId;
    }

    public void setFilterId(UUID filterId) {
        this.filterId = filterId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public AttributeEntity getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeEntity attribute) {
        this.attribute = attribute;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterEntity filterEntity = (FilterEntity) o;
        return Objects.equals(filterId, filterEntity.filterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filterId);
    }
}
