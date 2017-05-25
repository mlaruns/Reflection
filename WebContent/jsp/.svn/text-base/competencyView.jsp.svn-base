<%@page import="com.ciber.beans.ReportBean"%>
<%@page import="com.ciber.beans.ExcelBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ page errorPage="./jsp/sessionInvalidate.jsp" %>
<section class="main">
	<h1>View Reports</h1>
</section>

<div class="row margin-left-right-0">		
	<logic:notEmpty name="competencyView" scope="session">
			<logic:present name="competencyView" scope="session" property="empLevel">
			<br><br><div style="font-weight: bold;">Over All Report for: ${sessionScope.competencyView.empLevel} 's</div>
			</logic:present>
			<logic:notPresent name="competencyView" scope="session" property="empLevel">
			<div style="font-weight: bold;">Over All Report </div>
			</logic:notPresent>
			<br>
			<div style="color:blue"> <b>Total Number of Reflections: ${sessionScope.competencyView.totalReflections} </b></div>
			<div style="color:blue"> <b>Total Number of Respondents: ${sessionScope.competencyView.noOfRespondents} 
			(${sessionScope.competencyView.noOfNotRespondents}%)</b></div>
			
		
	<div class="table-responsive clear_both">	
		<table class="table table-striped">
				<tr>
					<th>Competency</th>
					<th>Never</th>
					<th>Sometimes</th>
					<th>Often</th>
					<th>Always</th>
					<th>Rating*</th>
				</tr>
				<logic:iterate id="bean"
					collection="${sessionScope.competencyView.ansbean}" name="bean" indexId="id">
					<tr>
					    <td>${bean.competency}</td>
						<td>${bean.never}</td>
						<td>${bean.someTimes}</td>
						<td>${bean.often}</td>
						<td>${bean.always}</td>
						<td style="width: 100px">
						  <div style="width: 100%; float: left; height: 30px">
						  <logic:equal name ="bean" property="questionPriority" value="ALWAYSGREEN">
						    <!-- green --><span style="float: left; background-color: #99FF99; height: 30px; width:${bean.alwaysPercentage}%" title="Always : ${bean.alwaysPercentage}%"> &nbsp;</span>
						  </logic:equal>
						  <logic:equal name ="bean" property="questionPriority" value="NEVERGREEN">
						         <!-- green --><span style="float: left; background-color: #99FF99; height: 30px; width: ${bean.neverPercentage}%" title="Never: ${bean.neverPercentage}%">&nbsp;</span>
						    </logic:equal>	
							  	<!-- yellow --><span style=" float: left; background-color: #FFFF33; height: 30px; width: ${bean.someTimesPercentage}%" title ="SomeTimes: ${bean.someTimesPercentage}%">&nbsp;</span>
							  	<span style="float: left; background-color: blue; height: 30px; width: ${bean.oftenPercentage}%" title="Often: ${bean.oftenPercentage}%">&nbsp;</span>
						    
						     <logic:notEqual name ="bean" property="questionPriority" value="ALWAYSGREEN">
						         <!-- red --><span style="float: left; background-color: #FF0000; height: 30px; width:${bean.alwaysPercentage}%" title="Always : ${bean.alwaysPercentage}%"> &nbsp;</span>
						     </logic:notEqual>	
						     <logic:notEqual name ="bean" property="questionPriority" value="NEVERGREEN">
						         <!-- red --><span style="float: left; background-color: #FF0000; height: 30px; width: ${bean.neverPercentage}%" title="Never: ${bean.neverPercentage}%">&nbsp;</span>
						  </logic:notEqual>							  
							  
						  </div>
                               </td>

					</tr>
				</logic:iterate>
			</table>
		</div>
	
		<div style="margin-top:30px;float:right;">
			<a href=overAllReport.do class="btn btn-default" >Download</a>
		</div>
			<div id="message" style="color: blue; padding: 5px;">
* Red color indicates negetive feedback and green positive. For more details point your mouse on each color.
</div>
	</logic:notEmpty>
	<logic:empty name="competencyView" scope="session">
		<div align="center"  style="color: red;font-size:12px ">No feedbacks received</div>
	</logic:empty>

</div>
				
			
	<script type="text/javascript">
	
	$(document).tooltip();
			$(document).ready(function(){
				
				 $( "#accordion" ).accordion({
				      collapsible: true
				    });
				 $( "#accordion" ).accordion({
				      active: false
				    });
				
				
			});
		</script>	
