<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BPAFeeSettlementSidNo</title>
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<script src="../resources/js/jquery.min.js"></script>
<script src="../resources/js/jquery-1.12.4.js"></script>
<script src="../reources/js/jquery-ui.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/BHEL/resources/js/bootstrap.min.css">
<link rel="stylesheet" href="/BHEL/resources/js/font-awesome.min.css">

<style>
.header {
	/* background-image: url("img/bg6.jpg"); */
	background-color: #BFC9CA;
	position: relative;
}

.header:hover {
	opacity: 0.8;
	filter: alpha(opacity = 80); /* For IE8 and earlier */
}

.form-control {
	margin-top: 10px;
}

.tbl {
	border-collapse: collapse;
	width: 100%;
}

.tbl td, .tbl th {
	border: 1px solid #A9A9A9;
	padding: 8px;
	text-align: center;
}

.tbl th {
	padding-top: 6px;
	padding-bottom: 6px;
	text-align: center;
	/* background-color: #A9A9A9;  */
	color: black;
}

#customers {
	border-collapse: collapse;
	width: 70%;
	margin-right: 32px;
}

#customers td, #customers th {
	border: 1px solid #A9A9A9;
	padding: 8px;
	text-align: center;
}

#customer {
	border-collapse: collapse;
	width: 70%;
	margin-top: 25px;
	margin-right: 32px;
}

#customer td, #customer th {
	border: 1px solid #A9A9A9;
	padding: 8px;
	text-align: center;
}

.heading {
	height: 16px;
}

.msgval {
	height: 5px;
	padding-bottom: 25px;
}
</style>

</head>
<body style="background: beige;">
							
	<br>
	
	<table class="tbl">
		<tr bgcolor="#BFC9CA">
			<th>S.No</th>
			<th>Unit Code</th>
			<th>Unit Name</th>
			<th>Bill No.</th>
			<th>Bill Date</th>
			<th>Patient Name</th>
			<th>Claim Id</th>
			<th>Claim Amt</th>
			<th>Aproved Amt</th>
			<th>UTIITSL Fee</th>
			<th>Tax on fee</th>
			<th>TDS on fee</th>
			<th>Net fee amount</th>
		</tr>
		
		<c:forEach items="${list}" var="data" varStatus="ct">
		
		
		<tr align="center">
			
			<td>${ct.index+1}</td>
			<td>${data[0]}</td>
			<td>${data[1]}</td>
			<td>${data[2]}</td>
			<td>${data[3]}</td>
			<td>${data[4]}</td>
			<td>${data[5]}</td>
			<td>${data[6]}</td>
			<td>${data[7]}</td>
			<td>${data[8]}</td>
			<td>${data[9]}</td>
			<td>${data[10]}</td>
			<td>${data[11]}</td>
		</tr>
		
		</c:forEach> 
		
	</table>
	
	<br><br>

	<div align="right" style="width: 1150px;"><button onclick="window.close();" 
	style=" width: 91px; height: 31px;">OK</button></div>
	
</body>
</html>
