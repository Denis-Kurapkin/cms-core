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
@Table(name = "manufacturer_j_attachment")
public class ManufacturerJAttachmentEntity {
    @EmbeddedId
    private ManufacturerJAttachmentCompositeKey manufacturerJAttachmentCompositeKey;

    @Column(name = "sort")
    private Integer sort;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", insertable = false, updatable = false)
    private ManufacturerEntity manufacturer;

    @ManyToOne
    @JoinColumn(name = "attachment_id", insertable = false, updatable = false)
    private AttachmentEntity attachment;

    public ManufacturerJAttachmentEntity() {
    }

    public ManufacturerJAttachmentEntity(UUID manufacturerId, UUID attachmentId, Integer sort) {
        this.manufacturerJAttachmentCompositeKey = new ManufacturerJAttachmentCompositeKey(manufacturerId, attachmentId);
        this.sort = sort;
    }

    public ManufacturerJAttachmentCompositeKey getManufacturerJAttachmentCompositeKey() {
        return manufacturerJAttachmentCompositeKey;
    }

    public void setManufacturerJAttachmentCompositeKey(ManufacturerJAttachmentCompositeKey manufacturerJAttachmentCompositeKey) {
        this.manufacturerJAttachmentCompositeKey = manufacturerJAttachmentCompositeKey;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
    }

    public AttachmentEntity getAttachment() {
        return attachment;
    }

    public void setAttachment(AttachmentEntity attachment) {
        this.attachment = attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerJAttachmentEntity that = (ManufacturerJAttachmentEntity) o;
        return Objects.equals(manufacturerJAttachmentCompositeKey, that.manufacturerJAttachmentCompositeKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerJAttachmentCompositeKey);
    }

    @Embeddable
    public static class ManufacturerJAttachmentCompositeKey implements Serializable {
        @Column(name = "manufacturer_id", nullable = false)
        private UUID manufacturerId;

        @Column(name = "attachment_id", nullable = false)
        private UUID attachmentId;

        public ManufacturerJAttachmentCompositeKey(UUID manufacturerId, UUID attachmentId) {
            this.manufacturerId = manufacturerId;
            this.attachmentId = attachmentId;
        }

        public ManufacturerJAttachmentCompositeKey() {

        }

        public UUID getManufacturerId() {
            return manufacturerId;
        }

        public void setManufacturerId(UUID manufacturerId) {
            this.manufacturerId = manufacturerId;
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
            ManufacturerJAttachmentCompositeKey that = (ManufacturerJAttachmentCompositeKey) o;
            return Objects.equals(manufacturerId, that.manufacturerId) && Objects.equals(attachmentId, that.attachmentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(manufacturerId, attachmentId);
        }
    }
}
