package ru.prostor.cms.core.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product_j_attachment")
public class ProductJAttachmentEntity {
    @EmbeddedId
    private ProductJAttachmentEntityCompositeKey productJAttachmentEntityCompositeKey;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "attachment_id", insertable = false, updatable = false)
    private AttachmentEntity attachment;

    @Column(name = "sort")
    private Integer sort;

    public ProductJAttachmentEntity() {
    }

    public ProductJAttachmentEntity(ProductJAttachmentEntityCompositeKey productJAttachmentEntityCompositeKey, Integer sort) {
        this.productJAttachmentEntityCompositeKey = productJAttachmentEntityCompositeKey;
        this.sort = sort;
    }

    public ProductJAttachmentEntityCompositeKey getProductJAttachmentEntityCompositeKey() {
        return productJAttachmentEntityCompositeKey;
    }

    public void setProductJAttachmentEntityCompositeKey(ProductJAttachmentEntityCompositeKey productJAttachmentEntityCompositeKey) {
        this.productJAttachmentEntityCompositeKey = productJAttachmentEntityCompositeKey;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public AttachmentEntity getAttachment() {
        return attachment;
    }

    public void setAttachment(AttachmentEntity attachment) {
        this.attachment = attachment;
    }

    @Embeddable
    public static class ProductJAttachmentEntityCompositeKey implements Serializable {
        @Column(name = "product_id", nullable = false)
        private UUID productId;

        @Column(name = "attachment_id", nullable = false)
        private UUID attachmentId;

        public UUID getProductId() {
            return productId;
        }

        public void setProductId(UUID manufacturerId) {
            this.productId = manufacturerId;
        }

        public UUID getAttachmentId() {
            return attachmentId;
        }

        public void setAttachmentId(UUID attachmentId) {
            this.attachmentId = attachmentId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductJAttachmentEntityCompositeKey that = (ProductJAttachmentEntityCompositeKey) o;
            return Objects.equals(productId, that.productId) && Objects.equals(attachmentId, that.attachmentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(productId, attachmentId);
        }
    }
}
