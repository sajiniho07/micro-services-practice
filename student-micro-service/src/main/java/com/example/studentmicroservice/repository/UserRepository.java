package com.example.studentmicroservice.repository;

import com.example.studentmicroservice.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
