package ru.prostor.cms.core.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prostor.cms.core.backend.model.dto.response.FilterResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.FilterShortResponseDTO;
import ru.prostor.cms.core.backend.service.FilterService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filters")
@Tag(name = "Фильтры")
public class FilterController {
    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @Operation(summary = "Получение фильтров")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilterShortResponseDTO> getFilters() {
        return filterService.getFilters();
    }

    @Operation(summary = "Получение фильтра")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(value = "/{filterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilterResponseDTO getFilter(@PathVariable("filterId") UUID filterId) {
        return filterService.getFilter(filterId);
    }
}
