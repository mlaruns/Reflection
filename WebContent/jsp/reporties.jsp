<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page errorPage="./jsp/sessionInvalidate.jsp"%>
<section class="main">
	<h1>Reportees</h1>
</section>

<div class="table-responsive clear_both">
<display:table id="data" name="sessionScope.reporties" requestURI="#"
	pagesize="10" decorator="com.ciber.common.action.AdminAppDecorator"
	style="width:100%;border-collapse:collapse;" class="table table-striped">
	<display:setProperty name="paging.banner.item_name" value="" />
	<display:setProperty name="paging.banner.items_name" value="" />
	<display:setProperty name="paging.banner.one_item_found" value="" />
	<display:setProperty name="paging.banner.onepage" value="" />
	<display:setProperty name="paging.banner.all_items_found" value="" />

	<display:setProperty name="basic.msg.empty_list"
		value="Currently No Reporties found" />
	<display:column property="employeeId" title="Employee ID"
		sortable="true" group="1" />
	<display:column property="ename" title="Employee Name" sortable="true" />
	<display:column property="supervisorName"
		title="Project Manager Name" sortable="true" />
	<display:column property="feedbackdownload" title="Feed Back"
		sortable="true" />
	<display:column property="team" title="Team" sortable="true" />
</display:table>
</div>
