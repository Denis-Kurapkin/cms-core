package ru.prostor.cms.core.backend.mapper;

import ru.prostor.cms.core.backend.model.dto.response.ManufacturerResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.ManufacturerEntity;

public interface ManufactureMapper {
    ManufacturerResponseDTO mapManufactureToDto(ManufacturerEntity manufacturerEntity);

    ManufacturerShortResponseDTO mapShortManufacturerToDTO(ManufacturerEntity manufacturer);
}
