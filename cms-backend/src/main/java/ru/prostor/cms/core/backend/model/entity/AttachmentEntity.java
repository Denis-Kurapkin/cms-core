package ru.prostor.cms.core.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "attachment")
public class AttachmentEntity {
    @Id
    @Column(name = "attachment_id")
    @GeneratedValue
    private UUID attachmentId;

    @Column(name = "attachment_title")
    private String attachmentTitle;

    @Column(name = "attachment_url")
    private String attachmentUrl;

    @Column(name = "attachment_mime")
    private String attachmentMime;

    public AttachmentEntity() {
    }

    public AttachmentEntity(String attachmentTitle, String attachmentUrl, String attachmentMime) {
        this.attachmentTitle = attachmentTitle;
        this.attachmentUrl = attachmentUrl;
        this.attachmentMime = attachmentMime;
    }

    public UUID getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(UUID attributeId) {
        this.attachmentId = attributeId;
    }

    public String getAttachmentTitle() {
        return attachmentTitle;
    }

    public void setAttachmentTitle(String attachmentTitle) {
        this.attachmentTitle = attachmentTitle;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getAttachmentMime() {
        return attachmentMime;
    }

    public void setAttachmentMime(String attachmentMime) {
        this.attachmentMime = attachmentMime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachmentEntity that = (AttachmentEntity) o;
        return Objects.equals(attachmentId, that.attachmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachmentId);
    }
}
