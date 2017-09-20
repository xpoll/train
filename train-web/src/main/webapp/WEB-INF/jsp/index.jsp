<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1"/>
    <link rel="icon" type="image/x-icon" href="/resources/image/lm.ico">
</head>
<body>
	<jsp:include page="/title" />
	<jsp:include page="/tree" />
	<!--右侧中心页面-->
	<div class="center-page pull-left">
		欢迎光临
	</div>
	<jsp:include page="/foot" />
</body>
</html>
