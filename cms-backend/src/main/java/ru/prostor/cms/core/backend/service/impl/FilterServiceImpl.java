package ru.prostor.cms.core.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.prostor.cms.core.backend.exception.entity.FilterNotFoundException;
import ru.prostor.cms.core.backend.mapper.FilterMapper;
import ru.prostor.cms.core.backend.model.dto.response.FilterResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.FilterShortResponseDTO;
import ru.prostor.cms.core.backend.repository.FilterRepository;
import ru.prostor.cms.core.backend.service.FilterService;

import java.util.List;
import java.util.UUID;

@Service
public class FilterServiceImpl implements FilterService {
    private final FilterRepository filterRepository;
    private final FilterMapper filterMapper;

    public FilterServiceImpl(FilterRepository filterRepository, FilterMapper filterMapper) {
        this.filterRepository = filterRepository;
        this.filterMapper = filterMapper;
    }

    @Override
    public List<FilterShortResponseDTO> getFilters() {
        return filterRepository.findAll()
                .stream()
                .map(filterMapper::mapShortFilterToDTO)
                .toList();
    }

    @Override
    public FilterResponseDTO getFilter(UUID filterId) throws FilterNotFoundException {
        return filterRepository.findById(filterId)
                .map(filterMapper::mapFilterToDto)
                .orElseThrow(FilterNotFoundException::new);
    }
}
