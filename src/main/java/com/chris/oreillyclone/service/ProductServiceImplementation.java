package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.ProductException;
import com.chris.oreillyclone.model.Product;
import com.chris.oreillyclone.model.User;
import com.chris.oreillyclone.repository.CategoryRepository;
import com.chris.oreillyclone.repository.ProductRepository;
import com.chris.oreillyclone.request.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryRepository categoryRepository;

    public ProductServiceImplementation(ProductRepository productRepository, UserService userService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(CreateProductRequest createProductRequest) {
        return null;
    }

    @Override
    public String deleteProdcut(Long pid) throws ProductException {
        return null;
    }

    @Override
    public Product updateProduct(Long pid, Product product) throws ProductException {
        return null;
    }

    @Override
    public Product findProductById(Long pid) throws ProductException {
        return null;
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return null;
    }

    @Override
    public Page<Product> getAllProducts(String category, String subcategory, Integer minPrice, Integer maxPrice, String sort, String stock, Integer pageNumber, Integer pageSize) {
        return null;
    }
}
