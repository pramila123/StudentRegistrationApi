package com.sms.com.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.com.model.User;
import com.sms.com.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository urepo;

	@PostMapping("/add/user")
	public User addUser(@RequestBody User u) {
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		return urepo.save(u);
	}

	@GetMapping("/user")
	public List<User> getAll() {
		return urepo.findAll();
	}

}
