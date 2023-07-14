package ru.prostor.cms.core.backend.model.dto.response;

import java.util.List;
import java.util.UUID;

public record ManufacturerResponseDTO(UUID manufactureId, String manufactureTitle, List<ImageResponseDTO> imageDTOS) {
}
