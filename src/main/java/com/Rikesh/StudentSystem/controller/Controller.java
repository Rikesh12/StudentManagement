package com.Rikesh.StudentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.Rikesh.StudentSystem.entity.Student;
import com.Rikesh.StudentSystem.service.StudentService;

//import org.springframework.stereotype.Controller;


@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		model.addAttribute("students", service.getAllStudents());
		
		return "students";	
	}
	
	
	@GetMapping("/student/new")
	public String createStudentForm(Model model) {
		
		Student student = new Student();
		model.addAttribute("student",student);
		
		return "create-student";
	}
	
	@PostMapping("/studentss")
	public String saveStu(@ModelAttribute("student") Student student) {
		
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	
	
	@GetMapping("students/edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {
		
		model.addAttribute("student", service.getById(id));
		return "edit-student";
	}
	
	
	@PostMapping("students/edit/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		
		Student existingStu = service.getById(id);
		
		existingStu.setFirstName(student.getFirstName());
		existingStu.setLastName(student.getLastName());
		existingStu.setEmail(student.getEmail());
		
		service.saveStudent(existingStu);
		
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteId(@PathVariable int id) {
		
		service.deleteById(id);
		
		return "redirect:/students";
	}

}
