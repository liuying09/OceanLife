package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ProductModel;
import com.example.demo.dao.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	DataSource dataSource;
	
	@RequestMapping("/productPage")
	public List<ProductModel> productPage() {
		
		List<ProductModel> list = new ArrayList<ProductModel>();
		
		list = productRepository.findAll();
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println("name= "+list.get(i).getProductName());
		}
		
		return list;
	}
	
	
	 @PostMapping("/addProduct") //設置url路徑對應到此方法上，並限制只能使用Post方法,
	 public int create(@RequestBody ProductModel product){ //使用@RequestBody取得前端requestBody資訊
		 
		 	System.out.println("product.getProductName()= "+product.getProductName());
		 
	        return productRepository.addProduct(product.getProductName(), product.getProductPrice(), product.getProductPriceSale(),
	        		product.getProductImg(), product.getProductType(), product.getProductNum(), product.getProductContent(), 
	        		product.getProductSpenMaterial(), product.getProductSpenMF(), product.getProductSpenSize(), product.getProductRemark(), 
	        		null, null);
	 }

}
