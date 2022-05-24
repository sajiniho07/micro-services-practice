package com.example.schoolmicroservice.controller;

import com.example.schoolmicroservice.bean.StudentInfo;
import com.example.schoolmicroservice.proxy.ExamMicroServiceProxy;
import com.example.schoolmicroservice.proxy.StudentMicroServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class MainMicroServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExamMicroServiceProxy examMicroServiceProxy;
    @Autowired
    private StudentMicroServiceProxy studentMicroServiceProxy;

    @GetMapping("/getStudentsInfo")
    public ResponseEntity<List<StudentInfo>> getUsersInfo() {
        List<StudentInfo> studentInfos = getStudentInfos();
        List<StudentInfo> usersExamNo = getUsersExamInfos(studentInfos);
        mergeInTheBaseList(studentInfos, usersExamNo);
        return ResponseEntity.ok(studentInfos);

    }

    @GetMapping("/doRibbonTest")
    public String doRibbonTest() {
        return studentMicroServiceProxy.doRibbonTest();
    }

    private void mergeInTheBaseList(List<StudentInfo> baseList, List<StudentInfo> extraData) {
        for (StudentInfo studentInfo : baseList) {
            for (StudentInfo userExamNo : extraData) {
                if (studentInfo.getId().equals(userExamNo.getId())) {
                    studentInfo.setExamNo(userExamNo.getExamNo());
                }
            }
        }
    }

    /* Feign method */
    private List<StudentInfo> getUsersExamInfos(List<StudentInfo> studentInfos) {
        List<Long> userIds = studentInfos.stream().map(StudentInfo::getId).collect(Collectors.toList());
        return examMicroServiceProxy.getStudentsExamNo(userIds);
    }

    /* RestTemplate method */
    private List<StudentInfo> getStudentInfos() {
        ResponseEntity<StudentInfo[]> responseEntity = new RestTemplate().getForEntity("http://localhost:8100/getUsersInfo", StudentInfo[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }
}
