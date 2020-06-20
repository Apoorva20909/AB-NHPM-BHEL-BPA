<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Screen</title>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment Detail Screen</title>
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

}
</style>
</head>
<body style="background: azure;">
    <div align="center">
        <h1>Payment Detail Screen</h1>
     	<br><br>
     	
     <form:form action="saveEmployee" method="post" commandName="employee">
     
     <div ng-app="">
   			     	
     	<h1 style="background: antiquewhite; width: 550px; font-style: oblique; font-family: monospacecolor: red;">${message}</h1>
     	
    	<div style="background: aliceblue;height: 140px;width: 400px;"> 
      <table class="tbl">
		<tr>
			<td>Total UTIITSL fee Amount</td>
			<td><form:input path="bps_bpa_grss_fee" value="${totalGrssfee}" style="text-align:center;background: aliceblue;" readonly="true" type="number" ng-model="a" ng-init="a =${totalGrssfee}"/></td>
		</tr>
		<tr>
			<td>Total Tax on Fee</td>
			<td><form:input path="bps_bpa_tax_on_bpafee" value="${totaltaxonbpafee}" style="text-align:center;background: aliceblue;" readonly="true" type="number" ng-model="b" ng-init="b =${totaltaxonbpafee}"/></td>
		</tr>
		<tr>
			<td>Total TDS amount </td>
			<td><form:input path="bps_bpa_tds_fee" value="${totalbpatdsfee}" style="text-align:center;" ng-model="c" placeholder="${totalbpatdsfee}" ng-init="c =${totalbpatdsfee}" type="number"/></td>
		</tr>
		<tr>
			<td>Net Payable Amount </td>
			<td><form:input path="bps_bpa_net_fee" value="{{ a + b + c }}" style="text-align:center;background: aliceblue;" type="number"/>
		</tr>
		
	</table>
       </div> 
     </div>
    

        <table>
            <form:hidden path="bps_id"/>
            <form:hidden path="bps_sid_no" value="${CP_SID_NO}"/>
            <form:hidden path="bps_bpa_pymnt_rmrks" value="empty"/>
            <form:hidden path="bps_bpa_rcv_rmrks" value="empty"/>
            <form:hidden path="bps_lstupdt_usr" value="empty"/>
            <form:hidden path="bps_lstupdt_dt" value="1900-01-01" />
            <form:hidden path="bps_bpa_rcv_dt" value="1900-01-01"/>

             <tr>
                <td>Date of payment :</td>
                <td><form:input path="bps_bpa_pymnt_dt" placeholder="YYYY-MM-DD"/></td>
            </tr>
            <tr><td></td><tr>
             <tr>
                <td>Mode of payment :</td>
                <td>   
                	<form:select path="bps_bpa_pymnt_md" style="width: 177px;">
  						<form:option value="0" >Select Payment Mode</form:option>
  						<form:option value="1" >Cheque</form:option>
  						<form:option value="2" >NEFT</form:option>
  						<form:option value="3" >RTGS</form:option>
					</form:select>
				</td>
            </tr>
             <tr><td></td><tr>
             <tr>
                <td>Payment Trans no :</td>
                <td><form:input path="bps_bpa_pymnt_trnx" placeholder="Enter Tranx No."/></td>
            </tr>
                    
            <br><br>
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save" style="margin-top: 20px;"></td>
            </tr>
        </table>
        
        </form:form>
        
        <br>
        <form action="/BHEL/ctl/BPAFeeSettlement/search">
    		<input type="submit" value="Back" />
		</form>
		
    </div>
</body>
</html>