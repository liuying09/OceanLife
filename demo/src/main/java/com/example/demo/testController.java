package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.dataBean;

@CrossOrigin
@Controller
public class testController {
	
	private dataBean studentRecords;
	
	@RequestMapping(method = RequestMethod.GET, value="/test")
	  @ResponseBody
	  public String test() {
		return "Welcome to Spring Boot";
	  }
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	  @ResponseBody
	  public dataBean getAllStudents() {
		studentRecords = new dataBean();
		studentRecords.setName("莎白");
		studentRecords.setAge(18);
		
	  return studentRecords;
	  }
	

}
