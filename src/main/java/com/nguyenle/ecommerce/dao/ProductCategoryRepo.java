package com.nguyenle.ecommerce.dao;

import com.nguyenle.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//collectionResourceRel = Name of JSON entry, /product-category)
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long> {
}
