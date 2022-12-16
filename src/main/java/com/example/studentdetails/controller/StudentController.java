package com.example.studentdetails.controller;

import com.example.studentdetails.Exception.ResourceNotFoundException;
import com.example.studentdetails.entity.Department;
import com.example.studentdetails.entity.StudentEntity;
import com.example.studentdetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;



    @GetMapping("/getAllDetails")
    public List<StudentEntity> getAllDetails()
    {
        return studentService.getAllDetails();
    }

    @GetMapping("/getDetailsById/{id}")
    public StudentEntity getDetailsById(@PathVariable("id") long id)throws ResourceNotFoundException
    {
        return studentService.getDetailsById(id);
    }

    @PostMapping("/create")
    public List<StudentEntity> createDetails(@RequestBody List<StudentEntity> studentEntity)
    {
        return studentService.insertDetails(studentEntity);
    }

    @PostMapping("/createDept")
            public Department createDept(@RequestBody Department department)
    {
        return studentService.insertDetailDep(department);
    }

    @PutMapping("/updateDetails/{id}")
    public ResponseEntity<StudentEntity> updateDetails(@RequestBody StudentEntity studentEntity,@PathVariable("id") long id)throws ResourceNotFoundException
    {
        studentEntity.setId(id);
        return new ResponseEntity<>(studentService.updateDetails(studentEntity), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDetail/{id}")
    public String deleteDetail(@PathVariable("id") long id)throws ResourceNotFoundException
    {
        studentService.deleteDetail(id);
        return "Deleted";
    }

    @DeleteMapping("/deleteAllDetails")
    public String deleteAllDetails(){
        studentService.deleteAllDetails();
        return "All Details Deleted";
    }
}
