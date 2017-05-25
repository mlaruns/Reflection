<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page errorPage="./jsp/sessionInvalidate.jsp"%>
<section class="main">
	<h1>View Reflections</h1>
</section>

<div class="table-responsive clear_both">
<display:table id="data" name="sessionScope.ViewFeedBack" requestURI="#"
	pagesize="10" decorator="com.ciber.common.action.AdminAppDecorator" 
	class="table table-striped">
	<display:setProperty name="paging.banner.item_name" value="" />
	<display:setProperty name="paging.banner.all_items_found" value="" />
	<display:setProperty name="paging.banner.one_item_found" value="" />
	<display:setProperty name="paging.banner.onepage" value="" />
	<display:setProperty name="basic.msg.empty_list"
		value="No reflection created" />
	<display:column property="appId" title="App ID" sortable="true" />
	<display:column property="appName" title="Reflection Name"
		sortable="true" />
	<display:column property="completedFlag" title="Status" sortable="true" />
	<display:column property="startDate" title="Created Date"
		sortable="true" />
	<display:column property="endDate" title="End Date" sortable="true" />
	<display:column property="downloadReports" title="Download"
		sortable="true" />
	<display:column property="view" title="view" sortable="true" />
</display:table>
</div>

<logic:notEmpty name="ViewFeedBack" scope="session">
	<div style="padding-left: 10px;">
		<input type="button" value="Compare Last two Reflections" id="compare"
			class="btn btn-primary">
	</div>
	<jsp:include page="/jsp/charts.jsp" />
</logic:notEmpty>

