package com.chris.oreillyclone.repository;

import com.chris.oreillyclone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Find Methods
    @Query("SELECT P FROM Product P WHERE P.id = ?1")
    Optional<Product> findProductById(String id);

    @Query("SELECT P FROM Product P WHERE P.title = ?1")
    List<Product> findByTitle(String title);

    @Query("SELECT P FROM Product P WHERE P.category = ?1")
    List<Product> findByCategory(String category);

    @Query("SELECT P FROM Product P WHERE (P.category.name = :category OR :category = '') AND (:minPrice IS NULL OR P.price >= :minPrice) AND (:maxPrice IS NULL OR P.price <= :maxPrice) ORDER BY CASE WHEN :sort = 'price_low' THEN P.price ELSE 0 END, CASE WHEN :sort = 'price_high' THEN P.price ELSE 1 END DESC")
    List<Product> filterProduct(@Param("category") String category, @Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice, @Param("sort") String sort);

    @Query("SELECT P FROM Product P where p.price between ?1 and ?2")
    List<Product> findProductsByPriceRange(double minPrice, double maxPrice);

    @Query(value = "SELECT * FROM products WHERE price > ?1", nativeQuery = true)
    List<Product> findProductsAbovePrice(double price);

    /**
     * Delete Methods
     */

    @Transactional
    @Modifying
    @Query("DELETE FROM Product P WHERE P.id = ?1")
    int deleteProductById(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.numRatings = 0")
    void deleteProductsWithNoRatings();

}
