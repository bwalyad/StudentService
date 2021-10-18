package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public abstract class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository ;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository ;
	}
	
	@Override
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	
	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
		
	}
	@Override
	public Student insert(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public void updateStudent(Long id, Student student) {
		Student studentFromDb = studentRepository.findById(id).get();
		System.out.println(studentFromDb.toString());
		studentFromDb.setStudentStatus(student.getStudentStatus());
		studentFromDb.setDescription(student.getDescription());
		studentFromDb.setTitle(student.getTitle());
		studentRepository.save(studentFromDb);
		
	}
	
	@Override
	public void deleteStudent(Long toStudent) {
		studentRepository.deleteById(toStudent);
	}
	
}
