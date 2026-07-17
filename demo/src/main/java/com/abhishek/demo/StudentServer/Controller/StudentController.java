package com.abhishek.demo.StudentServer.Controller;

import com.abhishek.demo.StudentServer.Entity.Student;
import com.abhishek.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Student student) {
        Student existingStudent = studentService.getStudentById(student.getId());
        if (existingStudent != null) {
            return ResponseEntity.status(400).body("Student already exists");
        }
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudents(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Student updatedStudent){
        Student exstudent = studentService.getStudentById(id);

        if(exstudent == null){
            return ResponseEntity.status(404).body("Student not found");
        }
        exstudent.setName(updatedStudent.getName());
        exstudent.setAge(updatedStudent.getAge());
        exstudent.setDepartment(updatedStudent.getDepartment());

        Student saved = studentService.saveStudent(exstudent);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        if(student==null){
            return ResponseEntity.status(404).body("Student not found");
        }
        studentService.deleteStudent(id);

        return ResponseEntity.status(200).body("Student deleted successfully");
    }

}


//public ResponseEntity<?> getStudent(@PathVariable int id){
//Here '?' means that ResponseEntity can contain any type of data and we will define the return type while run time