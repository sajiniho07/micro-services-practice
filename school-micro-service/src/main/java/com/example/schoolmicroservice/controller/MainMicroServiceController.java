package com.example.schoolmicroservice.controller;

import com.example.springcloudconfigserver.bean.StudentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainMicroServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getStudentsInfo")
    public ResponseEntity<StudentInfo[]> getUsersInfo() {
        StudentInfo[] studentInfos = getStudentInfos();



        return ResponseEntity.ok(studentInfos);

    }

    private StudentInfo[] getStudentInfos() {
        ResponseEntity<StudentInfo[]> responseEntity = new RestTemplate().getForEntity("http://localhost:8100/getUsersInfo", StudentInfo[].class);
        return responseEntity.getBody();
    }
}
