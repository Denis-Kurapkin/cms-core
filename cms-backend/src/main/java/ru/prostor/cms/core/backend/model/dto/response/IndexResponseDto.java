package ru.prostor.cms.core.backend.model.dto.response;

import ru.prostor.cms.core.backend.model.type.IndexStatus;

import java.time.LocalDate;

public record IndexResponseDto(int orderId, String clientName, IndexStatus indexStatus,
                               LocalDate date, double price) {
}
