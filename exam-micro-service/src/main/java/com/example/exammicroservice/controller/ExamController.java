package com.example.exammicroservice.controller;

import com.example.exammicroservice.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/getUsersExamNo")
    public ResponseEntity<Object> getUsersExamNo(@RequestBody List<Long> userIds) {
        HashMap<Long, Integer> usersExamNoHashMap = new HashMap<>();
        userIds.forEach(userId ->
            usersExamNoHashMap.put(userId, examRepository.examNoByUserId(userId)));
        return ResponseEntity.ok(usersExamNoHashMap);
    }
}
