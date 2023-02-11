package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query("SELECT s FROM Score s ORDER BY s.score DESC")
    List<Score> findAllOrderByScoreDesc();

    @Query("SELECT p FROM Score p WHERE p.username = :username")
    Score findByUsername(@Param("username") String username);
}
