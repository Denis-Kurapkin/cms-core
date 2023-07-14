package ru.prostor.cms.core.backend.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record AttributeRequestDTO(@NotEmpty String attributeTitle, Set<String> attributeValues) {
}