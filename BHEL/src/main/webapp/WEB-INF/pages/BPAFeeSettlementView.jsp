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
<title>BPAFeeSettlement</title>
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<script src="../resources/js/jquery.min.js"></script>
<script src="../resources/js/jquery-1.12.4.js"></script>
<script src="../reources/js/jquery-ui.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/BHEL/resources/js/bootstrap.min.css">
<link rel="stylesheet" href="/BHEL/resources/js/font-awesome.min.css">
<script>

	function selectAll(source) {
		checkboxes = document.getElementsByName('ids');
		for (var i = 0, n = checkboxes.length; i < n; i++) {
			checkboxes[i].checked = source.checked;
		}
	}

	function selectone(so) {
		checkboxes = document.getElementById('mainbox');
		unbox = document.getElementsByName('ids');
		var box = false;
		for (var i = 0, n = unbox.length; i < n; i++) {
			if (unbox[i].checked == true) {
				box = true;
			} else {
				box = false;
				break;
			}
		}
		checkboxes.checked = box;
	}
</script>

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
<body style="background: azure;">
	
	<br><br>
	<h1 align="center">BPA fee Settlement</h1>
	
	<sf:form action="search" commandName="form" method="post">

	<br>
	<br>

	<table style="width: 100%">
		<tr>
			<td align="center"><label> SID No :</label> <input type="text"
				name="CP_SID_NO" placeholder="Enter Sid Number" value=""> &emsp;
				<Button type="submit" name="operation" value="Search">Search</Button> &emsp;
				<Button type="submit" name="operation" value="Reset">Reset</Button> 
		</tr>
	</table>
	<br>	<br> <br>
	
	<h1 align="center" >${message}</h1>
	
	<c:choose>
	<c:when test="${empty CP_SID_NO}">
	</c:when>
	<c:otherwise>
	
	<table class="tbl">
		<tr bgcolor="#BFC9CA">

			<!-- <th><input type="checkbox" id="mainbox"
				onchange="selectAll(this)">Select All</th>
			-->
			<th></th>
			<th>Sid_no</th>
			<th>No Of claims</th>
			<th>UTIITSL Fee</th>
			<th>Tax on fee</th>
			<th>TDS on fee</th>
			<th>Net fee amount</th>
		</tr>
		
		<c:forEach items="${list}" var="data" varStatus="ct">
		</c:forEach> 
		
		<tr align="center">
		
			<td><input type="checkbox" name="ids" checked="true" value=""></td>
				
			<c:url var="editUrl" value="/ctl/BPAFeeSettlement/sidno?sid=" />	
				
			<td><a href="${editUrl}${CP_SID_NO}" target="popup" 
  			onclick="window.open('${editUrl}${CP_SID_NO}','popup','width=1200,height=400'); return false;">
  			${CP_SID_NO}</a></td>
  			
			<td>${No_of_Claims}</td>
			<td>${totalGrssfee}</td>
			<td>${totaltaxonbpafee}</td>
			<td>${totalbpatdsfee}</td>
			<td>${totalbpanetfee}</td>

		</tr>
		
	</table>
	
	<br>
	
	<!-- <div align="center"><Button type="submit" name="operation" value="Submit">Submit</Button></div> -->
	
	</c:otherwise>
	</c:choose>
	
	</sf:form>
	
	<br>
	<div align="center">
	
	<c:if test="${not empty CP_SID_NO}">
	<form action="/BHEL/BPAFeePayment/newEmployee/${CP_SID_NO}">
    <input type="submit" value="Submit" />
	</form>
	</c:if>


	
	

</body>
</html>