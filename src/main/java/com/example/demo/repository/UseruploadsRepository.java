package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.useruploads;

public interface UseruploadsRepository extends JpaRepository<useruploads, Long> {
    useruploads findByIndvid(int indvid);
}
