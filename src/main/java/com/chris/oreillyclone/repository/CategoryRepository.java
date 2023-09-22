package com.chris.oreillyclone.repository;


import com.chris.oreillyclone.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("Select c from Category c where c.name = ?1")
    public Category findCategoryByName(String name);

    @Query("select c from Category c where c.name = ?1 and c.parentCategory = ?2")
    public Category findByNameAndParent(String level, String parent);

}
