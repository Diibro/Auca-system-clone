package com.dushime.utility;

import java.net.URL;

public class PathExtract {
	 public static String getPathname(StringBuffer urlString) {
	        try {
	        	String str = new String(urlString);
	            URL url = new URL(str);
	            String path = url.getPath();
	            String[] segments = path.split("/");
	            return segments[segments.length - 1]; 
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
     }
	 
	 public static String getRedirect(String pathname, String role) {
		 if(role != null && role.equals("admin")) {
			 return null;
		 }
		 
		 switch(pathname) {
		 	case "apply.html":
		 	case "onlineRegistration.html":
		 	case "academics.html":
		 		if(role != null && role.equals("student")) {
		 			return null;
		 		}else {
		 			return "login.html";
		 		}
		 	case "media.html":
		 	case "research.html":
		 		if(role != null && role.equals("teacher")) {
		 			return null;
		 		}else {
		 			return "login.html";
		 		}
		 	default:
		 		return null;
		 }
		 
	 }
	 
//	  private static String getPathExt (String path) {
//		  return path.split(".")[-1];
//	  }
}
