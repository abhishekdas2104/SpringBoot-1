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
            @Valid @RequestBody CreateStudentRequestDTO createStudentRequestDTO) {

        CreateStudentResponseDTO saved =
                studentService.studentValidate(createStudentRequestDTO);

        if (saved == null) {
            return ResponseEntity
                    .status(400)
                    .body("Invalid student data");
        }

        return ResponseEntity
                .status(201)
                .body(saved);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity
                    .status(404)
                    .body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable int id,
            @Valid @RequestBody UpdateStudentRequestDTO updateStudentRequestDTO) {

        UpdateStudentResponseDTO updatedStudent =
                studentService.updateStudent(id, updateStudentRequestDTO);

        if (updatedStudent == null) {
            return ResponseEntity
                    .status(404)
                    .body("Student not found");
        }

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {
            return ResponseEntity
                    .status(404)
                    .body("Student not found");
        }

        return ResponseEntity.ok("Student deleted successfully");
    }
}