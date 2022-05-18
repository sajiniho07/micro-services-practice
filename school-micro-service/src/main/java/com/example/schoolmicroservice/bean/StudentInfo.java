package com.example.schoolmicroservice.bean;

public class StudentInfo {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer examNo;

    public StudentInfo() {
    }

    public StudentInfo(Long id, String firstName, String lastName, Integer examNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examNo = examNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getExamNo() {
        return examNo;
    }

    public void setExamNo(Integer examNo) {
        this.examNo = examNo;
    }
}
