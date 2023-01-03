package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.UserModel;
import com.example.demo.dao.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public boolean userLogin(@RequestBody UserModel userModel ) {
		String userAccount = userModel.getUserAccount();
		String userPass = userModel.getUserPass();
		
		boolean hasUser;
		
		if(userRepository.findByUserAccountAndUserPass(userAccount, userPass) != null){
			hasUser = true;
		}else {
			hasUser = false;
		}
		
		
		return hasUser;
	}
	
	
}
