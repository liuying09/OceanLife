package com.example.demo.bean;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OCEAN_article")
public class ArticleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="articleID")
	 private int articleID;
	
	@Column(name="valueEN")
	 private String valueEN;
	
	@Column(name="articleImg")
	 private byte[] articleImg;
	
	@Column(name="articleTitle")
	 private String articleTitle;
	
	@Column(name="articleContent")
	 private String articleContent;
	
	@Column(name="articleRemark")
	 private String articleRemark;
	
	@Column(name="articleStatus")
	 private String articleStatus;

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getValueEN() {
		return valueEN;
	}

	public void setValueEN(String valueEN) {
		this.valueEN = valueEN;
	}

	public byte[] getArticleImg() {
		return articleImg;
	}

	public void setArticleImg(byte[] articleImg) {
		this.articleImg = articleImg;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleRemark() {
		return articleRemark;
	}

	public void setArticleRemark(String articleRemark) {
		this.articleRemark = articleRemark;
	}

	public String getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(String articleStatus) {
		this.articleStatus = articleStatus;
	}

	
	
	
	
	
}
