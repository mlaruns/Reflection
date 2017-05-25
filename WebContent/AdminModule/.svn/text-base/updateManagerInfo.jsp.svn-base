<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/jsp/sessionInvalidate.jsp"%>
<script type="text/javascript">
function openFileOption()
{
	window.location.href ='./templates/People Managers List.xls';
}

function cancel()
{
	window.location.href='./adminHome.do';
}
</script>
<section class="main">
	<h1>Upload Manager Peers information</h1>
</section>
	<%
					String message = (String) request.getAttribute("message");
					if (message != null) {
				%>
	<b style="color: red;"><%=message%></b>
	<%
					}
				%>
	<p>
		<b>Please download questions template: <input type="button"
			name="image" Value="Download Template" class="btn btn-primary"
			onclick="openFileOption()">
		</b>
	</p>
	<hr>

	<p>
		<b>Please upload the file</b>
	</p>
	<html:form action="adminApplication.do?action=uploadManagerData"
		enctype="multipart/form-data" method="POST">
		<html:file property="formFile" name="applicationModel"
			style="width: 280px" />
		<div style="padding-top: 10px;">
			<input type="Submit" value="Upload File" class="btn btn-primary">
			<input type="button" value="Cancel" class="btn btn-primary"
				onclick="javascript: window.location.href='./adminHome.do';">
		</div>
	</html:form>
