<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>球団情報</title>
</head>
<body>
<h3>球団名</h3>
<c:out value="${team.teamName}"/><br>
<h3>本拠地</h3>
<c:out value="${team.headquarters}"/><br>
<h3>発足</h3>
<c:out value="${team.inauguration}"/><br>
<h3>歴史</h3>
<pre>
<c:out value="${team.history}"/>
</pre>
<br>
<form action="${pageContext.request.contextPath}/5km/teamlist" method="post">
	<input type="submit" value="戻る">
</form>
</body>
</html>