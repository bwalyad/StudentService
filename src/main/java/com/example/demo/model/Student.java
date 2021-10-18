/**
 * 
 */
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author HP
 *
 */

@Entity
public class Student {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public StudentStatus getStudentStatus() {
		return studentStatus;
	}
	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	Long id;
	@Column
	String first_name;
	@Column
	String last_name;
	@Column
	StudentStatus studentStatus;

	@Column
	String description;
	@Column
	String title;

}
