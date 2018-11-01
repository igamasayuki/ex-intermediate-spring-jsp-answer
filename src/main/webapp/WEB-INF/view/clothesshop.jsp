<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>洋服ショップ</title>
</head>
<body>
	<h2>洋服shop</h2>
	<h3>好きな色を選択してください</h3>
	<form:form action="${pageContext.request.contextPath}/15km/search"
		modelAttribute="shopForm">
		<form:errors path="gender" element="div"/>
		<form:radiobuttons path="gender" items="${genderMap}" />
		<form:select path="color" items="${colorMap}" />
		<input type="submit" value="検索">
	</form:form>

	<c:forEach var="shop" items="${shopList}">
		<table border="1">
			<tr>
				<th>ジャンル</th>
				<td><c:out value="${shop.genre}" /></td>
			</tr>
			<tr>
				<th>サイズ</th>
				<td><c:out value="${shop.size}" /></td>
			</tr>
			<tr>
				<th>価格</th>
				<td><fmt:formatNumber value="${shop.price}" pattern="###,###円" />
			</tr>
		</table>
	</c:forEach>
</body>
</html>