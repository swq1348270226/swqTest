package com.swq.BlogSystem.util;

import java.util.UUID;


public class UUIDUtil {
	
	public static String getUUID() {
		String uid = "";
		UUID id = UUID.randomUUID();
		if(id == null) {
			return "";
		}
		 uid = id.toString().replaceAll("-", "");
		 return uid;
	}

}
