package com.example.exammicroservice.controller;

import com.example.exammicroservice.bean.UserExamInfo;
import com.example.exammicroservice.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/getStudentsExamNo")
    public ResponseEntity<Object> getStudentsExamNo(@RequestParam List<Long> userIds) {
        List<UserExamInfo> userExamInfos = new ArrayList<>();
        userIds.forEach(userId -> {
            int examNo = examRepository.examNoByUserId(userId);
            UserExamInfo userExamInfo = new UserExamInfo(userId, examNo);
            userExamInfos.add(userExamInfo);
        });
        return ResponseEntity.ok(userExamInfos);
    }
}
