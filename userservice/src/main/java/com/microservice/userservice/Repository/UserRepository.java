package com.microservice.userservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.userservice.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
