package com.chris.oreillyclone.repository;

import com.chris.oreillyclone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT P FROM Product P WHERE (P.category.name = :category OR :category = '') AND (:minPrice IS NULL OR P.price >= :minPrice) AND (:maxPrice IS NULL OR P.price <= :maxPrice) ORDER BY CASE WHEN :sort = 'price_low' THEN P.price ELSE 0 END, CASE WHEN :sort = 'price_high' THEN P.price ELSE 1 END DESC")
    List<Product> filterProduct(@Param("category") String category, @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice, @Param("sort") String sort);
}
