package com.chris.oreillyclone.service;

import com.chris.oreillyclone.exception.ProductException;
import com.chris.oreillyclone.model.Category;
import com.chris.oreillyclone.model.Product;
import com.chris.oreillyclone.repository.CategoryRepository;
import com.chris.oreillyclone.repository.ProductRepository;
import com.chris.oreillyclone.request.CreateProductRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ProductServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplementationTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImplementation productServiceImplementation;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link ProductServiceImplementation#createProduct(CreateProductRequest)}
     */
    @Test
    void testCreateProduct() {
        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(1L);
        parentCategory2.setLevel(1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("Name");
        parentCategory3.setParentCategory(parentCategory2);

        Category category = new Category();
        category.setId(1L);
        category.setLevel(1);
        category.setName("Name");
        category.setParentCategory(parentCategory3);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImageUrl("https://example.org/example");
        product.setNumRatings(10);
        product.setPrice(10.0d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(1);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Dr");
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);

        Category parentCategory4 = new Category();
        parentCategory4.setId(1L);
        parentCategory4.setLevel(1);
        parentCategory4.setName("Name");
        parentCategory4.setParentCategory(new Category());

        Category parentCategory5 = new Category();
        parentCategory5.setId(1L);
        parentCategory5.setLevel(1);
        parentCategory5.setName("Name");
        parentCategory5.setParentCategory(parentCategory4);

        Category parentCategory6 = new Category();
        parentCategory6.setId(1L);
        parentCategory6.setLevel(1);
        parentCategory6.setName("Name");
        parentCategory6.setParentCategory(parentCategory5);

        Category parentCategory7 = new Category();
        parentCategory7.setId(1L);
        parentCategory7.setLevel(1);
        parentCategory7.setName("Name");
        parentCategory7.setParentCategory(parentCategory6);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setLevel(1);
        category2.setName("Name");
        category2.setParentCategory(parentCategory7);

        Category parentCategory8 = new Category();
        parentCategory8.setId(1L);
        parentCategory8.setLevel(1);
        parentCategory8.setName("Name");
        parentCategory8.setParentCategory(new Category());

        Category parentCategory9 = new Category();
        parentCategory9.setId(1L);
        parentCategory9.setLevel(1);
        parentCategory9.setName("Name");
        parentCategory9.setParentCategory(parentCategory8);

        Category parentCategory10 = new Category();
        parentCategory10.setId(1L);
        parentCategory10.setLevel(1);
        parentCategory10.setName("Name");
        parentCategory10.setParentCategory(parentCategory9);

        Category parentCategory11 = new Category();
        parentCategory11.setId(1L);
        parentCategory11.setLevel(1);
        parentCategory11.setName("Name");
        parentCategory11.setParentCategory(parentCategory10);

        Category category3 = new Category();
        category3.setId(1L);
        category3.setLevel(1);
        category3.setName("Name");
        category3.setParentCategory(parentCategory11);

        Category parentCategory12 = new Category();
        parentCategory12.setId(1L);
        parentCategory12.setLevel(1);
        parentCategory12.setName("Name");
        parentCategory12.setParentCategory(new Category());

        Category parentCategory13 = new Category();
        parentCategory13.setId(1L);
        parentCategory13.setLevel(1);
        parentCategory13.setName("Name");
        parentCategory13.setParentCategory(parentCategory12);

        Category parentCategory14 = new Category();
        parentCategory14.setId(1L);
        parentCategory14.setLevel(1);
        parentCategory14.setName("Name");
        parentCategory14.setParentCategory(parentCategory13);

        Category parentCategory15 = new Category();
        parentCategory15.setId(1L);
        parentCategory15.setLevel(1);
        parentCategory15.setName("Name");
        parentCategory15.setParentCategory(parentCategory14);

        Category category4 = new Category();
        category4.setId(1L);
        category4.setLevel(1);
        category4.setName("Name");
        category4.setParentCategory(parentCategory15);
        when(categoryRepository.findByNameAndParent(Mockito.<String>any(), Mockito.<String>any())).thenReturn(category4);
        when(categoryRepository.findCategoryByName(Mockito.<String>any())).thenReturn(category2);
        when(categoryRepository.save(Mockito.<Category>any())).thenReturn(category3);

        CreateProductRequest req = new CreateProductRequest();
        req.setBrand("Brand");
        req.setDescription("The characteristics of someone or something");
        req.setImageUrl("https://example.org/example");
        req.setPrice(1);
        req.setProductFamily("Product Family");
        req.setProductLine("Product Line");
        req.setQuantity(1);
        req.setSecondLevelCategory("Second Level Category");
        req.setThirdLevelCategory("Third Level Category");
        req.setTitle("Dr");
        req.setTopLevelCategory("Top Level Category");
        assertSame(product, productServiceImplementation.createProduct(req));
        verify(productRepository).save(Mockito.<Product>any());
        verify(categoryRepository, atLeast(1)).findByNameAndParent(Mockito.<String>any(), Mockito.<String>any());
        verify(categoryRepository).findCategoryByName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct() throws ProductException {
        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(1L);
        parentCategory2.setLevel(1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(1L);
        category.setLevel(1);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImageUrl("https://example.org/example");
        product.setNumRatings(10);
        product.setPrice(10.0d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(1);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Dr");
        Optional<Product> ofResult = Optional.of(product);
        doNothing().when(productRepository).delete(Mockito.<Product>any());
        when(productRepository.findProductById(Mockito.<Long>any())).thenReturn(ofResult);
        ResponseEntity<String> actualDeleteProductResult = productServiceImplementation.deleteProduct(1L);
        assertEquals("Product with ID: 1 deleted successfully", actualDeleteProductResult.getBody());
        assertEquals(200, actualDeleteProductResult.getStatusCodeValue());
        assertTrue(actualDeleteProductResult.getHeaders().isEmpty());
        verify(productRepository).findProductById(Mockito.<Long>any());
        verify(productRepository).delete(Mockito.<Product>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct2() throws ProductException {
        Optional<Product> emptyResult = Optional.empty();
        when(productRepository.findProductById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(ProductException.class, () -> productServiceImplementation.deleteProduct(1L));
        verify(productRepository).findProductById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#updateProduct(Long, Product)}
     */
    @Test
    void testUpdateProduct() throws ProductException {
        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(1L);
        parentCategory2.setLevel(1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(1L);
        category.setLevel(1);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImageUrl("https://example.org/example");
        product.setNumRatings(10);
        product.setPrice(10.0d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(1);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Dr");
        Optional<Product> ofResult = Optional.of(product);

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("Name");
        parentCategory3.setParentCategory(new Category());

        Category parentCategory4 = new Category();
        parentCategory4.setId(1L);
        parentCategory4.setLevel(1);
        parentCategory4.setName("Name");
        parentCategory4.setParentCategory(parentCategory3);

        Category parentCategory5 = new Category();
        parentCategory5.setId(1L);
        parentCategory5.setLevel(1);
        parentCategory5.setName("Name");
        parentCategory5.setParentCategory(parentCategory4);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setLevel(1);
        category2.setName("Name");
        category2.setParentCategory(parentCategory5);

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product2.setDescription("The characteristics of someone or something");
        product2.setId(1L);
        product2.setImageUrl("https://example.org/example");
        product2.setNumRatings(10);
        product2.setPrice(10.0d);
        product2.setProductFamily("Product Family");
        product2.setProductLine("Product Line");
        product2.setQuantity(1);
        product2.setRatingList(new ArrayList<>());
        product2.setReviewList(new ArrayList<>());
        product2.setTitle("Dr");
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
        when(productRepository.findProductById(Mockito.<Long>any())).thenReturn(ofResult);

        Category parentCategory6 = new Category();
        parentCategory6.setId(1L);
        parentCategory6.setLevel(1);
        parentCategory6.setName("Name");
        parentCategory6.setParentCategory(new Category());

        Category parentCategory7 = new Category();
        parentCategory7.setId(1L);
        parentCategory7.setLevel(1);
        parentCategory7.setName("Name");
        parentCategory7.setParentCategory(parentCategory6);

        Category category3 = new Category();
        category3.setId(1L);
        category3.setLevel(1);
        category3.setName("Name");
        category3.setParentCategory(parentCategory7);

        Product req = new Product();
        req.setCategory(category3);
        req.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        req.setDescription("The characteristics of someone or something");
        req.setId(1L);
        req.setImageUrl("https://example.org/example");
        req.setNumRatings(10);
        req.setPrice(10.0d);
        req.setProductFamily("Product Family");
        req.setProductLine("Product Line");
        req.setQuantity(1);
        req.setRatingList(new ArrayList<>());
        req.setReviewList(new ArrayList<>());
        req.setTitle("Dr");
        assertSame(product2, productServiceImplementation.updateProduct(1L, req));
        verify(productRepository).save(Mockito.<Product>any());
        verify(productRepository).findProductById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#findProductById(Long)}
     */
    @Test
    void testFindProductById() throws ProductException {
        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(1L);
        parentCategory2.setLevel(1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(1L);
        category.setLevel(1);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImageUrl("https://example.org/example");
        product.setNumRatings(10);
        product.setPrice(10.0d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(1);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Dr");
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findProductById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(product, productServiceImplementation.findProductById(1L));
        verify(productRepository).findProductById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#findProductById(Long)}
     */
    @Test
    void testFindProductById2() throws ProductException {
        Optional<Product> emptyResult = Optional.empty();
        when(productRepository.findProductById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(ProductException.class, () -> productServiceImplementation.findProductById(1L));
        verify(productRepository).findProductById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#findProductByCategory(String)}
     */
    @Test
    void testFindProductByCategory() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findByCategory(Mockito.<String>any())).thenReturn(productList);
        List<Product> actualFindProductByCategoryResult = productServiceImplementation.findProductByCategory("Category");
        assertSame(productList, actualFindProductByCategoryResult);
        assertTrue(actualFindProductByCategoryResult.isEmpty());
        verify(productRepository).findByCategory(Mockito.<String>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts() {

        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "Stock", 10, 3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts2() {

        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "in_stock", 10, 3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts3() {

        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "out_of_stock", 10,
                3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    void testGetAllProducts4() {
        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        assertTrue(
                productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "Stock", 0, 3)
                        .toList()
                        .isEmpty());
        verify(productRepository).filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts5() {
        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(new ArrayList<>());
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "Stock", -1, 3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts6() {

        Category parentCategory = new Category();
        parentCategory.setId(2L);
        parentCategory.setLevel(0);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(2L);
        parentCategory2.setLevel(0);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(2L);
        category.setLevel(0);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("in_stock");
        product.setId(2L);
        product.setImageUrl("in_stock");
        product.setNumRatings(1);
        product.setPrice(0.5d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(0);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Mr");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(productList);
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "in_stock", 10, 3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts7() {
        Category parentCategory = new Category();
        parentCategory.setId(2L);
        parentCategory.setLevel(0);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(2L);
        parentCategory2.setLevel(0);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(2L);
        category.setLevel(0);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("in_stock");
        product.setId(2L);
        product.setImageUrl("in_stock");
        product.setNumRatings(1);
        product.setPrice(0.5d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(0);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Mr");

        Category parentCategory3 = new Category();
        parentCategory3.setId(3L);
        parentCategory3.setLevel(-1);
        parentCategory3.setName("42");
        parentCategory3.setParentCategory(new Category());

        Category parentCategory4 = new Category();
        parentCategory4.setId(3L);
        parentCategory4.setLevel(-1);
        parentCategory4.setName("42");
        parentCategory4.setParentCategory(parentCategory3);

        Category category2 = new Category();
        category2.setId(3L);
        category2.setLevel(-1);
        category2.setName("42");
        category2.setParentCategory(parentCategory4);

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product2.setDescription("Description");
        product2.setId(3L);
        product2.setImageUrl("Image Url");
        product2.setNumRatings(0);
        product2.setPrice(-0.5d);
        product2.setProductFamily("42");
        product2.setProductLine("42");
        product2.setQuantity(-1);
        product2.setRatingList(new ArrayList<>());
        product2.setReviewList(new ArrayList<>());
        product2.setTitle("Prof");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product2);
        productList.add(product);
        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(productList);
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "in_stock", 10, 3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts8() {

        Category parentCategory = new Category();
        parentCategory.setId(2L);
        parentCategory.setLevel(0);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(2L);
        parentCategory2.setLevel(0);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(2L);
        category.setLevel(0);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("in_stock");
        product.setId(2L);
        product.setImageUrl("in_stock");
        product.setNumRatings(1);
        product.setPrice(0.5d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(0);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Mr");

        Category parentCategory3 = new Category();
        parentCategory3.setId(3L);
        parentCategory3.setLevel(-1);
        parentCategory3.setName("42");
        parentCategory3.setParentCategory(new Category());

        Category parentCategory4 = new Category();
        parentCategory4.setId(3L);
        parentCategory4.setLevel(-1);
        parentCategory4.setName("42");
        parentCategory4.setParentCategory(parentCategory3);

        Category category2 = new Category();
        category2.setId(3L);
        category2.setLevel(-1);
        category2.setName("42");
        category2.setParentCategory(parentCategory4);

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product2.setDescription("Description");
        product2.setId(3L);
        product2.setImageUrl("Image Url");
        product2.setNumRatings(0);
        product2.setPrice(-0.5d);
        product2.setProductFamily("42");
        product2.setProductLine("42");
        product2.setQuantity(-1);
        product2.setRatingList(new ArrayList<>());
        product2.setReviewList(new ArrayList<>());
        product2.setTitle("Prof");

        Category parentCategory5 = new Category();
        parentCategory5.setId(1L);
        parentCategory5.setLevel(1);
        parentCategory5.setName("in_stock");
        parentCategory5.setParentCategory(new Category());

        Category parentCategory6 = new Category();
        parentCategory6.setId(1L);
        parentCategory6.setLevel(1);
        parentCategory6.setName("in_stock");
        parentCategory6.setParentCategory(parentCategory5);

        Category category3 = new Category();
        category3.setId(1L);
        category3.setLevel(1);
        category3.setName("in_stock");
        category3.setParentCategory(parentCategory6);

        Product product3 = new Product();
        product3.setCategory(category3);
        product3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product3.setDescription("The characteristics of someone or something");
        product3.setId(1L);
        product3.setImageUrl("https://example.org/example");
        product3.setNumRatings(10);
        product3.setPrice(10.0d);
        product3.setProductFamily("in_stock");
        product3.setProductLine("in_stock");
        product3.setQuantity(1);
        product3.setRatingList(new ArrayList<>());
        product3.setReviewList(new ArrayList<>());
        product3.setTitle("Dr");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product3);
        productList.add(product2);
        productList.add(product);
        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(productList);
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "in_stock", 10, 3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts9() {

        Category parentCategory = new Category();
        parentCategory.setId(3L);
        parentCategory.setLevel(-1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(3L);
        parentCategory2.setLevel(-1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(3L);
        category.setLevel(-1);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("out_of_stock");
        product.setId(3L);
        product.setImageUrl("out_of_stock");
        product.setNumRatings(0);
        product.setPrice(-0.5d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(-1);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Prof");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(productList);
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "out_of_stock", 10,
                3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#getAllProducts(String, String, double, double, String, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts10() {

        Category parentCategory = new Category();
        parentCategory.setId(3L);
        parentCategory.setLevel(-1);
        parentCategory.setName("Name");
        parentCategory.setParentCategory(new Category());

        Category parentCategory2 = new Category();
        parentCategory2.setId(3L);
        parentCategory2.setLevel(-1);
        parentCategory2.setName("Name");
        parentCategory2.setParentCategory(parentCategory);

        Category category = new Category();
        category.setId(3L);
        category.setLevel(-1);
        category.setName("Name");
        category.setParentCategory(parentCategory2);

        Product product = new Product();
        product.setCategory(category);
        product.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product.setDescription("out_of_stock");
        product.setId(3L);
        product.setImageUrl("out_of_stock");
        product.setNumRatings(0);
        product.setPrice(-0.5d);
        product.setProductFamily("Product Family");
        product.setProductLine("Product Line");
        product.setQuantity(-1);
        product.setRatingList(new ArrayList<>());
        product.setReviewList(new ArrayList<>());
        product.setTitle("Prof");

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("in_stock");
        parentCategory3.setParentCategory(new Category());

        Category parentCategory4 = new Category();
        parentCategory4.setId(1L);
        parentCategory4.setLevel(1);
        parentCategory4.setName("in_stock");
        parentCategory4.setParentCategory(parentCategory3);

        Category category2 = new Category();
        category2.setId(1L);
        category2.setLevel(1);
        category2.setName("in_stock");
        category2.setParentCategory(parentCategory4);

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        product2.setDescription("The characteristics of someone or something");
        product2.setId(1L);
        product2.setImageUrl("https://example.org/example");
        product2.setNumRatings(10);
        product2.setPrice(10.0d);
        product2.setProductFamily("in_stock");
        product2.setProductLine("in_stock");
        product2.setQuantity(1);
        product2.setRatingList(new ArrayList<>());
        product2.setReviewList(new ArrayList<>());
        product2.setTitle("Dr");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product2);
        productList.add(product);
        when(productRepository.filterProduct(Mockito.<String>any(), anyDouble(), anyDouble(), Mockito.<String>any()))
                .thenReturn(productList);
        productServiceImplementation.getAllProducts("Category", "Subcategory", 10.0d, 10.0d, "Sort", "out_of_stock", 10,
                3);
    }

    /**
     * Method under test: {@link ProductServiceImplementation#findProductsByPriceRange(double, double)}
     */
    @Test
    void testFindProductsByPriceRange() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findProductsByPriceRange(anyDouble(), anyDouble())).thenReturn(productList);
        List<Product> actualFindProductsByPriceRangeResult = productServiceImplementation.findProductsByPriceRange(10.0d,
                10.0d);
        assertSame(productList, actualFindProductsByPriceRangeResult);
        assertTrue(actualFindProductsByPriceRangeResult.isEmpty());
        verify(productRepository).findProductsByPriceRange(anyDouble(), anyDouble());
    }
}

