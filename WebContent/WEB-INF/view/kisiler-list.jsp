<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Kisiler</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.min.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mycss.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="margin-top: 10">
<div class="container">
<button style="margin-bottom: 1" type="button" class="btn btn-secondary" onclick="window.location.href='showFormForAdd'; return false;">Kisi Ekle</button>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Kisilerde Ara...">
<table id="myTable">
  <tr class="header">
    <th>Isim</th>
    <th>Soyisim</th>
    <th>Telefon</th>
    <th>Eposta</th>
    <th>Adres</th>
    <th>Action</th>
  </tr>
  <c:forEach var="tempKisi" items="${kisiler}">
  	<c:url var="updateLink" value="/kisi/showFormForUpdate" >
  		<c:param name="kisiId" value="${tempKisi.id}"></c:param>
  	</c:url>
  	<c:url var="deleteLink" value="/kisi/delete" >
  		<c:param name="kisiId" value="${tempKisi.id}"></c:param>
  	</c:url>
  	<tr>
  		<td>${tempKisi.ad}</td>
  		<td>${tempKisi.soyad}</td>
  		<td>${tempKisi.tel}</td>
  		<td>${tempKisi.eposta}</td>
  		<td>${tempKisi.adres}</td>
  		<td>
  			<a href="${updateLink}" class="btn btn-secondary">Güncelle</a>
  			|
  			<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModal">Sil</button>
  			<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Kisi Sil</h4>
        </div>
        <div class="modal-body">
          <p>Kisiyi silmek istediginize emin misiniz?</p>
        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-default" onclick="window.location.href='${deleteLink}'; return false;">OK</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  		</td>
  	</tr>
  </c:forEach>
</table>
</div>

<script>
function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
</script>

</body>
</html>