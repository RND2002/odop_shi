package com.odopBackend.odopShi_RestApi.repository;

import com.odopBackend.odopShi_RestApi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);
}
