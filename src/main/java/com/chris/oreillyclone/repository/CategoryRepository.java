package com.chris.oreillyclone.repository;

import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends JpaRepository<Category,Long> {

}
