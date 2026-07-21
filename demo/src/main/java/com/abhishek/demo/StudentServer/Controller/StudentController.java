package com.abhishek.demo.StudentServer.Controller;

import com.abhishek.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.abhishek.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.abhishek.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.abhishek.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.abhishek.demo.StudentServer.Entity.Student;
import com.abhishek.demo.StudentServer.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @Valid @RequestBody CreateStudentRequestDTO requestDTO) {

        CreateStudentResponseDTO saved =
                studentService.studentValidate(requestDTO);

        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {

        Student student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    @GetMapping("/email/lookup")
    public ResponseEntity<String> lookupEmail(
            @RequestParam String email) {

        boolean exists = studentService.lookupEmail(email);

        if (exists) {
            return ResponseEntity.ok(
                    "Email is already present in the database"
            );
        }

        return ResponseEntity.ok(
                "Email is not present in the database"
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable int id,
            @Valid @RequestBody UpdateStudentRequestDTO requestDTO) {

        UpdateStudentResponseDTO updatedStudent =
                studentService.updateStudent(id, requestDTO);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        studentService.deleteStudent(id);

        return ResponseEntity.ok(
                "Student deleted successfully"
        );
    }
}