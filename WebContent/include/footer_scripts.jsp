<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String str = Long.toHexString(System.currentTimeMillis()); // กันไม่ให้ browser cache ไฟล์ css
%>

<!-- jquery -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>  

<script>
	var context_path = "${pageContext.request.contextPath}";
	var plugin_path = '${uri}/contents/js/'; 
</script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async="true"
	src="https://www.googletagmanager.com/gtag/js?id=UA-123786858-3"></script>


