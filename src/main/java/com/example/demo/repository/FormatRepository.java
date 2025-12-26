package com.example.demo.repository;
import com.example.demo.entity.Format;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatRepository extends JpaRepository<Format, Long> {
}