package com.abhishek.demo.StudentServer.Controller;

import com.abhishek.demo.StudentServer.Entity.Student;
import com.abhishek.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Student student) {

        Student saved = studentService.studentValidate(student);

        if (saved == null) {
            return ResponseEntity.status(400).body("Invalid student data");
        }

        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setDepartment(updatedStudent.getDepartment());

        Student saved = studentService.saveStudent(existingStudent);

        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully");
    }
}