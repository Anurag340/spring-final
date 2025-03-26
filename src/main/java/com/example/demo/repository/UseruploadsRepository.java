package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.useruploads;

public interface UseruploadsRepository extends JpaRepository<useruploads, Long> {
    useruploads findByIndvid(int indvid);
    Optional<useruploads> findByindvid(int indvid);

    List<useruploads> findAllByIndvid(int indvid);
}
