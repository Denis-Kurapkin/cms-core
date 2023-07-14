package ru.prostor.cms.core.backend.mapper;

import ru.prostor.cms.core.backend.model.dto.response.FilterResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.FilterShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.FilterEntity;

/**
 * Конвертация фильтров Entity -> DTO
 */
public interface FilterMapper {
    FilterResponseDTO mapFilterToDto(FilterEntity filter);

    FilterShortResponseDTO mapShortFilterToDTO(FilterEntity filter);
}
