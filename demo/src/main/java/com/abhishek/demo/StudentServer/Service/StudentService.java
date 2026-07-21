package com.abhishek.demo.StudentServer.Service;

import com.abhishek.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.abhishek.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.abhishek.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.abhishek.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.abhishek.demo.StudentServer.Entity.Student;
import com.abhishek.demo.StudentServer.Exception.EmailAlreadyExistsException;
import com.abhishek.demo.StudentServer.Exception.StudentNotFoundException;
import com.abhishek.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(
            CreateStudentRequestDTO requestDTO) {

        String email = requestDTO.getEmail()
                .trim()
                .toLowerCase();

        if (studentRepository.existsByEmailIgnoreCase(email)) {
            throw new EmailAlreadyExistsException(
                    "Email is already present in the database"
            );
        }

        Student student = mapToStudent(requestDTO);
        Student savedStudent = studentRepository.save(student);

        return mapToResponseDTO(savedStudent);
    }

    public Student getStudentById(int id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));
    }

    public boolean lookupEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        return studentRepository.existsByEmailIgnoreCase(
                email.trim()
        );
    }

    public UpdateStudentResponseDTO updateStudent(
            int id,
            UpdateStudentRequestDTO requestDTO) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        existingStudent.setName(requestDTO.getName());
        existingStudent.setAge(requestDTO.getAge());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent =
                studentRepository.save(existingStudent);

        return new UpdateStudentResponseDTO(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getAge(),
                savedStudent.getDepartment(),
                "Student information is updated"
        );
    }

    public void deleteStudent(int id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        studentRepository.delete(student);
    }

    private Student mapToStudent(
            CreateStudentRequestDTO requestDTO) {

        Student student = new Student();

        student.setName(requestDTO.getName());
        student.setAge(requestDTO.getAge());
        student.setDepartment(requestDTO.getDepartment());
        student.setEmail(
                requestDTO.getEmail().trim().toLowerCase()
        );
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(
            Student student) {

        return new CreateStudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getDepartment(),
                student.getEmail(),
                student.getCreatedAt(),
                student.getUpdatedAt()
        );
    }
}