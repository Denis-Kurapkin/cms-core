package ru.prostor.cms.core.backend.model.dto.request;

import java.util.List;

public record CategoryCreateRequestDTO(String title, String parentCategory, List<String> filters) {
}