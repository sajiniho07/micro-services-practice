package com.example.exammicroservice.bean;

public class UserExamInfo {

    private long id;
    private int examNo;

    public UserExamInfo() {

    }

    public UserExamInfo(long id, int examNo) {
        this.id = id;
        this.examNo = examNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getExamNo() {
        return examNo;
    }

    public void setExamNo(int examNo) {
        this.examNo = examNo;
    }
}
