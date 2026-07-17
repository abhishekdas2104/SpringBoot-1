package com.abhishek.demo.StudentServer.Repository;

import com.abhishek.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}