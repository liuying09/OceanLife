package com.example.demo.bean;

import java.util.List;

/*
此class用來將 ProductModel 和相關的 ProductImg 數據封裝在這個對象中，
以方便查詢時回傳
*/


public class ProductInfo {
	
    private ProductModel productModel;
    private List<ProductImgModel> ProductImgModel;
    
    
	public ProductModel getProductModel() {
		return productModel;
	}
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	public List<ProductImgModel> getProductImgModel() {
		return ProductImgModel;
	}
	public void setProductImgModel(List<ProductImgModel> productImgModel) {
		ProductImgModel = productImgModel;
	}
    
    

}
