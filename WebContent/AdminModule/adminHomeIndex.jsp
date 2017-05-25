<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page errorPage="/jsp/sessionInvalidate.jsp" %>
<tiles:insert page="/template.jsp" flush="true">

    <tiles:put name="title" value="" />
    <tiles:put name="header" value="/header_qst.jsp" />
    <tiles:put name="body" value="adminHome.jsp" />
    <tiles:put name="footer" value="/footer.jsp" />
    
</tiles:insert>