package ru.prostor.cms.core.backend.mapper.impl;

import org.springframework.stereotype.Component;
import ru.prostor.cms.core.backend.mapper.ImageMapper;
import ru.prostor.cms.core.backend.model.dto.response.ImageResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ImageShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.AttachmentEntity;

@Component
public class ImageMapperImpl implements ImageMapper {
    public ImageResponseDTO mapImageDto(AttachmentEntity attachment) {
        return new ImageResponseDTO(
                attachment.getAttachmentId(),
                attachment.getAttachmentTitle()
        );
    }

    @Override
    public ImageShortResponseDTO mapShortImageToDTO(AttachmentEntity attachment) {
        return new ImageShortResponseDTO(attachment.getAttachmentId());
    }
}
