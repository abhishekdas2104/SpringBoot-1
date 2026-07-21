package com.abhishek.demo.StudentServer.Service;

import com.abhishek.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.abhishek.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.abhishek.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.abhishek.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.abhishek.demo.StudentServer.Entity.Student;
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
            CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = mapToStudent(createStudentRequestDTO);

        Student savedStudent = studentRepository.save(student);

        return mapToResponseDTO(savedStudent);
    }

    public Student getStudentById(int id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));
    }

    public UpdateStudentResponseDTO updateStudent(
            int id,
            UpdateStudentRequestDTO updateStudentRequestDTO) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        existingStudent.setName(updateStudentRequestDTO.getName());
        existingStudent.setAge(updateStudentRequestDTO.getAge());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);

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
            CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        return new CreateStudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getDepartment(),
                student.getCreatedAt(),
                student.getUpdatedAt()
        );
    }

}