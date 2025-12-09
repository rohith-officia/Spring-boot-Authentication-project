package com.example.demo.Repository;

import com.example.demo.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel , String> {
}
