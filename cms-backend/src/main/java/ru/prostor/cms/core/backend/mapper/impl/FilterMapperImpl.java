package ru.prostor.cms.core.backend.mapper.impl;

import org.springframework.stereotype.Component;
import ru.prostor.cms.core.backend.mapper.FilterMapper;
import ru.prostor.cms.core.backend.model.dto.response.FilterResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.FilterShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.FilterEntity;

@Component
public class FilterMapperImpl implements FilterMapper {
    @Override
    public FilterResponseDTO mapFilterToDto(FilterEntity filter) {
        return new FilterResponseDTO(
                filter.getFilterId(),
                filter.getAttribute().getTitle()
        );
    }

    @Override
    public FilterShortResponseDTO mapShortFilterToDTO(FilterEntity filter) {
        return new FilterShortResponseDTO(filter.getFilterId());
    }
}
