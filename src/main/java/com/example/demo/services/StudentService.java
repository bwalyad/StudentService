/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Student;

/**
 * @author HP
 *
 */
public interface StudentService {
	List<Student> getStudents();
	Student getStudentById(Long id);
	Student insert(Student student);
	void updateStudent(Long id,Student student);
	void deleteStudent(Long studentId);

}
