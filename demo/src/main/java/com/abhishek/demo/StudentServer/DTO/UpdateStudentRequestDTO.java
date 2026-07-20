package com.abhishek.demo.StudentServer.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UpdateStudentRequestDTO {

    @NotBlank(message = "Name cannot be empty or null")
    private String name;

    @Min(value = 0, message = "Age cannot be less than 0")
    private int age;

    public UpdateStudentRequestDTO() {
    }

    public UpdateStudentRequestDTO(String name, int age) {
        this.name = name;
        this.age = age;
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
}