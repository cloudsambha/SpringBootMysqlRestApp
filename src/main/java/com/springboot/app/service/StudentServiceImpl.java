package com.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.entity.Student;
import com.springboot.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository sr;
	
	@Override
	public List<Student> getAllStudents() {
		return sr.findAll();
		
	}

	@Override
	public Student addNewStudent(Student obj) {
		return sr.save(obj);
	}

	@Override
	public Student updateStudent(Student obj) {
		return sr.save(obj);
		
	}

	@Override
	public void deleteStudent(Integer id) {
		sr.deleteById(id);
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {	
		return sr.findById(id);
	 
	}

}
