<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ホテル検索</title>
</head>
<body>
	<h2>ホテル検索</h2>
	<form:form action="${pageContext.request.contextPath}/10km/search"
		modelAttribute="hotelForm">
		<form:errors path="price" element="div"/>
	一泊料金
	<form:input path="price" />
	円以下
	<input type="submit" value="検索">
	</form:form>
	<c:forEach var="hotel" items="${hotelList}">
		<table border="1">
			<tr>
				<th>ホテル名</th>
				<td><c:out value="${hotel.hotelName}" /></td>
			</tr>
			<tr>
				<th>最寄り駅</th>
				<td><c:out value="${hotel.nearestStation}" /></td>
			</tr>
			<tr>
				<th>価格</th>
				<td><fmt:formatNumber value="${hotel.price}" pattern="###,###円"/></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>