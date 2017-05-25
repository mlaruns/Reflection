<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/sessionInvalidate.jsp" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<section class="main">
	<h1>Reflections</h1>
</section>

	<div class="row inner-nav sec_nav">
		<nav class="navbar navbar-default patient_history_nav">
		  <div class="container">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#patient_history_nav" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="patient_history_nav">
		      <ul class="nav navbar-nav">
		        	<li><a href="createNewApp.do">Initiate Reflection</a></li>
		        <logic:equal name="user" property="role" value="a">
					<li class="dropdown"><a href="uploadexcel.do">Upload Questions</a></li>
					<li class="dropdown"><a href="uploadDataManager.do">Upload Peers Information</a></li>
					<li class="dropdown"><a href="managerInof.do">Individual Manager Update</a></li>
					<li><html:link action="ImprovementOptions.do">Improvement Options</html:link></li>
		       	</logic:equal> 
			      <li><html:link action="navigation.do">Provide feedback</html:link></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container -->
		</nav>
	</div>
	
	<div class="table-responsive clear_both">	
		<c:choose>
			<c:when test="${sessionScope.user.role == 'a'}">	
				<display:table id="data" name="sessionScope.currentApp"
					requestURI="#" pagesize="4" decorator="com.ciber.common.action.AdminAppDecorator" class="table table-striped">
					<display:setProperty name="paging.banner.item_name" value="" />
					<display:setProperty name="paging.banner.items_name" value="" />
					<display:setProperty name="paging.banner.one_item_found" value="" />
					<display:setProperty name="paging.banner.onepage" value="" />
					<display:setProperty name="basic.msg.empty_list" value="No reflection found" />
					<display:column property="appName" title="Reflection Name" sortable="true" />
					<display:column property="appId" title="App Id"/>
					<display:column property="stop" title="Stop"/>
					<display:column property="respondedCount" title="Responded Count"/>
					<display:column property="notRespondedCount" title="Not Responded Count"/>
				</display:table>
			</c:when>
			<c:otherwise>
				<display:table id="data" name="sessionScope.currentApp"
					requestURI="#" pagesize="4"
					decorator="com.ciber.common.action.AdminAppDecorator"
					style="width:100%;border-collapse:collapse;" class="tablecont">
					<display:setProperty name="paging.banner.item_name" value="" />
					<display:setProperty name="paging.banner.items_name" value="" />
					<display:setProperty name="paging.banner.one_item_found" value="" />
					<display:setProperty name="paging.banner.onepage" value="" />
					<display:setProperty name="basic.msg.empty_list" value="No reflection found" />
					<display:column property="appName" title="Reflection Name" sortable="true"  style="width:200px;" />
					<display:column property="appId" title="App Id" />
					<display:column property="stop" title="Stop" />
					<c:if test="${sessionScope.showCount == 'true'}">
						<display:column property="respondedCount" title="Responded Count"/>
					<display:column property="notRespondedCount" title="Not Responded Count"/>
					</c:if>
				</display:table>
			</c:otherwise>
		</c:choose>
	</div>				     
