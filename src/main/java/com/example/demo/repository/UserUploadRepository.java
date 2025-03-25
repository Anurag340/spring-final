package com.example.demo.repository;

import com.example.demo.model.useruploads;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserUploadRepository extends JpaRepository<useruploads, Integer> {
    Optional<useruploads> findByindvid(int indvid);

    List<useruploads> findAllByIndvid(int indvid);
}