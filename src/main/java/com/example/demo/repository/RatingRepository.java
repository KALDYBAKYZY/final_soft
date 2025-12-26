package com.example.demo.repository;

import com.example.demo.entity.Rating;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends BaseEntityRepository<Rating> {
    List<Rating> findByBookId(Long bookId);
}