package com.Rikesh.StudentSystem.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rikesh.StudentSystem.entity.Student;
import com.Rikesh.StudentSystem.repository.StudentRepository;
import com.Rikesh.StudentSystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> list = studentRepo.findAll();
		return list;
	}
	@Override
	public Student saveStudent(Student student) {
		
		Student stu = studentRepo.save(student);
		return stu;
	}
	@Override
	public Student getById(int id) {
		Student stu = studentRepo.findById(id).get();
		return stu;
	}
	@Override
	public void deleteById(int id) {
		studentRepo.deleteById(id);
	}

}
