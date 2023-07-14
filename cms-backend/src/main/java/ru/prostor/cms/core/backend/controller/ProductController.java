package ru.prostor.cms.core.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.prostor.cms.core.backend.model.dto.request.ProductRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductShortResponseDTO;
import ru.prostor.cms.core.backend.service.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@Tag(name = "Товары")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Получение товаров")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )


    @GetMapping()
    public List<ProductShortResponseDTO> getProducts(){
        return productService.getProducts();
    }

    @Operation(summary = "Получение товара")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @GetMapping("/{productId}")
    public ProductResponseDTO getProduct(@PathVariable("productId")UUID productId){
        return productService.getProduct(productId);
    }

    @Operation(summary = "Создание товара")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        productService.createProduct(productRequestDTO);
    }

    @Operation(summary = "Обновление товара")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @PostMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@PathVariable("productId") UUID productId,
                              @RequestBody ProductRequestDTO productRequestDTO){
        productService.updateProduct(productId, productRequestDTO);
    }


    @Operation(summary = "Удаление товара")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            }
    )
    @DeleteMapping(value = "/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable ("productId") UUID productId){
        productService.deleteProduct(productId);
    }
}
