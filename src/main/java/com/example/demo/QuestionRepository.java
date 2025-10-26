package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    // Find questions by category and level
    List<Question> findByCategoryAndLevel(String category, Integer level);
    
    // Find questions by category
    List<Question> findByCategory(String category);
    
    // Find questions by level
    List<Question> findByLevel(Integer level);
    
    // Get distinct categories
    @Query("SELECT DISTINCT q.category FROM Question q")
    List<String> findDistinctCategories();
    
    // Get distinct levels for a category
    @Query("SELECT DISTINCT q.level FROM Question q WHERE q.category = :category")
    List<Integer> findDistinctLevelsByCategory(String category);
}