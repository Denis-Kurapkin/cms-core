package ru.prostor.cms.core.backend.service;

import ru.prostor.cms.core.backend.exception.entity.ProductNotFoundException;
import ru.prostor.cms.core.backend.model.dto.request.ProductRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductShortResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductShortResponseDTO> getProducts();

    ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException;

    void createProduct(ProductRequestDTO productRequestDTO);

    void updateProduct(UUID productId, ProductRequestDTO productRequestDTO) throws ProductNotFoundException;

    void deleteProduct(UUID productId);
}
