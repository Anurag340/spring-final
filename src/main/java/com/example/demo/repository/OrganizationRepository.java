package com.example.demo.repository;

import com.example.demo.model.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organizations, Long> {
    Optional<Organizations> findByOrgid(int orgid);
}
