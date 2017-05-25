<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<script type="text/javascript" src="./script/jquery.js"></script>


<%-- <tiles:insert page="/template.jsp" flush="true">
    <tiles:put name="title" value="Quiz Application !!!" />
    <tiles:put name="header" value="/header_lgn.jsp" />
    <tiles:put name="body" value="/login.jsp" />
    <tiles:put name="footer" value="/footer.jsp" />
</tiles:insert> --%>


<%
   // New location to be redirected
  Object obj= session.getAttribute("sso");
if(request.isRequestedSessionIdValid()){
	session.invalidate();
}
if(obj!=null){
   String site = new String("https://ciberapps.ciberindia.in/GIDC/Account/LogOut.aspx");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
  
}else{
		response.sendRedirect("./../LoginPage.do");
}

%>
