package com.springboot.app.service;

import java.util.List;
import java.util.Optional;

import com.springboot.app.entity.Student;


public interface StudentService {
	
	public List<Student> getAllStudents();
	public Optional<Student> getStudentById(Integer id);
	public Student addNewStudent(Student obj);
	public Student updateStudent(Student obj);
	public void deleteStudent(Integer id);
	
}
	
