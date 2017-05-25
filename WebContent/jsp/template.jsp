<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html> 
<html lang="en"> 
<head> 
	<meta charset="utf-8" /> 
	<meta name="author" content="Script Tutorials" /> 
	<meta name="description" content="Responsive Websites Using BootStrap - demo page"> 
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"> 
	<title><tiles:getAsString name="title" ignore="true" /></title> 
	<!-- css stylesheets --> 
	<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/jquery/css/jqueryui-theme/ciber-theme/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" /> 
</head> 
<body> 
  <tiles:insert attribute="header" ignore="true" />
  
<div class="container main-content-wrapper" id="main_content">
    <div class="row header-banner" >
		    <h1><a href="#">&nbsp;</a></h1>
    </div>
      <div class="row">
			<tiles:insert attribute="body" />
      </div>
  </div>
	<tiles:insert attribute="footer" />
    </body>
</html>
