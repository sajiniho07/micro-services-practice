package com.example.exammicroservice.controller;

import com.example.exammicroservice.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

}
