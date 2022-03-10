package com.nguyenle.ecommerce.dao;

import com.nguyenle.ecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StateRepo extends JpaRepository<State, Long> {
}
