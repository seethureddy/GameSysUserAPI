package com.gamesysgroup.userapi.userapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesysgroup.userapi.userapi.bean.User;
import com.gamesysgroup.userapi.userapi.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/v1/users")
	public List<User> listAllUsers() {
		return userService.listAllUsers();
	}
}
