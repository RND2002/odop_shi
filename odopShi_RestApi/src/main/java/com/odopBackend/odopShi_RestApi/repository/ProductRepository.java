package com.odopBackend.odopShi_RestApi.repository;

import com.odopBackend.odopShi_RestApi.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
