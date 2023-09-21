package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.ProductException;
import com.chris.oreillyclone.model.Product;
import com.chris.oreillyclone.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Product createProduct(CreateProductRequest createProductRequest);

    public String deleteProduct(Long pid) throws ProductException;

    public Product updateProduct(Long pid, Product product) throws ProductException;

    public Product findProductById(Long pid) throws ProductException;

    public List<Product> findProductByCategory(String category);

    public Page<Product> getAllProducts(String category, String subcategory, double minPrice, double maxPrice, String sort, String stock, Integer pageNumber, Integer pageSize);
}
