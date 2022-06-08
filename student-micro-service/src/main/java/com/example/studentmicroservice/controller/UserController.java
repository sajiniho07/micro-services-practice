package com.example.studentmicroservice.controller;

import com.example.studentmicroservice.bean.User;
import com.example.studentmicroservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Environment environment;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getUsersInfo")
    public List<User> getUsersInfo() {
        Stream<User> stream = StreamSupport.stream(userRepository.findAll().spliterator(), false);
        return stream.collect(Collectors.toList());
    }

    @GetMapping("/doRibbonTest")
    @ResponseBody
    public String doRibbonTest() {
        logger.info("{}", "Log contains sleuth unique id on request.");
        return "Hello client. I'm Ribbon. on port: " + environment.getProperty("local.server.port");
    }

}
