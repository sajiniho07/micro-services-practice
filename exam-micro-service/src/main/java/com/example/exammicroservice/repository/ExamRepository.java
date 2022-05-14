package com.example.exammicroservice.repository;

import com.example.exammicroservice.bean.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Long> {

    @Query("select count(e) from Exam e where e.createdById = ?1")
    int examNoByUserId(Long userId);
}
