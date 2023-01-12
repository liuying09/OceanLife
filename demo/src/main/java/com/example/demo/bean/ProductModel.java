package com.example.demo.bean;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OCEAN_product")
public class ProductModel {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="productId")
	 private int productId;
	
	@Column(name="productName")
	 private String productName;
	
	@Column(name="productPrice")
	 private String productPrice;
	
	@Column(name="productPriceSale")
	 private String productPriceSale;
	
	@Column(name="productImg")
	 private String productImg;
	
	@Column(name="productType")
	 private String productType;
	
	@Column(name="productNum")
	 private String productNum;
	
	@Column(name="productContent")
	 private String productContent;
	
	@Column(name="productSpenMaterial")
	 private String productSpenMaterial;
	
	@Column(name="productSpenSize")
	 private String productSpenSize;
	
	@Column(name="productSpenMF")
	 private String productSpenMF;
	
	@Column(name="productRemark")
	 private String productRemark;
	
	@Column(name="productStatus")
	 private String productStatus;
	
	@Column(name="create_date")
	 private String createDate;
	
	@Column(name="update_date")
	 private String updateDate;
	
	 
	 
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductPriceSale() {
		return productPriceSale;
	}
	public void setProductPriceSale(String productPriceSale) {
		this.productPriceSale = productPriceSale;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getProductSpenMaterial() {
		return productSpenMaterial;
	}
	public void setProductSpenMaterial(String productSpenMaterial) {
		this.productSpenMaterial = productSpenMaterial;
	}
	public String getProductSpenSize() {
		return productSpenSize;
	}
	public void setProductSpenSize(String productSpenSize) {
		this.productSpenSize = productSpenSize;
	}
	public String getProductSpenMF() {
		return productSpenMF;
	}
	public void setProductSpenMF(String productSpenMF) {
		this.productSpenMF = productSpenMF;
	}
	public String getProductRemark() {
		return productRemark;
	}
	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
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
	 
	 
	 
	
}
