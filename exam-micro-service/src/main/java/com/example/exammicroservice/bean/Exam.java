package com.example.exammicroservice.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Exam {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, message = "Exam name should have atleast 2 characters")
    private String name;

    private Date createdAt;
    private Long createdById;
    private int questionNo;

    public Exam() {
    }

    public Exam(String name, Date createdAt, Long createdById, int questionNo) {
        this.name = name;
        this.createdAt = createdAt;
        this.createdById = createdById;
        this.questionNo = questionNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }
}
