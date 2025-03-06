package com.example.demo.repository;

import com.example.demo.model.useruploads;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUploadRepository extends JpaRepository<useruploads, Long> {
    Optional<useruploads> findByindvid(int indvid);
}
