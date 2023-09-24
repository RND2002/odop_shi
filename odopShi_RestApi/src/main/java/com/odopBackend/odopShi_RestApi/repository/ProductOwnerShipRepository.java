package com.odopBackend.odopShi_RestApi.repository;

import com.odopBackend.odopShi_RestApi.Entity.ProductOwnerShip;
import com.odopBackend.odopShi_RestApi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductOwnerShipRepository extends JpaRepository<ProductOwnerShip,Long> {
    List<ProductOwnerShip> findByUser(Users user);
}
