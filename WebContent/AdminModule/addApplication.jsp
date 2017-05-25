<%@page import="com.ciber.beans.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/jsp/sessionInvalidate.jsp"%>
<script type="text/javascript" src="./script/rescuefieldvalues.js"></script>
<script language="javaScript" type="text/javascript"
	src="script/calendar.js"></script>
<link href="css/calendar.css" rel="stylesheet" type="text/css">
<%
User user=(User)session.getAttribute("user");
String date=new SimpleDateFormat("MM-dd-yyyy").format(new Date());
String surveyName="Reflection_"+user.getUserId()+"_"+date;
 %>
<SCRIPT LANGUAGE=javascript>

function SetDate()
{
	var startDate = new Date();
	var endDate = new Date();
	if(startDate.getDay()==0){
		startDate = startDate.getDate()+1;
	}
	if(startDate.getDay()==6){
		startDate = startDate.getDate()+2;
	}
	if(startDate.getDay()==1 || startDate.getDay==0 || startDate.getDay==6){
		endDate.setDate(startDate.getDate() + 4); 
	}
	else{
		endDate.setDate(startDate.getDate() + 6); 
	}
	setdate(startDate,'startDate');
	setdate(endDate,'endDate');
}

function setdate(date,id){
var day = date.getDate();
var month = date.getMonth() + 1;
var year = date.getFullYear();
if (month < 10) month = "0" + month;
if (day < 10) day = "0" + day;
var today = year + "-" + month + "-" + day;
document.getElementById(id).value = today;
}


function ValidateForm(){
 
var appNme = document.getElementById('appName');
var stdate = document.getElementById('startDate');
var stpdate = document.getElementById('endDate');
var empNo = document.getElementById('empNo');
 if(empNo==''){
 return false;
 }
if(!(appName(appNme,3,50)))
{
      return false;
}
if(!(checkdate(stdate,'Start'))){
      return false;
}
if(!(checkdate(stpdate,'Stop'))){
    return false;
}
if(!(subForm(stpdate))){
      return false;
}
}
 
function appName(appNme,mx,my){
      var letters = /^[0-9a-z A-Z]+$/;
    var appNme_len =appNme.value.length;
    if(appNme_len<1)
    {
    alert('Please enter Application name');
    appNme.focus();
    return false;
    }  
     else
    {
          return true;
    }
}
 
function checkdate(stdate,val){ 
    if(stdate.value.length<1)
    {
        alert("Please select "+val+" date");
        return false;
    }
  
        var validformat=/^\d{4}\-\d{2}\-\d{2}$/; //Basic check for format validity 
        var returnval=false ;
        if (!validformat.test(stdate.value)) 
        alert("Invalid Date Format. Please correct and submit again.") ;
        else{ 
            //Detailed check for valid date ranges 
        var yearfield=stdate.value.split("-")[0] ;
        var monthfield=stdate.value.split("-")[1] ;
        var dayfield=stdate.value.split("-")[2] ;
        var dayobj = new Date(yearfield, monthfield-1, dayfield) ;
        var current  = new Date();

        if(current.getMonth()+1 == dayobj.getMonth()+1){
        	if(dayobj.getDate() < current.getDate()){
    			alert("Expired "+val+" date,Please provide valid date");
        	}
        	else{
            	returnval = true;
        	}
        }
        else if(dayobj.getMonth()+1 < current.getMonth()+1){
		alert("Expired month,Please provide valid date");}
        
        else if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield)) {
        alert("Invalid Day, Month, or Year range detected. Please correct and submit again.") ;}
       	 
        else {
        returnval=true ;
        }
        
       } 
        if (returnval==false) 
          stdate.select();
        return returnval ;
  
}
function subForm(submod){
      var strtDate=document.getElementById('startDate');
      var stpdate = document.getElementById('endDate');
      var val=strtDate.value;
 
    var stopDATE =stpdate.value.split("-");
    
    var startDate = strtDate.value.split("-");
    //var x=new Date();
    //x.setFullYear(mySplitResult[2],mySplitResult[0],mySplitResult[1]);
   // var y=new Date();

    //alert(mySplitResult[2]+mySplitResult[0]+ mySplitResult[1] + x);
   // y.setFullYear(stopDATE[2],stopDATE[0],stopDATE[1]);


    if(startDate[0]<=stopDATE[1]){
	    if(startDate[1] == stopDATE[1]){
	    	if(startDate[2] < stopDATE[2])
				alert("Start Date cannot be Greater than the Stop date");
			return false;
	    }
	    if(startDate[1] > stopDATE[1]){
			alert("Start Date cannot be Greater than the Stop date");
	   		 return false;
	    }
    }
	
 
  return true;
}
function isDate(txtDate){
          var objDate,  // date object initialized from the txtDate string     
              day,      // day  
              mSeconds, // txtDate in milliseconds     
              month,    // month   
              year;     // year
              // date length should be 10 characters (no more no less)  
          if (txtDate.length !== 10) { 
                  return false;    
          }
          
// third and sixth character should be '/'     
          if (txtDate.substring(4, 5) !== '-' || txtDate.substring(7, 8) !== '-') {   
           return false;   
          } 
        
// extract month, day and year from the txtDate (expected format is mm/dd/yyyy) 
          // subtraction will cast variables to integer implicitly (needed 
          // for !== comparing) 
          
          year = txtDate.substring(0, 4) - 0;
        //  alert(year);
          month = txtDate.substring(5, 7) - 1;
        //  alert(month); // because months in JS start from 0 
          day = txtDate.substring(8,10) - 0;
       //   alert(day);    
          
if ((year < 1000) || (year > 3000) ){    
             return false;   
          }
               // convert txtDate to milliseconds    
               mSeconds = (new Date(year, month, day)).getTime(); 
               // initialize Date() object from calculated milliseconds 
               objDate = new Date();   
               objDate.setTime(mSeconds);    
               // compare input date and parts from Date() object   
               // if difference exists then date isn't valid 
              
if (objDate.getFullYear() !== year ||   
                objDate.getMonth() !== month ||     
                objDate.getDate() !== day) {   
                return false;  
          } 
          return true; 
}
 
</SCRIPT>
<script>

$(document).ready(function() {
	SetDate();
});

function removeUpload(){

	if(document.getElementById("dispId").checked == true){
		$("#removeUpload").hide();
	}
	else if(document.getElementById("dispId").checked == false){
		$("#removeUpload").show('fast');
	}
	
	
}
function openFileOption()
{
	window.location.href ='./Upload Users.xls';
}

</script>

<section class="main">
	<h1>Initiate Reflection</h1>
</section>

<logic:messagesPresent message="true">
	<html:messages id="aMsg" message="true">
		<logic:present name="aMsg">
			<!-- Messages -->
			<div class="messages">
				<bean:write name="aMsg" filter="false" />
			</div>
		</logic:present>
	</html:messages>
</logic:messagesPresent>

<div style="color: red" class="error-msg">
	<html:errors />
</div>

<html:form action="adminApplication.do?action=addApp"
	enctype="multipart/form-data" method="post"
	onsubmit='return ValidateForm();'>
	<div class="panel panel-primary form-panel">
		<div class="panel-heading">Enter reflection details</div>
		<div class="panel-body">
			<div class="form-group">
				 <label for="appName">Reflection Name*:</label>
				 <input type="text" name="appName" id="appName"
						value='<%=surveyName%>' readonly="readonly" class="form-control" />
		  	</div>
		  	<div class="form-group">
				 <label for="empNo">Employee No*:</label>
				 <input type="text" name="empNo" id="empNo"
						value='${sessionScope.user.employeeId}' readonly="readonly" class="form-control"/>
		  	</div>
		  	<div class="form-group">
				 <label for="startDate">Start Date*:</label>
				 <input type="text" name="startDate" id="startDate" class="form-control" style="width:95%; display:inline" readonly="readonly"/>
						  <!-- <a href="#" onClick="setYears(2003, 2032); showCalender(this, 'startDate');">
							<img src="images/calender.png"> -->
					</a>(yyyy-mm-dd)
		  	</div>
		  	<div class="form-group">
				 <label for="endDate">Stop Date*:</label>
				 <input type="text" name="endDate" id="endDate"  class="form-control"  style="width:95%; display:inline" readonly="readonly"/>
				<!--  <a	href="#" onClick="setYears(2003, 2032); showCalender(this, 'endDate');">
							<img src="images/calender.png"> -->
					</a>(yyyy-mm-dd)
		  	</div>
		  	<div class="form-group">
				 <label for="showCount">Show Respondents:</label>
				 <input type="checkbox" name="showCount" id="showCount"/>
		  	</div>			  				  	
				<!--  <tr><td><b>Application type &nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;</b></td><td>
	        <select name="appType" onchange="displayMask();" id="maskType">
				<option value="Survey">Survey</option></select></td></tr> -->
				<%-- <tr id="removeUpload">
								<td>Upload File:</td>
								<td><html:file property="formFile" /></td>
							</tr> --%>
			<html:submit
					property="action" value="Initiate Reflection"
					styleClass="btn btn-primary" /> <input type="button"
				value="Cancel" class="btn btn-primary"
				onclick="javascript: window.location.href='./adminHome.do';">								
		</div>
	</div>		
	<!-- 	<p>
					<b>Please download
						template to upload users and roles: <input type="button"
						name="image" Value="Download Template" class="button"
						onclick="openFileOption()">
					</b>
				</p> -->
	<table id="calenderTable">
		<tbody id="calenderTableHead">
			<tr>
				<td colspan="4" align="center"><select
					onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
           this.selectedIndex, false));"
					id="selectMonth">
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
				</select></td>
				<td colspan="2" align="center"><select
					onChange="showCalenderBody(createCalender(this.value, 
			document.getElementById('selectMonth').selectedIndex, false));"
					id="selectYear">
				</select></td>
				<td align="center"><a href="#" onClick="closeCalender();"><font
						color="#003333" size="+1">X</font></a></td>
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
</html:form>

