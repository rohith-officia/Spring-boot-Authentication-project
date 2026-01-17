package com.example.demo.Repository;

import com.example.demo.Model.StudentModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModels, Long> {
}
