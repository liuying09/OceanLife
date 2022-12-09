package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.ProductModel;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

	List<ProductModel> findAll();
	List<ProductModel> findByProductName(String productName);
	
	// 註記為事務交易
	@Transactional
	// 註記為資料異動
	@Modifying
	// 使用標準的SQL Insert語法來寫入資料，冒號+名稱來表示要帶入的參數
	@Query(value = "INSERT INTO OCEAN.OCEAN_PRODUCT(PRODUCTNAME, PRODUCTPRICE,PRODUCTPRICESALE,PRODUCTIMG,PRODUCTTYPE,PRODUCTNUM,PRODUCTCONTENT,PRODUCTSPENMATERIAL,PRODUCTSPENSIZE,PRODUCTSPENMF,PRODUCTREMARK,CREATE_DATE,UPDATE_DATE) "
			+ "VALUES (:PRODUCTNAME, :PRODUCTPRICE,:PRODUCTPRICESALE,:PRODUCTIMG,:PRODUCTTYPE,:PRODUCTNUM,:PRODUCTCONTENT,:PRODUCTSPENMATERIAL,:PRODUCTSPENSIZE,:PRODUCTSPENMF,:PRODUCTREMARK,:CREATE_DATE,:UPDATE_DATE);", nativeQuery = true)
	// 回傳Int表示新增的資料筆數，透過@Param("")來對應SQL語法裡面的參數，@Param("MARKET_CODE")對應:MARKET_CODE，以此類推
	public int addProduct(@Param("PRODUCTNAME") String PRODUCTNAME, @Param("PRODUCTPRICE") String PRODUCTPRICE,
			@Param("PRODUCTPRICESALE") String PRODUCTPRICESALE,@Param("PRODUCTIMG") String PRODUCTIMG,@Param("PRODUCTTYPE") String PRODUCTTYPE,
			@Param("PRODUCTNUM") String PRODUCTNUM,@Param("PRODUCTCONTENT") String PRODUCTCONTENT,@Param("PRODUCTSPENMATERIAL") String PRODUCTSPENMATERIAL,
			@Param("PRODUCTSPENSIZE") String PRODUCTSPENSIZE,@Param("PRODUCTSPENMF") String PRODUCTSPENMF,@Param("PRODUCTREMARK") String PRODUCTREMARK,
			@Param("CREATE_DATE") String CREATE_DATE,@Param("UPDATE_DATE") String UPDATE_DATE);
}
