<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter,java.util.*,java.io.*"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
	
	String hostname="";
	Properties pro = new Properties();
	String realpath = request.getRealPath("/WEB-INF/classes");
	try{
		FileInputStream in = new FileInputStream(realpath+"/config.properties");
		pro.load(new InputStreamReader(in,"UTF-8"));
		
	}
	catch(FileNotFoundException e){
		out.println(e);
	}
	catch(IOException e){
		out.println(e);
	}
	
	hostname = pro.getProperty("web.rootPath");
	

	out.write( new ActionEnter( request,hostname , rootPath ).exec() );
	
%>