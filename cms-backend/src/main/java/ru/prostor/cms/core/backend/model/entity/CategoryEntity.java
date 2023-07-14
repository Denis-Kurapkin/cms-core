package ru.prostor.cms.core.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import ru.prostor.cms.core.backend.model.type.CategoryStatus;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private UUID id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private CategoryEntity parentCategory;

    @OneToMany(targetEntity = ProductEntity.class)
    @JoinColumn(name = "category_id")
    private List<ProductEntity> products;

    @ManyToMany(targetEntity = FilterEntity.class)
    @JoinTable(name = "filter_j_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "filter_id"))
    private List<FilterEntity> filters;

    public CategoryEntity() {
    }

    public CategoryEntity(String title, CategoryStatus status, CategoryEntity parentCategory, List<FilterEntity> filters) {
        this.title = title;
        this.status = status;
        this.parentCategory = parentCategory;
        this.filters = filters;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID categoryId) {
        this.id = categoryId;
    }

    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryEntity getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryEntity parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
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
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
