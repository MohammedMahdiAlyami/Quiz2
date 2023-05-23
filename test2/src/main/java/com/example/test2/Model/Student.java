package com.example.test2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "Student Id can not be null")
    private int id;
    @NotEmpty(message = "Student name can not be empty")
    private String name;
    @NotNull(message = "Student age can not be empty ")
    private int age;
    @NotEmpty(message = "Student major can not be empty")
    private String major;


}