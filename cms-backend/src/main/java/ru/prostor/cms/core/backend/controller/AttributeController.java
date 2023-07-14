package ru.prostor.cms.core.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.prostor.cms.core.backend.model.dto.request.AttributeRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.AttributeShortResponseDTO;
import ru.prostor.cms.core.backend.service.AttributeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attributes")
@Tag(name = "Атрибуты")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @Operation(summary = "Получение атрибутов")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AttributeShortResponseDTO> getAttributes() {
        return attributeService.getAttributes();
    }

    @Operation(summary = "Получение атрибута")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Attribute not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(value = "/{attributeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AttributeResponseDTO getAttribute(@PathVariable("attributeId") UUID attributeId) {
        return attributeService.getAttribute(attributeId);
    }

    @Operation(summary = "Создание атрибута")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createAttribute(@RequestBody AttributeRequestDTO attributeRequestDto) {
        attributeService.createAttribute(attributeRequestDto);
    }

    @Operation(summary = "Изменение атрибута")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Attribute not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(value = "/{attributeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAttribute(
            @PathVariable("attributeId") UUID attributeId,
            @RequestBody AttributeRequestDTO attributeRequestDto) {
        attributeService.updateAttribute(attributeId, attributeRequestDto);
    }
}
