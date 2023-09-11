package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.utils.TokenInterceptor;

@Configuration
public class CrosConfig implements WebMvcConfigurer{
	
	//解決跨域問題
	@Override
    public void addCorsMappings(CorsRegistry registry) {
		//映射路徑(目前為所有請求路徑都進行跨域處理)，若需特定路徑需更改: addMapping("/api/**") --> api為controller設定路徑
        registry.addMapping("/**")
        		//允許跨網域請求的來源(舊版使用)
                .allowedOrigins("*")
                //允許使用那些請求方式
                .allowedMethods("GET","HEAD","POST","PUT","DELETE")
                // 允許跨網域請求的來源，使用通配符 * 表示允許所有來源(新版Spring Framework 5.3.0 使用)
                // 若前端網址為http://192.168.0.9:3000，則需設定.allowedOriginPatterns("http://192.168.0.9:3000")
                .allowedOriginPatterns("*")
                // 預檢請求的緩存時間（單位：秒），在這段時間內，瀏覽器對於同一跨域請求不再發送預檢請求
                .maxAge(3600)
                //允許哪些Header
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
