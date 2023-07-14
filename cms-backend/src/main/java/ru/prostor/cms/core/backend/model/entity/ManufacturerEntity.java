package ru.prostor.cms.core.backend.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "manufacturer")
public class ManufacturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private UUID id;

    @Column
    private String title;

    @OneToMany(mappedBy = "manufacturer")
    private List<ManufacturerJAttachmentEntity> manufacturerJAttachments = new ArrayList<>();

    @ManyToMany(targetEntity = AttachmentEntity.class)
    @JoinTable(name = "manufacturer_j_attachment",
            joinColumns = @JoinColumn(name = "manufacturer_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id"))
    private List<AttachmentEntity> attachments = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer")
    private List<ProductEntity> products;

    public ManufacturerEntity() {
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public ManufacturerEntity(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID manufacturerId) {
        this.id = manufacturerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ManufacturerJAttachmentEntity> getManufacturerJAttachments() {
        return manufacturerJAttachments;
    }

    public void setManufacturerJAttachments(List<ManufacturerJAttachmentEntity> manufacturerJAttachments) {
        this.manufacturerJAttachments = manufacturerJAttachments;
    }

    public List<AttachmentEntity> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentEntity> attachments) {
        this.attachments = attachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerEntity that = (ManufacturerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
