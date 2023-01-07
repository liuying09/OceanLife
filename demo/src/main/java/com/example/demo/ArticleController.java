package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.ArticleModel;
import com.example.demo.dao.ArticleRepository;

@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@RequestMapping("/findArticle")
	public List<ArticleModel> findArticle(){
		
		List<ArticleModel> list = new ArrayList<ArticleModel>();
		list = articleRepository.findAll();
		
		return list;
	
	}
	
	@RequestMapping("/findArticleByArticleID")
	public ArticleModel findArticleByArticleID(@RequestBody ArticleModel articleModel) {
		System.out.println("articleID= "+articleModel.getArticleID());
		
		ArticleModel a = articleRepository.findAllByArticleID(articleModel.getArticleID());

		System.out.println("getCreateDate= "+a.getCreateDate());
		
		return articleRepository.findByArticleID(articleModel.getArticleID());
		
	}
	
	
	
	
	
	@RequestMapping("/addArticle")
//	public void saveArticle(@ModelAttribute ArticleModel articleModel,@RequestParam(name="articleImg",required = false) MultipartFile fileField) throws IOException {
	public void saveArticle(@RequestParam(name="value",required = false)String valueEN ,
			@RequestParam(name="title",required = false)String articleTitle
			,@RequestParam(name="content",required = false)String articleContent
			,@RequestParam(name="remark",required = false)String articleRemark
			,@RequestParam(name="status",required = false)String articleStatus
			,@RequestParam(name="file-to-upload",required = false) MultipartFile fileField) throws IOException {
		

		
		System.out.println("articleModel.getValueEN()= "+valueEN);
		System.out.println("articleModel.getArticleTitle()= "+articleTitle);
		System.out.println("articleModel.getArticleContent()= "+articleContent);
		System.out.println("articleModel.getArticleRemark()= "+articleRemark);
		System.out.println("articleModel.getArticleStatus()= "+articleStatus);

		SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
		Date date = new Date();
		String thisDate = ft.format(date);
		
		
		byte[] image;

		if(fileField == null) {
			System.out.println("file == null");
			image=null;
		}else {
			System.out.println("file != null");
			image=fileField.getBytes();
		}
		
//		articleRepository.addArticle(articleModel.getValueEN(), image, articleModel.getArticleTitle(), 
//				articleModel.getArticleContent(), articleModel.getArticleRemark(), articleModel.getArticleStatus(), null, null);
		articleRepository.addArticle(valueEN,image,articleTitle,articleContent,articleRemark,articleStatus,thisDate, null);
	}
	
	
	
	@RequestMapping("/updateArticle")
//	public void updateArticle(@ModelAttribute ArticleModel articleModel,@RequestParam(name="file-to-upload",required = false) MultipartFile fileField) throws IOException {
	public void updateArticle(@RequestParam(name="id",required = false)int articleID ,
			@RequestParam(name="value",required = false)String valueEN ,
			@RequestParam(name="title",required = false)String articleTitle
			,@RequestParam(name="content",required = false)String articleContent
			,@RequestParam(name="remark",required = false)String articleRemark
			,@RequestParam(name="status",required = false)String articleStatus
			,@RequestParam(name="file-to-upload",required = false) MultipartFile fileField) throws IOException {
		
		
		ArticleModel a = articleRepository.findByArticleID(articleID);
		
//		System.out.println("articleModel.getValueEN()= "+articleModel.getArticleTitle());
		
		System.out.println("articleID= "+articleID);
		System.out.println("valueEN= "+valueEN);
		System.out.println("articleTitle= "+articleTitle);
		System.out.println("articleContent= "+articleContent);
		System.out.println("articleRemark= "+articleRemark);
		System.out.println("articleStatus= "+articleStatus);

		SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
		Date date = new Date();
		String thisDate = ft.format(date);
		
		
		byte[] image;

		if(fileField == null) {
			System.out.println("file == null");
			image=a.getArticleImg();
		}else {
			System.out.println("file != null");
			image=fileField.getBytes();
		}
		
//		articleRepository.updateArticle(articleModel.getValueEN(), image, articleModel.getArticleTitle(), 
//				articleModel.getArticleContent(), articleModel.getArticleRemark(), articleModel.getArticleStatus(), null, null);
		articleRepository.updateArticle(valueEN,image,articleTitle,articleContent,articleRemark,articleStatus, thisDate,articleID);
	}
	
	@RequestMapping("/deleteArticle")
	public void deleteArticle(@RequestBody ArticleModel articleModel) {
		articleRepository.deleteArticle(articleModel.getArticleID());
	}
	
}
