package ru.prostor.cms.core.backend.model.dto.request;

import java.util.Collections;
import java.util.Set;

public record ManufacturerCreateDTO(String manufactureTitle, Set<ImageCreateRequestDTO> imageCreateDTO) {

    @Override
    public Set<ImageCreateRequestDTO> imageCreateDTO() {
        return imageCreateDTO == null ? Collections.emptySet() : imageCreateDTO;
    }
}
