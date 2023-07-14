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
import ru.prostor.cms.core.backend.model.dto.request.CategoryCreateRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.CategoryShortResponseDTO;
import ru.prostor.cms.core.backend.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@Tag(name = "Категории")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Получение категорий")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryShortResponseDTO> getCategories() {
        return categoryService.getCategories();
    }

    @Operation(summary = "Создание категории")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createCategory(@RequestBody CategoryCreateRequestDTO categoryCreateRequestDto) {
        categoryService.createCategory(categoryCreateRequestDto);
    }

    @Operation(summary = "Получение категории")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryResponseDTO getCategory(@PathVariable("categoryId") UUID categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @Operation(summary = "Изменение категории")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(value = "/{categoryId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(
            @PathVariable("categoryId") UUID categoryId,
            @RequestBody CategoryCreateRequestDTO categoryCreateRequestDto) {
        categoryService.updateCategory(categoryId, categoryCreateRequestDto);
    }
}
