package com.example.demo.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.bean.UserModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtils {
	
//  签名过期时间 10个小时
  private static final long EXPIRE_TIME = 10*60*60*1000;
//  签名秘钥 可以自己设定
  private static final String PRIVATE_KEY = "shuisanyafafafdfwefdvsdvwevwbvvgrhmjghjgsbhabavavzxvad";
//  生成token
  
  public static String sign(UserModel user){
      String token = "";
      Map<String,Object> header = new HashMap<>();

      header.put("typ","JWT");
      header.put("alg","HS256");

      Map<String ,Object> claims = new HashMap<>();

//      自定义有效荷载部分
      claims.put("account",user.getUserAccount());

      token = Jwts.builder()
//              发证人
              .setIssuer("auth")
//              jwt头
              .setHeader(header)
//              有效负荷
              .setClaims(claims)
//              设定签订时间
              .setIssuedAt(new Date())
//              设定过期时间
              .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
//              使用SignatureAlgorithm.HS256算法，加密，秘钥是：PRIVATE_KEY
              .signWith(SignatureAlgorithm.HS256,PRIVATE_KEY)
              .compact();

      return token;
  }

//  生成token是否正确
  public static boolean verify(String token){

      try {
          Jwts.parser()
              .setSigningKey(PRIVATE_KEY)
              .parseClaimsJws(token).getBody();
          return true;
      }catch (Exception e){
          return false;
      }
  }

}
