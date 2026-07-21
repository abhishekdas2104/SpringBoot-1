package com.abhishek.demo.StudentServer.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequestDTO {

    @NotBlank(message = "Name cannot be empty or null")
    private String name;

    @Min(value = 0, message = "Age cannot be less than 0")
    private int age;

    @NotBlank(message = "Department cannot be empty or null")
    private String department;

    @NotBlank(message = "Email cannot be empty or null")
    @Email(message = "Enter a valid email address")
    private String email;

    public CreateStudentRequestDTO() {
    }

    public CreateStudentRequestDTO(
            String name,
            int age,
            String department,
            String email) {

        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}