package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.utils.TokenInterceptor;

@Configuration
public class CrosConfig implements WebMvcConfigurer{
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE")
                .allowedOriginPatterns("*")
                .maxAge(3600)
                .allowedHeaders("*");
    }
	
	
	private TokenInterceptor interceptor;
    @Autowired//装配拦截器
    public void setInterceptor(TokenInterceptor interceptor) {
        this.interceptor = interceptor;
    }
    
  //配置拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor)
//        		.addPathPatterns("/**") //需擋下的路徑
//        		.excludePathPatterns("/login", "/error") //不擋下的路徑
//		        .excludePathPatterns("/productPage", "/error") //不擋下的路徑
//		        .excludePathPatterns("/findArticle", "/error") //不擋下的路徑
//		        .excludePathPatterns("/findArticleByArticleID", "/error") //不擋下的路徑
//		        .excludePathPatterns("/findAllActivity", "/error") //不擋下的路徑
//		        .excludePathPatterns("/findByActivityID", "/error"); //不擋下的路徑
//    }

}
