<%@page import="com.ciber.beans.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/jsp/sessionInvalidate.jsp"%>
<script language="javaScript" type="text/javascript"
	src="script/calendar.js"></script>
<script src="<%=request.getContextPath()%>/script/autocompleter.js"></script>
<link href="css/calendar.css" rel="stylesheet" type="text/css">
<section class="main">
	<h1>Manager Search</h1>
</section>
<div class="row">
	<div class="col-md-6">
		<div class="panel panel-primary form-panel-in-col">
			<div class="panel-heading">Employee Name</div>
			<div class="panel-body">
				<html:form action="adminApplication.do?action=searchAction"
					enctype="multipart/form-data" method="post"
					onsubmit='return ValidateForm();'>
		
					<div class="form-group">
						<label for="managerName">Enter Minimum three characters</label> <input
							type="text" id="managerName" name="managerName"
							class="form-control" /> <input type="hidden" id="employeeEmail"
							name="employeeEmail" value="" /> <input type="hidden" id="empID"
							name="empID" value="" />
					</div>
					<div class="form-group">
						<div id="managerNameInfo"></div>
					</div>
					<div class="form-group">
						<div id="searchError"
							style="color: red; padding-bottom: 10px; padding-left: 10px;"
							align="left"></div>
					</div>
					<input type="button" value="Search" class="btn btn-primary"
						id="seach" />
					<input type="button" value="Cancel" class="btn btn-primary"
						onclick="javascript: window.location.href='./adminHome.do';">
				</html:form>
		</div>
	</div>
	</div>
	
	<div class="col-md-6">
		<div class="panel panel-primary form-panel-in-col" id="managerinfo">
			<div class="panel-heading">Manager Information</div>
			<div class="panel-body">
				<form action="">
					<input type="hidden" id="empid" name="empid" value="" />
		
					<div class="form-group">
						<label for="peer1">PEER 1:</label> <input type="text" id="peer1"
							name="peer1" class="form-control" />
						<div id="peer1Info"></div>
						<input type="hidden" id="peer1Email" name="peer1Email" />
					</div>
		
					<div class="form-group">
						<label for="peer2">PEER 2:</label> <input type="text" id="peer2"
							name="peer2" class="form-control" />
						<div id="peer2Info"></div>
						<input type="hidden" id="peer2Email" name="peer2Email" />
					</div>
		
					<div class="form-group">
						<label for="crossfunction">CROSS FUNCTIONAL:</label> <input
							type="text" id="crossfunction" name="crossfunction"
							class="form-control" />
						<div id="crossfunctionInfo"></div>
						<input type="hidden" id="crossfunctionEmail"
							name="crossfunctionEmail" />
					</div>
		
					<div class="form-group">
						<label for="crossfunction">ADMIN:</label> <input type="text"
							id="admin" name="admin" class="form-control" />
						<div id="adminInfo"></div>
						<input type="hidden" id="adminEmail" name="adminEmail" />
					</div>
		
		
		
					<div class="form-group">
						<label for="crossfunction">HR:</label> <input type="text" id="hr"
							name="hr" class="form-control" />
						<div id="hrInfo"></div>
						<input type="hidden" id="hrEmail" name="hrEmail" />
					</div>
		
		
					<div class="form-group">
						<label for="crossfunction">IT:</label> <input type="text" id="it"
							name="it" class="form-control" />
						<div id="itInfo"></div>
						<input type="hidden" id="itEmail" name="itEmail" />
					</div>
		
					<div class="form-group">
						<label for="crossfunction">QMO:</label> <input type="text" id="qmo"
							name="qmo" class="form-control" />
						<div id="qmoInfo"></div>
						<input type="hidden" id="qmoEmail" name="qmoEmail" />
					</div>
		
					<div class="form-group">
						<label for="crossfunction">RECRUITMENT:</label> <input type="text"
							id="recruitment" name="recruitment" class="form-control" />
						<div id="recruitmentInfo"></div>
						<input type="hidden" id="recruitmentEmail" name="recruitmentEmail" />
					</div>
		
					<div class="form-group">
						<label for="crossfunction">FINANCE:</label> <input type="text"
							id="finance" name="finance" class="form-control" />
						<div id="financeInfo"></div>
						<input type="hidden" id="financeEmail" name="financeEmail" />
					</div>
		
					<div class="form-group">
						<label for="crossfunction">RMG:</label> <input type="text" id="rmg"
							name="rmg" class="form-control" />
						<div id="rmgInfo"></div>
						<input type="hidden" id="rmgEmail" name="rmgEmail" />
					</div>
			<div class="form-group">
				<div id="message"></div>
				<div id="error"
					style="color: red; padding-bottom: 10px; padding-left: 10px;"></div>
			</div>
			<input property="action" value="Update Information"
				class="btn btn-primary" id="updateID" />
			 <input type="button"
				id="close" value="close" class="btn btn-primary">
			</form>
			</div>
		</div>
	</div>
</div>





