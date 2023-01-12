package com.example.demo.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OCEAN_productimg")
public class ProductImgModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="productImgID")
	 private int productImgID;
	
	@Column(name="productID")
	 private String productID;
	
	@Column(name="productImgName")
	 private String productImgName;
	
	@Column(name="productImgBlob")
	 private byte[] productImgBlob;
	
	@Column(name="create_date")
	 private String createDate;
	
	@Column(name="update_date")
	 private String updateDate;

	public int getProductImgID() {
		return productImgID;
	}

	public void setProductImgID(int productImgID) {
		this.productImgID = productImgID;
	}

	public String getProductImg() {
		return productImgName;
	}

	public void setProductImg(String productImgName) {
		this.productImgName = productImgName;
	}

	public byte[] getProductImgBlob() {
		return productImgBlob;
	}

	public void setProductImgBlob(byte[] productImgBlob) {
		this.productImgBlob = productImgBlob;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

}
