<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>博客论文</title>

<link rel="stylesheet" href="./css/blogDetail.css">
<script type="text/javascript" src="./common/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/blogDetail.js"></script>
</head>
<body>
<input id="bid" style="display:none" value="${bid}"/>
<div id="headPage"></div>
<div id="main_detail">
${content}
</div>
</body>
</html>