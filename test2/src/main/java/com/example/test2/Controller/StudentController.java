package com.example.test2.Controller;


import com.example.test2.ApiResponse.ApiResponse;
import com.example.test2.Model.Student;
import com.example.test2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        ArrayList<Student> students = studentService.getStudent();
        return ResponseEntity.status(200).body(students);

    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student myStudent, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isAdded = studentService.addStudent(myStudent);
        if (isAdded) {
            return ResponseEntity.status(200).body("student added");

        } else return ResponseEntity.status(400).body("student not existed");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @PathVariable int id, Errors errors) {

        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isUpdated = studentService.updateStudent(student, id);
        if (isUpdated) {
            return ResponseEntity.status(200).body("student updated");

        } else return ResponseEntity.status(400).body("student not existed");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {

        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("student deleted");


        } else return ResponseEntity.status(400).body("student not existed");


    }
    @PostMapping("get-student")
    public ResponseEntity getOneTeacher(@RequestBody  String name  ){
        String students=studentService.getOneStudent(name);

        return ResponseEntity.status(200).body(students);


    }


}