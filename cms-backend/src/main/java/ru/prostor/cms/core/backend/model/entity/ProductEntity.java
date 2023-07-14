package ru.prostor.cms.core.backend.model.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private UUID productId;

    @ManyToMany(targetEntity = AttributeValueEntity.class)
    @JoinTable(name = "attribute_j_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_value_id"))
    private List<AttributeValueEntity> attributeValues;

    @OneToMany(mappedBy = "product")
    private List<ProductJAttachmentEntity> productJAttachments;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerEntity manufacturer;

    @Column
    private String title;

    @Column
    private String article;

    @Column(columnDefinition = "NUMERIC(10, 2)")
    private Double price;

    @Column
    private Integer quantity;

    @Column(name = "is_active")
    private boolean isActive;

    @Column
    private String description;

    public ProductEntity() {
    }

    public ProductEntity(UUID productId,
                         CategoryEntity category,
                         ManufacturerEntity manufacturer,
                         String title,
                         String article,
                         double price,
                         int quantity,
                         boolean isActive,
                         String description,
                         List<AttributeValueEntity> attributeValues) {
        this.productId = productId;
        this.attributeValues = attributeValues;
        this.category = category;
        this.manufacturer = manufacturer;
        this.title = title;
        this.article = article;
        this.price = price;
        this.quantity = quantity;
        this.isActive = isActive;
        this.description = description;
    }

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEntity manufacturerId) {
        this.manufacturer = manufacturerId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity categoryId) {
        this.category = categoryId;
    }

    public List<AttributeValueEntity> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValueEntity> values) {
        this.attributeValues = values;
    }

    public List<ProductJAttachmentEntity> getProductJAttachments() {
        return productJAttachments;
    }

    public void setProductJAttachments(List<ProductJAttachmentEntity> productJAttachment) {
        this.productJAttachments = productJAttachment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity productEntity = (ProductEntity) o;
        return Objects.equals(productId, productEntity.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
