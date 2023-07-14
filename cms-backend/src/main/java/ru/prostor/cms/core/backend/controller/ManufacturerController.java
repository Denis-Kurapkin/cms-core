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
import ru.prostor.cms.core.backend.model.dto.request.ManufacturerCreateDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ManufacturerShortResponseDTO;
import ru.prostor.cms.core.backend.service.ManufacturerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/manufacturers")
@Tag(name = "Производители")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @Operation(summary = "Получение производителей")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ManufacturerShortResponseDTO> getManufacturers() {
        return manufacturerService.getManufactures();
    }

    @Operation(summary = "Создание производителя")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createManufacturer(@RequestBody ManufacturerCreateDTO manufacturerCreateDTO) {
        manufacturerService.addManufacturer(manufacturerCreateDTO);
    }

    @Operation(summary = "Получение производителя")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(value = "/{manufactureId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ManufacturerResponseDTO getManufacturer(@PathVariable("manufactureId") UUID manufactureId) {
        return manufacturerService.getManufacturer(manufactureId);
    }

    @Operation(summary = "Изменение производителя")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(value = "/{manufactureId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateManufacturer(
            @PathVariable("manufactureId") UUID manufactureId,
            @RequestBody ManufacturerCreateDTO manufacturerCreateDTO) {
        manufacturerService.updateManufacturer(manufactureId, manufacturerCreateDTO);
    }
}
