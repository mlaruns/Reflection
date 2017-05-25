<%@page import="com.ciber.beans.ReportBean"%>
<%@page import="com.ciber.beans.ExcelBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page errorPage="./jsp/sessionInvalidate.jsp"%>
<script src="<%=request.getContextPath()%>/script/autocompleter.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    var status=${sessionScope.viewSurvey.surveyStatus};
    if(status==2){
    	$("input").prop('disabled', true);
    	$('#message').empty().prepend("Note:You have provided your improvements");
    }else if(status==1){
    	$("input").prop('disabled', false);
    	$('#message').empty().prepend("Note:Select maximum 3 comptencies below using checkbox to improve on your feedback");
    }
});
</script>
<section class="main">
	<h1>View Reports</h1>
</section>


<div class="table-responsive clear_both">
<logic:notEmpty name="reporteeInfo" scope="session">
<div id="accordion">
			<h3>Show invitees</h3>
			<div class="textarea" style="background:none; text-align:justify; color: #666;">
				<logic:iterate id="reporteeInfo"
					collection="${sessionScope.reporteeInfo}">
					<div class="accordianData">${reporteeInfo.empName}</div>
				</logic:iterate>
			</div>
		</div>
		</logic:notEmpty>
	<logic:notEmpty name="viewSurvey" scope="session">
		

		<div id="error" style="color: red; padding: 5px;"></div>
		<div id="message" style="color: blue; padding: 5px;"></div>
		<form action="adminApplication.do?action=review" name="review">
			<input type="hidden" name="size" id="size"
				value="${sessionScope.ansSize}" /> <input type="hidden"
				name="surveyId" id="surveyId"
				value="${sessionScope.viewSurvey.surveyId}" />
			<div style="padding: 5px; 5 px; 5 px; 5 px; font-weight: bold;">Name:
				${sessionScope.viewSurvey.surveyName}</div>
				
			<div style="padding: 5px; 5 px; 5 px; 5 px; font-weight: bold;">Total Number of Respondents:
				${sessionScope.viewSurvey.noOfRespondents}(${sessionScope.viewSurvey.noOfNotRespondents}%)</div>
			<table class="table table-striped">
				<tr>

					<th>Competency</th>
					<th>Sub Competency</th>
					<th>Questions</th>
					<!--<th>Never</th>
							<th>Sometimes</th>
							<th>Often</th>
							<th>Always</th>-->
					<th>Rating*</th>
					<th></th>
					<th>Improvements</th>
					<th>&nbsp;</th>
				</tr>
				<logic:iterate id="bean"
					collection="${sessionScope.viewSurvey.ansbean}" name="bean"
					indexId="id">

					<input type="hidden" name="comptency${id}" id="comptency${id}"
						value="${bean.competency}">
					<input type="hidden" name="subCompetency${id}"
						id="subCompetency${id}" value="${bean.subCompetency}">
					<input type="hidden" name="questionNo${id}" id="questionNo${id}"
						value="${bean.questionno}">
					<logic:notEqual name="bean" property="questionPriority"
						value="ALWAYSGREEN">
						<input type="hidden" name="rating${id}" id="rating${id}"
							value="${bean.neverPercentage}">
					</logic:notEqual>
					<logic:notEqual name="bean" property="questionPriority"
						value="NEVERGREEN">
						<input type="hidden" name="rating${id}" id="rating${id}"
							value="${bean.alwaysPercentage}">
					</logic:notEqual>
					<tr>
						<td>${bean.competency}</td>
						<td>${bean.subCompetency}</td>
						<td>${bean.questionName}</td>
						<%-- <td>${bean.never}</td>
								<td>${bean.someTimes}</td>
								<td>${bean.often}</td>
								<td>${bean.always}</td>--%>
								
						<td style="width: 100px">
							<div style="width: 100%; float: left; height: 30px">
								<logic:equal name="bean" property="questionPriority"
									value="ALWAYSGREEN">
									<!-- green -->
									<span
										style="float: left; background-color: #99FF99; height: 30px; width:${bean.alwaysPercentage}%"
										title="Always : ${bean.alwaysPercentage}%"> &nbsp;</span>
								</logic:equal>
								<logic:equal name="bean" property="questionPriority"
									value="NEVERGREEN">
									<!-- green -->
									<span
										style="float: left; background-color: #99FF99; height: 30px; width: ${bean.neverPercentage}%"
										title="Never: ${bean.neverPercentage}%">&nbsp;</span>
								</logic:equal>
								<!-- yellow -->
								<span
									style=" float: left; background-color: #FFFF33; height: 30px; width: ${bean.someTimesPercentage}%"
									title="SomeTimes: ${bean.someTimesPercentage}%">&nbsp;</span>
								<!-- blue -->
								<span
									style="float: left; background-color:#66B2FF; height: 30px; width: ${bean.oftenPercentage}%"
									title="Often: ${bean.oftenPercentage}%">&nbsp;</span>

								<logic:notEqual name="bean" property="questionPriority"
									value="ALWAYSGREEN">
									<!-- red -->
									<span
										style="float: left; background-color: #FF6666; height: 30px; width:${bean.alwaysPercentage}%"
										title="Always : ${bean.alwaysPercentage}%"> &nbsp;</span>
								</logic:notEqual>
								<logic:notEqual name="bean" property="questionPriority"
									value="NEVERGREEN">
									<!-- red -->
									<span
										style="float: left; background-color: #FF6666; height: 30px; width: ${bean.neverPercentage}%"
										title="Never: ${bean.neverPercentage}%">&nbsp;</span>
								</logic:notEqual>

							</div>
						</td>

					<td><c:if test="${bean.checked !=null }">
								<input type="checkbox" name="review${id}" checked="checked"
									id="review${id}" value="${bean.competency}" disabled="disabled" onclick= "onImprovementCheckBoxChange(this.id,'${id}')"/>
							</c:if> <c:if test="${bean.checked == null }">
								<input type="checkbox" name="review${id}" id="review${id}"
									value="${bean.competency}" onclick= "onImprovementCheckBoxChange(this.id,'${id}')"/>
							</c:if></td>
								<td style="width: 100px; hight: 100px">
								 <input type="text"	name="comments${id}" value="${bean.comments}" id="comments${id}" readonly>
							</td>
							<td>
							  
							
						<select id="ImprovementSelect${id}" value ="${bean.improvementOption}" disabled="disabled">
							    <logic:iterate id="Improvementbean"
					                   collection="${sessionScope.ImprovementOptions}" name="Improvementbean">
					                    					      
							          <option value="${Improvementbean.optionID}">${Improvementbean.optionName}</option>
						     </logic:iterate>	 						  
							 </select>
							
							</td>

					</tr>
				</logic:iterate>
			</table>
			<div style="margin-top: 30px; float: left; padding-left: 20px;">
				<a
					href=overAllReport.do?appId=${sessionScope.viewSurvey.surveyId}&appName=${sessionScope.viewSurvey.surveyName}
					class="btn btn-default">Download</a>
			</div>
			<div style="margin-top: 30px; float: right; padding-right: 30px;">
				<input type="button" value="submit" id="submit"
					class="btn btn-primary">
			</div>
			
		</form>
			<div id="message" style="color: blue; padding: 5px;">
* Red color indicates negetive feedback and green positive. For more details point your mouse on each color.
</div>
	</logic:notEmpty>
	<logic:empty name="viewSurvey" scope="session">
		<div align="center" style="color: red; font-size: 12px">No
			feedbacks received</div>
	</logic:empty>

</div>
<script type="text/javascript">
<c:forEach items="${sessionScope.viewSurvey.ansbean}" var="ansBeans" varStatus="loop">
	var tempIndex = '${loop.index}';
	//$("#ImprovementSelect"+tempIndex).prop('selectedIndex', '${ansBeans.improvementOption}');
	$("#ImprovementSelect"+tempIndex).val('${ansBeans.improvementOption}');
</c:forEach>

$(document).tooltip();
			$(document).ready(function(){
				 $( "#accordion" ).accordion({
				      collapsible: true
				    });
				 $( "#accordion" ).accordion({
				      active: false
				    });
			});

			function onImprovementCheckBoxChange(selectID, count){
				
				//alert($("#"+selectID).attr('id'));
				//alert($("#"+selectID).val());
				var selectedCheckBoxs = [];
				if($("#"+selectID).is(':checked')){
				$('input:checked').each(function() {
					$("#ImprovementSelect"+count).removeAttr('disabled');					
					$("#comments"+count).prop("readonly",false);
					//alert($("#"+selectID).val());
					//alert($(this).attr('id'));
					if($("#"+selectID).attr('id') != $(this).attr('id') ){
						if($("#"+selectID).val() == $(this).val()){
							alert("Duplicate Competency Selected");
							$('#'+selectID).attr('checked', false);
							$("#ImprovementSelect"+count).prop('selectedIndex', 0);
							$("#ImprovementSelect"+count).prop('disabled', 'disabled');
							$("#comments"+count).val("");
							$("#comments"+count).prop("readonly",true);		
							return false;
						}
					}
						selectedCheckBoxs.push($(this).attr('id'));
				});
				
				}else{
					$("#ImprovementSelect"+count).prop('selectedIndex', 0);
					$("#ImprovementSelect"+count).prop('disabled', 'disabled');
					$("#comments"+count).val("");
					$("#comments"+count).prop("readonly",true);					
				}
				if(selectedCheckBoxs.length > 3){
					alert("Max three Competency");
					$('#'+selectID).attr('checked', false);
					$("#ImprovementSelect"+count).prop('selectedIndex', 0);
					$("#ImprovementSelect"+count).prop('disabled', 'disabled');
					$("#comments"+count).val("");
					$("#comments"+count).prop("readonly",true);
					
				}				
			}
			
</script>
