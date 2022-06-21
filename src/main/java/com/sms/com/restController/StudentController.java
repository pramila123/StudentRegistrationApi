package com.sms.com.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.com.model.Student;
import com.sms.com.repository.StudentRepository;

@CrossOrigin("http://localhost:3000")
@RestController
public class StudentController {
	@Autowired
	private StudentRepository srepo;

	@PostMapping("/student/register")
	public String addStudent(@RequestBody Student s) {
		srepo.save(s);
		return "Data Inserted Successfully";
	}

	@GetMapping("/student/list")
	public List<Student> getAllStudent() {
		return srepo.findAll();
	}

	@DeleteMapping("student/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		srepo.deleteById(id);
		return "Deleted Success";
	}

	@GetMapping("/student/{id}")
	public Optional<Student> getById(@PathVariable("id") int id) {
		return srepo.findById(id);
	}

	@PutMapping("/student/update")
	public Student updateStudent(@RequestBody Student s) {
		return srepo.save(s);
	}

}
