<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page errorPage="/jsp/sessionInvalidate.jsp" %>
<script language="javaScript" type="text/javascript" src="script/calendar.js"></script>
<script type="text/javascript" src="./script/rescuefieldvalues.js"></script>
<link href="css/calendar.css" rel="stylesheet" type="text/css">
<title>View the recently completed application</title>
<script>
function confirmDelete()
{
	var r=confirm(" Delete This Application? ");
	if(r==true)
	{
		return true;
	}else
	{	
	return false;
	}
}
function ValidateForm(){

	if(document.getElementById('startDate').value.length==0)
		{
			alert('Select Start Date');
			return false;
		}	
	if(document.getElementById('endDate').value.length==0)
	{
		alert('Select Stop Date ');
		return false;
	}
	}
		
</script>
<table><tr>
<td>
	<section class="main">
		<h1>Completed Reflections</h1>
	</section>
	<div class="panel panel-primary form-panel">
		<div class="panel-heading">Select the date range</div>
		<div class="panel-body">
			<form role="form" action="adminApplication.do?action=viewRecent" method="post" onsubmit='return ValidateForm();'>
				<div class="form-group">
					 <label for="startDate">Start Date:</label>
					 <input type="text"
						name="startDate" id="startDate" class="form-control" style="width:95%; display:inline"><a href="#"
						onClick="setYears(2003, 2032); showCalender(this, 'startDate');">
							<img src="images/calender.png">
					</a>(yyyy-mm-dd)
			  	</div>
				<div class="form-group">
					 <label for="endDate">Stop Date:</label>
					 <input
						type="text" name="endDate" id="endDate"  class="form-control" style="width:95%; display:inline"><a href="#"
						onClick="setYears(2003, 2032); showCalender(this, 'endDate');">
							<img src="images/calender.png">
					</a>(yyyy-mm-dd)
			  	</div>
		 		<html:submit property="action" value="View" styleClass="btn btn-primary" />
				<input type="button" value="Cancel" class="btn btn-primary" onclick="javascript: window.location.href='./adminHome.do';">
					  	
			 </form>
		</div>
	</div>	
</td>
<td width="200px"></td>

<td>
	<section class="main">
		<h1>Reports</h1>
	</section>
	<div class="panel panel-primary form-panel" \>
		<div class="panel-heading">Select Attributes</div>
		<div class="panel-body">
			<form role="form" action="adminApplication.do?action=viewRecent" method="post" onsubmit='return ValidateForm();'>
				<select name="EmpLevel" id="EmpLevel" style="width:175px">
				<option value="Manager">Manager</option>
				<option value="Principal Consultant">Principal Consultant</option>
				<option value="Senior Manager">Senior Manager</option>
				<option value="Associate Manager">Associate Manager</option>
				<option value="Senior Consultant">Senior Consultant</option>
				<option value="Director">Director</option>
				<option value="Senior Director">Senior Director</option>
				<option value="Senior Specialist">Senior Specialist</option>
			</select>
			
			<a style="margin-left:10px;" class="btn btn-primary" href="adminApplication.do?action=viewOverALLSurvey" onclick="appendLevel(this,'level','null')">View report</a>
			<br>
			<br><br>
			<select name="EmpComp" id="EmpComp" style="width:175px">
			<option value="Competency">Competency</option>
			</select>
			<a style="margin-left:10px;" class="btn btn-primary" href="adminApplication.do?action=viewCompetency" onclick="appendLevel(this,'null','comp')">View report</a>
			<br>
			<br>
					  	
			 </form>
		
		
		<div align="center"><a style="margin-left:10px;" class="btn btn-primary" href="adminApplication.do?action=viewCompetency" onclick="appendLevel(this,'level','comp')">View selected report</a>
			<br><br><br>
			
			<a style="margin-left:10px;" class="btn btn-default" href="adminApplication.do?action=viewOverALLSurvey" onclick="appendLevel(this,'null','null')">View all report</a>
			<br>
			</div>
			</div>
	</div>	
</td>
	</td>
</tr>
</table>
<!-- Calender Script  -->
<table id="calenderTable">
	<tbody id="calenderTableHead">
		<tr>
			<td colspan="4" align="center">
				<select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value, this.selectedIndex, false));" id="selectMonth">
					<option value="0">Jan</option>
					<option value="1">Feb</option>
					<option value="2">Mar</option>
					<option value="3">Apr</option>
					<option value="4">May</option>
					<option value="5">Jun</option>
					<option value="6">Jul</option>
					<option value="7">Aug</option>
					<option value="8">Sep</option>
					<option value="9">Oct</option>
					<option value="10">Nov</option>
					<option value="11">Dec</option>
			</select>
		</td>
		<td colspan="2" align="center">
			<select	onChange="showCalenderBody(createCalender(this.value, document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
			</select>
		</td>
		<td align="center">
			<a href="#" onClick="closeCalender();">
				<font color="#003333" size="+1">X</font>
			</a>
		</td>
		</tr>
	</tbody>
	<tbody id="calenderTableDays">
		<tr style="">
			<td>Sun</td>
			<td>Mon</td>
			<td>Tue</td>
			<td>Wed</td>
			<td>Thu</td>
			<td>Fri</td>
			<td>Sat</td>
		</tr>
	</tbody>
	<tbody id="calender"></tbody>
</table>

<form action="./OverAllReport" method="post">
	<div class="table-responsive clear_both">
		<%String message= (String)request.getAttribute("deleteApp");
		if(message!=null){
		%>
			<table class="table table-striped">
			<tr align="center"><td>&nbsp;</td><td><b><%=message%></b></td></tr>
			</table>
		<%} else{%>
			<display:table class="table table-striped" id="recentdata" name="sessionScope.recentApp" requestURI="#" pagesize="4" decorator="com.ciber.common.action.AdminAppDecorator">
			<display:setProperty name="basic.msg.empty_list" value="No records available in the given date range." />
			<display:setProperty name="paging.banner.item_name" value="" />
			<display:setProperty name="paging.banner.all_items_found" value="" />
			<display:setProperty name="paging.banner.one_item_found" value="" />
			<display:setProperty name="paging.banner.onepage" value="" />
			<display:column property="appName" title="Reflection Name" sortable="true"/>
			<display:column property="startDate" title="Start Date" sortable="true" />
			<display:column property="endDate" title="End Date" sortable="true" />
			<display:column property="completedFlag" title="Status" sortable="true" />
			<%-- <display:column property="editApp" />
			<display:column property="delete" /> --%>
			<display:column property="downloadReports" title="Download"  />
			<display:column property="view" />
			</display:table>
		<%} %>
	</div>
	<!-- <table align="center" width="100%" >
	<tr align="center"><td>&nbsp;</td>
		<td><b>Downlaod All survey reports : <a href=overAllReport.do>DownloadAll</a></b></td> 
	</tr>
	
	</table> -->
</form>
 <script type="text/javascript">
//call this function at the END of your page
//SYNTAX: rescuefieldvalues(['fieldid1', 'fieldid2', 'etc'])

rescuefieldvalues(['startDate', 'endDate']); //rescue data entered for form fields "address" and "feedback"

function appendLevel(t,h,k){
	var selectedLevel = document.getElementById("EmpLevel");
	var selectedComp = document.getElementById("EmpComp");
	var strUser = selectedLevel.options[selectedLevel.selectedIndex].value;
	var strComp = selectedComp.options[selectedComp.selectedIndex].value;
	
	if(h=="level" && k=="null"){
		t.href = t.href + "&level="+strUser;
	}
	if(k=="comp" && h=="null"){
		t.href = t.href + "&comp="+strComp;
	}
	if(k=="comp" && h=="level"){
		t.href = t.href + "&level="+strUser+"&comp="+strComp;
		
	}
}
</script>
