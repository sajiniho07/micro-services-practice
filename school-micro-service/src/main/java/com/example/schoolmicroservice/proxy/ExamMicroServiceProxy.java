package com.example.schoolmicroservice.proxy;

import com.example.schoolmicroservice.bean.StudentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "exam-micro-service", url = "localhost:8200")
public interface ExamMicroServiceProxy {

    @GetMapping("/getStudentsExamNo")
    List<StudentInfo> getStudentsExamNo(@RequestParam("userIds") List<Long> userIds);
}
