<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/jsp/sessionInvalidate.jsp"%>
<script src="<%=request.getContextPath()%>/script/autocompleter.js"></script>

<section class="main">
	<h1>Improvement Options</h1>
</section>

<div class="col-md-6">
		<div class="panel panel-primary form-panel-in-col">
			<div class="panel-heading">Improvement Options</div>
			<logic:present name="SuccessFlag" scope="request">			
			<logic:equal  name="SuccessFlag" value="true" scope="request">
			  <Div style="color: blue; padding: 5px;">you have created improvement option successfully</Div>
			</logic:equal>
			<logic:equal  name="SuccessFlag" value="false" scope="request">
			    <Div style="color: red; padding: 5px;">Unexpected error, Please contact system admin</Div>
			</logic:equal>
			</logic:present>
			<div class="panel-body">
			   <div class="form-group">
						<div id="managerNameInfo"></div>
					</div>
			
				<html:form action="adminApplication.do?action=addImprovementOption"
					 method="post" styleId="ImprovementOptionForm">
						
					<div class="form-group">Name:   
						 <input
							type="text" id="improvementOptionName" name="improvementOptionName" style="width:350px;"/>
							 
						 
					</div>
					
					<div class="form-group">Description: 
						 <input
							type="text" id="improvementOptionDescription" name="improvementOptionDescription" style="width:350px" />
							 
						 
					</div>
				<div class="form-group">
						<div id="managerNameInfo"> 
						<div  style="float: left;"> 
						   <div style="float:left;width: 30px">
						      <input type="checkbox" id="improvementActive" name="improvementActive" class="form-control"  style="width: 20px"/>
							</div>
							 <div style="float:left;padding-top: 10px;;padding-right: 20px">
							    Active?
							 </div>
						</div>	
							</div>
					</div>
										
					<div class="form-group">
						<div id="managerNameInfo"> 
						   <input type="button" value="Add" class="btn btn-primary"
						onclick="addImprovementOption()" />
					<input type="button" value="Cancel" class="btn btn-primary"
						onclick="javascript: window.location.href='./adminHome.do';">
						</div>
					</div>
					
					
				</html:form>
		</div>
	</div>
	</div>
	<script>
	    function addImprovementOption(){
	    
	    	if($("#improvementOption").val() == '' || $("#improvementOptionDescription").val() == ''){
	    		return false;
	    	}else{
	    		$("#ImprovementOptionForm").submit();
	    	}
	    }
	</script>
	
	