package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodu.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{


	
}