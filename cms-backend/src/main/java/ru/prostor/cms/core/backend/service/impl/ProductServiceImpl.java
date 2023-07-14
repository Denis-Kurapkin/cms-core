package ru.prostor.cms.core.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.prostor.cms.core.backend.exception.entity.CategoryNotFoundException;
import ru.prostor.cms.core.backend.exception.entity.ManufacturerNotFoundException;
import ru.prostor.cms.core.backend.exception.entity.ProductNotFoundException;
import ru.prostor.cms.core.backend.mapper.ProductMapper;
import ru.prostor.cms.core.backend.model.dto.request.AttributeValueRequestDTO;
import ru.prostor.cms.core.backend.model.dto.request.ProductRequestDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductResponseDTO;
import ru.prostor.cms.core.backend.model.dto.response.ProductShortResponseDTO;
import ru.prostor.cms.core.backend.model.entity.ProductEntity;
import ru.prostor.cms.core.backend.repository.AttributeValueRepository;
import ru.prostor.cms.core.backend.repository.CategoryRepository;
import ru.prostor.cms.core.backend.repository.ManufactureRepository;
import ru.prostor.cms.core.backend.repository.ProductRepository;
import ru.prostor.cms.core.backend.service.ProductService;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ManufactureRepository manufactureRepository;
    private final AttributeValueRepository attributeValueRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository, ManufactureRepository manufactureRepository, AttributeValueRepository attributeValueRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
        this.manufactureRepository = manufactureRepository;
        this.attributeValueRepository = attributeValueRepository;
    }

    @Override
    public List<ProductShortResponseDTO> getProducts() {
        return productRepository.findAll().stream().map(productMapper::mapProductsToDTO).toList();
    }

    public ProductResponseDTO getProduct(UUID productId) {
        return productRepository.findById(productId)
                .map(productMapper::mapProductToDTO)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void createProduct(ProductRequestDTO productRequestDTO) { //TODO check it
        productRepository.save(
                new ProductEntity(
                        productRequestDTO.productId(),
                        categoryRepository.findCategoryEntityById(productRequestDTO.categoryId()),
                        manufactureRepository.findManufacturerEntityById(productRequestDTO.manufacturerId()),
                        productRequestDTO.title(),
                        productRequestDTO.article(),
                        productRequestDTO.price(),
                        productRequestDTO.quantity(),
                        productRequestDTO.isActive(),
                        productRequestDTO.description(),
                        attributeValueRepository.findAttributeValueEntitiesByIdIn(
                                productRequestDTO.attributeValues()
                                        .stream()
                                        .map(AttributeValueRequestDTO::attributeValueId)
                                        .toList()
                        )
                )
        );
    }

    @Override
    public void updateProduct(UUID productId, ProductRequestDTO productRequestDTO) throws ProductNotFoundException {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        product.setCategory(categoryRepository.findById(productId)
                .orElseThrow(CategoryNotFoundException::new));
        product.setManufacturer(manufactureRepository.findById(productId)
                .orElseThrow(ManufacturerNotFoundException::new));
        product.setTitle(productRequestDTO.title());
        product.setArticle(productRequestDTO.article());
        product.setPrice(productRequestDTO.price());
        product.setQuantity(productRequestDTO.quantity());
        product.setActive(productRequestDTO.isActive());
        product.setDescription(productRequestDTO.description());
    }

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }
}
