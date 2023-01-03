package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.ArticleModel;

import jakarta.transaction.Transactional;


public interface ArticleRepository extends JpaRepository<ArticleModel,Long>{

	
	// 註記為事務交易
		@Transactional
		// 註記為資料異動
		@Modifying
		// 使用標準的SQL Insert語法來寫入資料，冒號+名稱來表示要帶入的參數
		@Query(value = "INSERT INTO OCEAN_article(VALUEEN, ARTICLEIMG,ARTICLETITLE,ARTICLECONTENT,ARTICLEREMARK,ARTICLESTATUS,CREATE_DATE,UPDATE_DATE) "
				+ "VALUES (:VALUEEN, :ARTICLEIMG,:ARTICLETITLE,:ARTICLECONTENT,:ARTICLEREMARK,:ARTICLESTATUS,:CREATE_DATE,:UPDATE_DATE);", nativeQuery = true)
		// 回傳Int表示新增的資料筆數，透過@Param("")來對應SQL語法裡面的參數，@Param("MARKET_CODE")對應:MARKET_CODE，以此類推
		public int addArticle(@Param("VALUEEN") String VALUEEN, @Param("ARTICLEIMG") byte[] ARTICLEIMG,
				@Param("ARTICLETITLE") String ARTICLETITLE,@Param("ARTICLECONTENT") String ARTICLECONTENT,@Param("ARTICLEREMARK") String ARTICLEREMARK,
				@Param("ARTICLESTATUS") String ARTICLESTATUS,
				@Param("CREATE_DATE") String CREATE_DATE,@Param("UPDATE_DATE") String UPDATE_DATE);
}
