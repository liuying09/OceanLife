package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
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
	
	@RequestMapping("/addArticle")
//	public void saveArticle(@ModelAttribute ArticleModel articleModel,@RequestParam(name="articleImg",required = false) MultipartFile fileField) throws IOException {
	public void saveArticle(@RequestParam(name="value",required = false)String valueEN ,
			@RequestParam(name="title",required = false)String articleTitle
			,@RequestParam(name="content",required = false)String articleContent
			,@RequestParam(name="remark",required = false)String articleRemark
			,@RequestParam(name="status",required = false)String articleStatus
			,@RequestParam(name="file-to-upload",required = false) MultipartFile fileField) throws IOException {
		
		
//		ArticleModel aModel = new ArticleModel();
//		aModel.setValueEN(articleModel.getValueEN());
//		aModel.setArticleTitle(articleModel.getArticleTitle());
//		aModel.setArticleStatus(articleModel.getArticleStatus());
//		aModel.setArticleContent(articleModel.getArticleContent());
//		aModel.setArticleRemark(articleModel.getArticleRemark());
		
		System.out.println("articleModel.getValueEN()= "+valueEN);
		System.out.println("articleModel.getArticleTitle()= "+articleTitle);
		System.out.println("articleModel.getArticleContent()= "+articleContent);
		System.out.println("articleModel.getArticleRemark()= "+articleRemark);
		System.out.println("articleModel.getArticleStatus()= "+articleStatus);
		
//		System.out.println("articleModel.getValueEN()= "+articleModel.getValueEN());
//		System.out.println("articleModel.getArticleTitle()= "+articleModel.getArticleTitle());
//		System.out.println("articleModel.getArticleContent()= "+articleModel.getArticleContent());
//		System.out.println("articleModel.getArticleRemark()= "+articleModel.getArticleRemark());
//		System.out.println("articleModel.getArticleStatus()= "+articleModel.getArticleStatus());
		
		byte[] image;

		if(fileField == null) {
			System.out.println("111");
			image=null;
		}else {
			System.out.println("222");
			image=fileField.getBytes();
		}
		
//		articleRepository.addArticle(articleModel.getValueEN(), image, articleModel.getArticleTitle(), 
//				articleModel.getArticleContent(), articleModel.getArticleRemark(), articleModel.getArticleStatus(), null, null);
		articleRepository.addArticle(valueEN,image,articleTitle,articleContent,articleRemark,articleStatus,null, null);
	}
	
	
}
