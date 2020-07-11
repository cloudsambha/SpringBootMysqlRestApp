package com.springboot.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.entity.Student;
import com.springboot.app.exception.RecordNotFoundException;
import com.springboot.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService sc;

	@GetMapping(value="/get")
	public List<Student> getAllCourses(){
		List <Student> studentList=sc.getAllStudents();
		return studentList;
	}

	@GetMapping(value="/get/{id}")
	public Student getStudentById(@PathVariable("id") Integer id){
		Optional<Student> student=sc.getStudentById(new Integer(id));
		if(!student.isPresent()){
			throw new RecordNotFoundException("Record with id - "+id+" doesn't exist.");
		}
		return  student.get();
	}

	@PostMapping("/add")
	public Student studentAdd(@RequestBody(required=true) Student studentobj){
		Student student = sc.addNewStudent(studentobj);
		return student;
	}


	@PutMapping("/update")
	public Student studentUpdate(@RequestBody Student studentobj){
		Student student = sc.addNewStudent(studentobj);
		return student;
	}

	@DeleteMapping(value="/delete/{id}")
	public void studentDelete(@PathVariable("id") Integer id){
		
		//check record exists or not
		Optional<Student> student=sc.getStudentById(id);
		if(!student.isPresent()){
			throw new RecordNotFoundException("Record with id - "+id+" doesn't exist.");
		}		
		sc.deleteStudent(id);
	}

}
