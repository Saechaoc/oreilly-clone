package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.ProductException;
import com.chris.oreillyclone.model.Product;
import com.chris.oreillyclone.request.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public Product createProduct(CreateProductRequest createProductRequest);

    public ResponseEntity<String> deleteProduct(Long pid) throws ProductException;

    public Product updateProduct(Long pid, Product req) throws ProductException;

    public Product findProductById(Long pid) throws ProductException;

    public List<Product> findProductByCategory(String category);

    public Page<Product> getAllProducts(String category, String subcategory, double minPrice, double maxPrice, String sort, String stock, Integer pageNumber, Integer pageSize);

    public List<Product> findProductsByPriceRange(double minPrice, double maxPrice);
}
