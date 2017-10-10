<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Kisi Ekle</title>
<style>.error{color:gray;}</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.min.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mycss.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="container">
	<h3 style="margin-top: 15 ">Kisi Ekle</h3>
	
	<form:form action="kisiSakla" modelAttribute="kisi" method="POST">
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>Isim :</label></td>
					<td><form:input path="ad"/></td>
					<td><form:errors path="ad" cssClass="error"/></td>
				</tr>
				<tr>
					<td><label>Soyisim :</label></td>
					<td><form:input path="soyad"/></td>
					<td><form:errors path="soyad" cssClass="error"/></td>
				</tr>
				<tr>
					<td><label>Telefon :</label></td>
					<td><form:input path="tel"/></td>
					<td><form:errors path="tel" cssClass="error"/></td>
				</tr>
				<tr>
					<td><label>eposta :</label></td>
					<td><form:input path="eposta"/></td>
					<td><form:errors path="eposta" cssClass="error"/></td>
				</tr>
				<tr>
					<td><label>Adres :</label></td>
					<td><form:input path="adres"/></td>
					<td><form:errors path="adres" cssClass="error"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><button type="submit" class="btn btn-secondary">Kaydet</button></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<div style="clear; both;"></div>
	<p>
		<button type="button" class="btn btn-secondary" onclick="window.location.href='kisilerList'; return false;">Kisi Listesine Dön</button>
</div>
</body>
</html>