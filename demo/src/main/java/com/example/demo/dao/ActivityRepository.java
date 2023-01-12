package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.ActivityModel;

public interface ActivityRepository extends JpaRepository<ActivityModel,Long>{
	
	ActivityModel findByActivityID(Long activityID);

}
