package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long>{
	
	UserModel findByUserAccountAndUserPass(String userAccount,String userPass);
	UserModel findByUserId(int userId);
	UserModel findByUserAccount(String userAccount);

}
