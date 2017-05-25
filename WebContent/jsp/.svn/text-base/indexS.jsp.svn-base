<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<meta http-equiv="X-UA-Compatible" content="IE=8">
<script type="text/javascript" src="./script/jquery.js"></script>
<script type = "text/javascript" >
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
 
<tiles:insert page="/jsp/template.jsp" flush="true">
    <tiles:put name="title" value="Quiz Application !!!" />
    <tiles:put name="header" value="/jsp/header_lgn.jsp" />
    <tiles:put name="body" value="/jsp/login.jsp" />
    <tiles:put name="footer" value="/jsp/footer.jsp" />
</tiles:insert> 