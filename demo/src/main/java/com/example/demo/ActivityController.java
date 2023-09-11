package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.ActivityModel;
import com.example.demo.dao.ActivityRepository;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;

//@Tag(name = "Activity", description = "Activity management APIs")
@RestController
public class ActivityController {
	
	@Autowired
	private ActivityRepository activityRepository;

//	  @Operation(
//		      summary = "add Activity",
//		      description = "新增活動",
//		      tags = { "tutorials", "post" })
	@RequestMapping("/addActivity")
	public void addActivity(@RequestParam(name="title",required = false)String title
			,@RequestParam(name="content",required = false)String content
			,@RequestParam(name="date",required = false)String date
			,@RequestParam(name="time",required = false)String time
			,@RequestParam(name="remark",required = false)String remark
			,@RequestParam(name="status",required = false)String status
			,@RequestParam(name="file-to-upload",required = false) MultipartFile fileField) throws IOException {
		
		
		ActivityModel activityModel = new ActivityModel();
		
		SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
		Date dateNow = new Date();
		String thisDate = ft.format(dateNow);
		
		byte[] image;
		if(fileField == null) {
			image=null;
		}else {
			image=fileField.getBytes();
		}
		
		activityModel.setActivityTitle(title);
		activityModel.setActivityContent(content.replace("\n","<br>"));
		activityModel.setActivityDate(date);
		activityModel.setActivityTime(time);
		activityModel.setActivityRemark(remark.replace("\n","<br>"));
		activityModel.setActivityImg(image);
		activityModel.setActivityStatus(status);
		activityModel.setCreateDate(thisDate);
		
		activityRepository.save(activityModel);
	}
	
//	  @Operation(
//		      summary = "update Activity",
//		      description = "更新活動",
//		      tags = { "tutorials", "post" })
	@RequestMapping("/updateActivity")
	public void updateActivity(@RequestParam(name="id",required = false)long activityID ,
			@RequestParam(name="title",required = false)String title
			,@RequestParam(name="content",required = false)String content
			,@RequestParam(name="date",required = false)String date
			,@RequestParam(name="time",required = false)String time
			,@RequestParam(name="remark",required = false)String remark
			,@RequestParam(name="status",required = false)String status
			,@RequestParam(name="file-to-upload",required = false) MultipartFile fileField) throws IOException {
		
		ActivityModel activityModel = activityRepository.findByActivityID(activityID);
		
		SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
		Date dateNow = new Date();
		String thisDate = ft.format(dateNow);
		
		byte[] image;
		if(fileField == null) {
			image=activityModel.getActivityImg();
		}else {
			image=fileField.getBytes();
		}
		
		activityModel.setActivityTitle(title);
		activityModel.setActivityContent(content.replace("\n","<br>"));
		activityModel.setActivityDate(date);
		activityModel.setActivityTime(time);
		activityModel.setActivityRemark(remark.replace("\n","<br>"));
		activityModel.setActivityImg(image);
		activityModel.setActivityStatus(status);
		activityModel.setUpdateDate(thisDate);
		
		activityRepository.save(activityModel);
		
	}
	
//	  @Operation(
//		      summary = "delete Activity",
//		      description = "刪除活動",
//		      tags = { "tutorials", "post" })
	@RequestMapping("/deleteActivity")
	public void deleteActivity(@RequestParam(name="idList",required = false) Long[] ids ) {
		
		for(int i = 0; i < ids.length; i++) {
			if(activityRepository.findByActivityID(ids[i]) != null) {
				activityRepository.deleteById(ids[i]);
			}
		}
	}
	
//	  @Operation(
//		      summary = "find By Activity ID",
//		      description = "以ID搜尋活動",
//		      tags = { "tutorials", "post" })
	@RequestMapping("/findByActivityID")
	public ActivityModel findByActivityID(@RequestBody ActivityModel activityModel) {
		
		return activityRepository.findByActivityID(Long.valueOf(activityModel.getActivityID()));
	}
	
//	  @Operation(
//		      summary = "find All Activity",
//		      description = "搜尋全部活動",
//		      tags = { "tutorials", "post" })
	@RequestMapping("/findAllActivity")
	public List<ActivityModel> findAllActivity(){
		
		List<ActivityModel> list = activityRepository.findAll();
		return list;
	}
	
}
