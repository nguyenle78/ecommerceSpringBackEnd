package com.nguyenle.ecommerce.dao;

import com.nguyenle.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
// expose countries endpoint
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepo extends JpaRepository<Country,Long> {
}
