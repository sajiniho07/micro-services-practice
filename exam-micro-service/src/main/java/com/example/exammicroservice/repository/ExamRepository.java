package com.example.exammicroservice.repository;

import com.example.exammicroservice.bean.Exam;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Long> {
}
