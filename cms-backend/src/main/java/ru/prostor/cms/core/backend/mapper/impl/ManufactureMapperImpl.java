package ru.prostor.cms.core.backend.mapper.impl;

import org.springframework.stereotype.Component;
import ru.prostor.cms.core.backend.mapper.ManufactureMapper;
import ru.prostor.cms.core.backend.model.dto.response.ImageResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.ManufacturerEntity;

@Component
public class ManufactureMapperImpl implements ManufactureMapper {
    @Override
    public ManufacturerResponseDTO mapManufactureToDto(ManufacturerEntity manufacturerEntity) {
        return new ManufacturerResponseDTO(
                manufacturerEntity.getId(),
                manufacturerEntity.getTitle(),
                manufacturerEntity.getAttachments()
                        .stream()
                        .map(a -> new ImageResponseDTO(
                                a.getAttachmentId(),
                                a.getAttachmentTitle()
                        ))
                        .toList()
        );
    }

    @Override
    public ManufacturerShortResponseDTO mapShortManufacturerToDTO(ManufacturerEntity manufacturer) {
        return new ManufacturerShortResponseDTO(manufacturer.getId());
    }


}
