package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByIndvid(int indvid);
    Optional<User> findByOrgid(int orgid);
    Optional<User> findByName(String name);
    List<User> findByorgid(int orgid);
}