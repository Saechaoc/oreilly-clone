package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CategoryTest {
    /**
     * Method under test: {@link Category#Category()}
     */
    @Test
    void testConstructor() {
        Category actualCategory = new Category();
        assertNull(actualCategory.getId());
        assertNull(actualCategory.getParentCategory());
        assertNull(actualCategory.getName());
        assertEquals(0, actualCategory.getLevel());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Category#Category(Long, String, Category, int)}
     *   <li>{@link Category#Category()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Category parentCategory = new Category();
        parentCategory.setId(1L);
        parentCategory.setLevel(1);
        parentCategory.setName("Name");
        Category parentCategory2 = new Category();
        parentCategory.setParentCategory(parentCategory2);

        Category parentCategory3 = new Category();
        parentCategory3.setId(1L);
        parentCategory3.setLevel(1);
        parentCategory3.setName("Name");
        parentCategory3.setParentCategory(parentCategory);

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
        Category actualCategory = new Category(1L, "Name", parentCategory5, 1);

        assertEquals(1L, actualCategory.getId().longValue());
        Category parentCategory6 = actualCategory.getParentCategory();
        assertSame(parentCategory5, parentCategory6);
        assertEquals("Name", actualCategory.getName());
        assertEquals(1, actualCategory.getLevel());
        assertEquals("Name", parentCategory6.getName());
        assertEquals(1, parentCategory6.getLevel());
        assertEquals(1L, parentCategory6.getId().longValue());
        Category parentCategory7 = parentCategory6.getParentCategory();
        assertSame(parentCategory4, parentCategory7);
        assertEquals(1L, parentCategory7.getId().longValue());
        Category parentCategory8 = parentCategory7.getParentCategory();
        assertSame(parentCategory3, parentCategory8);
        assertEquals("Name", parentCategory7.getName());
        assertEquals(1, parentCategory7.getLevel());
        assertEquals("Name", parentCategory8.getName());
        assertEquals(1, parentCategory8.getLevel());
        assertEquals(1L, parentCategory8.getId().longValue());
        Category parentCategory9 = parentCategory8.getParentCategory();
        assertSame(parentCategory, parentCategory9);
        assertEquals(1L, parentCategory9.getId().longValue());
        Category parentCategory10 = parentCategory9.getParentCategory();
        assertSame(parentCategory2, parentCategory10);
        assertEquals("Name", parentCategory9.getName());
        assertEquals(1, parentCategory9.getLevel());
        assertNull(parentCategory10.getName());
        assertEquals(0, parentCategory10.getLevel());
        assertNull(parentCategory10.getId());
        assertNull(parentCategory10.getParentCategory());
    }
}

