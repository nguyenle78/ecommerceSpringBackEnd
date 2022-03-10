package com.nguyenle.ecommerce.dao;

import com.nguyenle.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
// JpaRepository<Entity, primary Key type>
@RepositoryRestResource(collectionResourceRel = "products",path = "products")
public interface ProductRepo extends JpaRepository<Product, Long> {
    //Query method
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // Custom Query for Landing Page. Get back later after done with Pagination
    @Query(value = "SELECT * FROM product ORDER BY RAND();", nativeQuery = true)
    List<Product> findByRandomOrder();

    @Query
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
