package com.abhishek.demo.StudentServer;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}