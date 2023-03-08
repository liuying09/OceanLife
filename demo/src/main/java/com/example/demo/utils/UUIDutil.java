package com.example.demo.utils;

import java.util.UUID;

public class UUIDutil {
	public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
