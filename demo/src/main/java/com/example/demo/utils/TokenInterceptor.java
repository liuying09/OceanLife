package com.example.demo.utils;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//这里一定不要忘了设置OPTIONS这个跨域请求，第一个请求一般不带token，然后会发起第二次请求带token
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            System.out.println("跨域的第一次 OPTIONS 放行");
            return true;
        }
 
        //System.out.println("拦截了 manage");
        //从请求头中获取token
        String token = request.getHeader("token");
        	System.out.println(token);
 
        	//判断token是否正确
        if(token == null || token.equals("token")){
            System.out.println("未登入");
            return false;
        }
        //解析token
        if(!TokenUtils.verify(token)){
            System.out.println("解析失败");
            return false;
        }
 
        return true;
    }
	
}
