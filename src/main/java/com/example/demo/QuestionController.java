package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;

@Data
@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*") // Flutter app ke liye
public class QuestionController {
    
    @Autowired
    private QuestionRepository questionRepository;
    
    // Get all questions
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    
    // Get questions by category and level
    @GetMapping("/{category}/{level}")
    public List<Question> getQuestionsByCategoryAndLevel(
            @PathVariable String category, 
            @PathVariable Integer level) {
        return questionRepository.findByCategoryAndLevel(category, level);
    }
    
    // Get all categories
    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return questionRepository.findDistinctCategories();
    }
    
    // Get levels for a category
    @GetMapping("/{category}/levels")
    public List<Integer> getLevelsByCategory(@PathVariable String category) {
        return questionRepository.findDistinctLevelsByCategory(category);
    }
    
    // Get single question by ID
   @GetMapping("/{id}")
public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        try {
            Question question = questionRepository.getOne(id); // Deprecated in newer versions
            return ResponseEntity.ok(question);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}