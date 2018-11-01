<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>プロ野球セントラル・リーグ一覧</title>
</head>
<body>
<h3>プロ野球<br>セントラル・リーグ一覧</h3>
<c:forEach var="team" items="${teamList}">
	<a href="${pageContext.request.contextPath}/5km/detailteam?id=<c:out value="${team.id}"/>">
		<c:out value="${team.teamName}"/><br>
	</a>
</c:forEach>
</body>
</html>