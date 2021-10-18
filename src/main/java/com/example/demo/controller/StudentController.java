package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/api/v1/student")

public class StudentController {
	StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService= studentService ;
	}
@GetMapping
public ResponseEntity<List<Student>> getAllStudent(){
	List<Student>students = studentService.getStudents();
	return new ResponseEntity<> (students,HttpStatus.OK);
}

@GetMapping({"/{studentid}"})
public ResponseEntity<Student>getStudent(@PathVariable Long studentId){
	return new ResponseEntity<>(studentService.getStudentById(studentId),HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
	Student student1 = studentService.insert(student);
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.add("student", "/api/v1/student/"+ student1.getId().toString());
	return new ResponseEntity <> (student1,httpHeaders,HttpStatus.CREATED);
	
}

@PutMapping ({"/{studentId}"})
public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student ){
	studentService.updateStudent(studentId, student);
	return new ResponseEntity<>(studentService.getStudentById(studentId),HttpStatus.OK);
	
}

@DeleteMapping ({"/{studentId}"})
public ResponseEntity <Student>deleteStudent(@PathVariable("studentId")Long studentId) {
	studentService.deleteStudent(studentId);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
