package com.example.demo.bean;

import java.sql.Blob;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OCEAN_user")
public class UserModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="userId")
	 private int userId;
	
	@Column(name="userAccount")
	 private String userAccount;
	
	@Column(name="userPass")
	private String userPass;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userGender")
	private String userGender;
	
	@Column(name="userStatus")
	private String userStatus;
	
	@Column(name="userBirth")
	private String userBirth;
	
	@Column(name="userAderss")
	private String userAderss;
	
	@Column(name="userImg")
	private Blob userImg;
	
	@Column(name="userPhone")
	private String userPhone;
	
	@Column(name="userSub")
	private String userSub;
	
	@Column(name="favoriteID")
	private String favoriteID;
	
	@Column(name="create_date")
	 private Date createDate;
	
	@Column(name="update_date")
	 private Date updateDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserAderss() {
		return userAderss;
	}

	public void setUserAderss(String userAderss) {
		this.userAderss = userAderss;
	}

	public Blob getUserImg() {
		return userImg;
	}

	public void setUserImg(Blob userImg) {
		this.userImg = userImg;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSub() {
		return userSub;
	}

	public void setUserSub(String userSub) {
		this.userSub = userSub;
	}

	public String getFavoriteID() {
		return favoriteID;
	}

	public void setFavoriteID(String favoriteID) {
		this.favoriteID = favoriteID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	

}
