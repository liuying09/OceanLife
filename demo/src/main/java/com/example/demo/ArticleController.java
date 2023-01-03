package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@RequestMapping("/addArticle")
	public void saveArticle(@RequestBody ArticleModel articleModel,@RequestParam(name="fileField",required = false) MultipartFile fileField) throws IOException {
		
//		ArticleModel aModel = new ArticleModel();
//		aModel.setValueEN(articleModel.getValueEN());
//		aModel.setArticleTitle(articleModel.getArticleTitle());
//		aModel.setArticleStatus(articleModel.getArticleStatus());
//		aModel.setArticleContent(articleModel.getArticleContent());
//		aModel.setArticleRemark(articleModel.getArticleRemark());
		
		byte[] image;

		if(fileField == null) {
			image=null;
		}else {
			image=fileField.getBytes();
		}
		
//		articleRepository.save(aModel);
		articleRepository.addArticle(articleModel.getValueEN(), image, articleModel.getArticleTitle(), 
				articleModel.getArticleContent(), articleModel.getArticleRemark(), articleModel.getArticleStatus(), null, null);
	}
	
	
}
