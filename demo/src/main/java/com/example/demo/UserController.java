package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.UserModel;
import com.example.demo.dao.UserRepository;
import com.example.demo.utils.MD5util;
import com.example.demo.utils.TokenUtils;
import com.example.demo.utils.UUIDutil;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public Map<String,Object> userLogin(@RequestBody UserModel userModel ) {
		
		System.out.println("=== 進行登入 ===");
		
		Map<String,Object> result = new HashMap<>();
		
		String userAccount = userModel.getUserAccount();
		String userPass = userModel.getUserPass();
		System.out.println("輸入帳號 userAccount= "+userAccount);
		System.out.println("輸入密碼 userPass= "+userPass);
		
		if(userRepository.findByUserAccount(userAccount) != null) {
			UserModel uModel = userRepository.findByUserAccount(userAccount);
			
			String salt = uModel.getUserSalt();
	        String md5Password = MD5util.md5(userPass,salt);
	        
	        if(!uModel.getUserPass().equals(md5Password)){
	        	result.put("is_login","密碼錯誤");
	        }else {
	        	if(userRepository.findByUserAccountAndUserPass(userAccount, md5Password) != null){
	        		
	        		if(!"停權".equals(uModel.getUserStatus())) {
	        			String token = TokenUtils.sign(uModel);
		        		
		        		if("oceanLife@gmail.com".equals(userAccount)) {
		        			result.put("mangerToken",token);
			                result.put("mangerAccount",userAccount);
			                result.put("mangerId",uModel.getUserId());
		        		}else {
		        			result.put("userToken",token);
			                result.put("userAccount",userAccount);
			                result.put("userId",uModel.getUserId());
						}
		        		
		        		 result.put("is_login",true);
	        		}else {
	        			result.put("is_login","該帳號停權中，敬請見諒");
	        		}
	        		
	               
	    		}else {
	    			result.put("is_login","登入失敗");
	    		}
			}
		}else {
			result.put("is_login","此帳號不存在");
		}
		
		return result;
	}
	
	@RequestMapping("/findAllUser")
	public List<UserModel> findAllUser(){
		return userRepository.findAll();
	}
	
	
	@RequestMapping("/findByUserId")
	public UserModel findByUserId(@RequestBody UserModel userModel){
		return userRepository.findByUserId(userModel.getUserId());
	}
	
	
	
	@RequestMapping("/addUser")
	public String addUser(@RequestParam(name="account",required = false)String userAccount ,
			@RequestParam(name="pass",required = false)String userPass ,
			@RequestParam(name="name",required = false)String userName
			,@RequestParam(name="gender",required = false)String userGender
			,@RequestParam(name="birth",required = false)String userBirth
			,@RequestParam(name="country",required = false)String userCountry
			,@RequestParam(name="district",required = false)String userDistrict
			,@RequestParam(name="road",required = false)String userRoad
			,@RequestParam(name="phone",required = false)String userPhone
			,@RequestParam(name="sub",required = false)String userSub
			,@RequestParam(name="file-to-upload",required = false) MultipartFile userImg) throws IOException {
		
		System.out.println("=== 建立帳號 ===");
		System.out.println("userAccount= "+userAccount);
		System.out.println("userPass= "+userPass);
		System.out.println("userName= "+userName);
		
		SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
		Date date = new Date();
		String thisDate = ft.format(date);
		
		if(userRepository.findByUserAccount(userAccount) == null) {
			UserModel userModel = new UserModel();
			
			userModel.setUserAccount(userAccount);
			
			// 加密
	        String salt = UUIDutil.uuid();
	        userModel.setUserSalt(salt);
	        String md5Password = MD5util.md5(userPass,salt);
		    System.out.println("md5Password= "+ md5Password);
			
			userModel.setUserPass(md5Password);
			
			userModel.setUserName(userName);
			userModel.setUserGender(userGender);
			userModel.setUserBirth(userBirth);
			userModel.setUserCountry(userCountry);
			userModel.setUserDistrict(userDistrict);
			userModel.setUserRoad(userRoad);
			userModel.setUserPhone(userPhone);
			userModel.setUserSub(userSub);
			userModel.setUserStatus("正常");
			
			
			
			byte[] image;

			if(userImg == null) {
				System.out.println("file == null");
				image=null;
			}else {
				System.out.println("file != null");
				image=userImg.getBytes();
			}
			
			userModel.setUserImg(image);
			userModel.setCreateDate(thisDate);
			
			userRepository.save(userModel);
			
			return "註冊成功";
		}else {
			return "帳號已被註冊";
		}
	}
	
	
	@RequestMapping("/updateUser")
	public void updateUser(@RequestParam(name="id",required = false)int userId ,
			@RequestParam(name="account",required = false)String userAccount ,
			@RequestParam(name="pass",required = false)String userPass ,
			@RequestParam(name="name",required = false)String userName
			,@RequestParam(name="gender",required = false)String userGender
			,@RequestParam(name="birth",required = false)String userBirth
			,@RequestParam(name="country",required = false)String userCountry
			,@RequestParam(name="district",required = false)String userDistrict
			,@RequestParam(name="road",required = false)String userRoad
			,@RequestParam(name="phone",required = false)String userPhone
			,@RequestParam(name="sub",required = false)String userSub
			,@RequestParam(name="status",required = false)String userStatus
			,@RequestParam(name="file-to-upload",required = false) MultipartFile userImg) throws IOException {
		
		
		System.out.println("=== 更新帳號 ===");
		System.out.println("userAccount= "+userAccount);
		System.out.println("userPass= "+userPass);
		System.out.println("userName= "+userName);
		
		SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
		Date date = new Date();
		String thisDate = ft.format(date);
		
			UserModel userModel = userRepository.findByUserId(userId);
			
			userModel.setUserAccount(userAccount);
			
			if(!"".equals(userPass) && userPass!=null) {
				System.out.println("更新密碼");
				// 加密
		        String salt = UUIDutil.uuid();
		        userModel.setUserSalt(salt);
		        String md5Password = MD5util.md5(userPass,salt);
				userModel.setUserPass(md5Password);
			}
			
			userModel.setUserName(userName);
			userModel.setUserGender(userGender);
			userModel.setUserBirth(userBirth);
			userModel.setUserCountry(userCountry);
			userModel.setUserDistrict(userDistrict);
			userModel.setUserRoad(userRoad);
			userModel.setUserPhone(userPhone);
			userModel.setUserSub(userSub);
			
			if(!"".equals(userStatus)) {
				userModel.setUserStatus(userStatus);
			}
			
			
			byte[] image;

			if(userImg == null) {
				System.out.println("file == null");
				image=userModel.getUserImg();
			}else {
				System.out.println("file != null");
				image=userImg.getBytes();
			}
			
			userModel.setUserImg(image);
			userModel.setUpdateDate(thisDate);
			
			userRepository.save(userModel);
			
	}
	
}
