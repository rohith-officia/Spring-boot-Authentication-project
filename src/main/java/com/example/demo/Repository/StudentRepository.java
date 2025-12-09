package com.example.demo.Repository;

import com.example.demo.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel , Long> {
}
