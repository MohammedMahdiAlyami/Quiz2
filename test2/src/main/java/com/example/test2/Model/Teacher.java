package com.example.test2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotNull(message = "Teacher id can not be null")
    private int id;
    @NotEmpty(message = "Teacher name can not be empty")
    private  String name ;
    @NotNull(message = "Teacher salary can not be null")
    private double salary;


}