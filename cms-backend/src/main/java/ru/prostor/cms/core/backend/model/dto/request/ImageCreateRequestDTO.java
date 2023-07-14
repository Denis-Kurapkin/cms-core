package ru.prostor.cms.core.backend.model.dto.request;

import java.util.UUID;

public record ImageCreateRequestDTO(UUID imageId, int sort) {
}
