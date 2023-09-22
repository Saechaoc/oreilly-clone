package com.chris.oreillyclone.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CreateProductRequestTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateProductRequest#setBrand(String)}
     *   <li>{@link CreateProductRequest#setDescription(String)}
     *   <li>{@link CreateProductRequest#setImageUrl(String)}
     *   <li>{@link CreateProductRequest#setPrice(int)}
     *   <li>{@link CreateProductRequest#setProductFamily(String)}
     *   <li>{@link CreateProductRequest#setProductLine(String)}
     *   <li>{@link CreateProductRequest#setQuantity(int)}
     *   <li>{@link CreateProductRequest#setSecondLevelCategory(String)}
     *   <li>{@link CreateProductRequest#setThirdLevelCategory(String)}
     *   <li>{@link CreateProductRequest#setTitle(String)}
     *   <li>{@link CreateProductRequest#setTopLevelCategory(String)}
     *   <li>{@link CreateProductRequest#getBrand()}
     *   <li>{@link CreateProductRequest#getDescription()}
     *   <li>{@link CreateProductRequest#getImageUrl()}
     *   <li>{@link CreateProductRequest#getPrice()}
     *   <li>{@link CreateProductRequest#getProductFamily()}
     *   <li>{@link CreateProductRequest#getProductLine()}
     *   <li>{@link CreateProductRequest#getQuantity()}
     *   <li>{@link CreateProductRequest#getSecondLevelCategory()}
     *   <li>{@link CreateProductRequest#getThirdLevelCategory()}
     *   <li>{@link CreateProductRequest#getTitle()}
     *   <li>{@link CreateProductRequest#getTopLevelCategory()}
     * </ul>
     */
    @Test
    void testSetBrand() {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setBrand("Brand");
        createProductRequest.setDescription("The characteristics of someone or something");
        createProductRequest.setImageUrl("https://example.org/example");
        createProductRequest.setPrice(1);
        createProductRequest.setProductFamily("Product Family");
        createProductRequest.setProductLine("Product Line");
        createProductRequest.setQuantity(1);
        createProductRequest.setSecondLevelCategory("Second Level Category");
        createProductRequest.setThirdLevelCategory("Third Level Category");
        createProductRequest.setTitle("Dr");
        createProductRequest.setTopLevelCategory("Top Level Category");
        String actualBrand = createProductRequest.getBrand();
        String actualDescription = createProductRequest.getDescription();
        String actualImageUrl = createProductRequest.getImageUrl();
        int actualPrice = createProductRequest.getPrice();
        String actualProductFamily = createProductRequest.getProductFamily();
        String actualProductLine = createProductRequest.getProductLine();
        int actualQuantity = createProductRequest.getQuantity();
        String actualSecondLevelCategory = createProductRequest.getSecondLevelCategory();
        String actualThirdLevelCategory = createProductRequest.getThirdLevelCategory();
        String actualTitle = createProductRequest.getTitle();
        assertEquals("Brand", actualBrand);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("https://example.org/example", actualImageUrl);
        assertEquals(1, actualPrice);
        assertEquals("Product Family", actualProductFamily);
        assertEquals("Product Line", actualProductLine);
        assertEquals(1, actualQuantity);
        assertEquals("Second Level Category", actualSecondLevelCategory);
        assertEquals("Third Level Category", actualThirdLevelCategory);
        assertEquals("Dr", actualTitle);
        assertEquals("Top Level Category", createProductRequest.getTopLevelCategory());
    }
}

