<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js">
</script>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jobregist/save" method="post">
	<p>个人信息相关</p>
		ID:<input name="bip.bipId"/>
		身份证号:<input name="bip.bipCitizenid" />
		性别:<input name="bip.bipSex" />
		年龄:<input name="bip.bipAge" />
		姓名:<input name="bip.bipName" />
		生日:<input name="bip.bipBirthday" />
	<hr/>
	<p>求职登记相关</p>
		求职编号:<input name="zjGrqzdjb.qzbh" />
		个人编号:<input name="zjGrqzdjb.bipId" />
		单位性质:<input name="zjGrqzdjb.dwxx"/>
		经济类型:<input name="zjGrqzdjb.dwjjlx"/>
	<hr/>
	<p>求职工种</p>	
		求职工种编号:<input name="zjGrqzgzbs[0].qzgzbh"/>
		求职编号:<input name="zjGrqzgzbs[0].qzbh"/>
		序号:<input name="zjGrqzgzbs[0].xh"/>
		工种:<input name="zjGrqzgzbs[0].gz"/><br/>
		求职工种编号:<input name="zjGrqzgzbs[1].qzgzbh"/>
		求职编号:<input name="zjGrqzgzbs[1].qzbh"/>
		序号:<input name="zjGrqzgzbs[1].xh"/>
		工种:<input name="zjGrqzgzbs[1].gz"/><br/>
		<hr/>
	<p>个人外语</p>
		<input name="bipForeignlanguags[0].bipFlId"/>
		<input name="bipForeignlanguags[0].bipId"/>
		<input name="bipForeignlanguags[0].bipFlYears"/><br/>
		<input name="bipForeignlanguags[1].bipFlId"/>
		<input name="bipForeignlanguags[1].bipId"/>
		<input name="bipForeignlanguags[1].bipFlYears"/><br/>
		<input type="submit"  value="提交"/>
</form>
</body>
</html>