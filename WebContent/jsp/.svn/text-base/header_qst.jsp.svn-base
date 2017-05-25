<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page errorPage="sessionInvalidate.jsp" %>
<%@page import="com.ciber.beans.User"%>

<!-- <script src="<%=request.getContextPath()%>/jquery/js/jquery-1.8.3.js" type="text/javascript"></script>-->
<script src="<%=request.getContextPath()%>/js/jquery/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/js/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/jquery/js/modernizr-2.6.2.min.js" type="text/javascript"></script>
	<!-- BODY PAGE CONTENT --> 
	<!-- add javascripts --> 
    <!-- fixed navigation bar -->
  <div class="container padding-left-right-0">
    <nav class="navbar navbar-default reflection_nav">
      <div class="container header_details">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#b-menu-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
	      <a class="navbar-brand" href="javascript:void(0)">
	      	Ciber
	        <!-- <img alt="Brand" src="images/ciber_logo.png">     --> 
	      </a>     
        </div>
        <div class="collapse navbar-collapse" id="b-menu-1">
          <ul class="right_nav"> 
           	<li>Welcome <bean:write name="user" scope="session" property="ename"></bean:write>!</li>
           	<li><a href="./jsp/sessionInvalidate.jsp">Logout</a></li>
          </ul>
        
          <ul class="nav navbar-nav navbar-right" id="main_nav">
          
          	<c:choose>
			     <c:when test="${sessionScope.user.isReporties == 'true' || sessionScope.user.role == 'a'}">
		      		<li><a href="adminHome.do" rel="main_nav_a">Home</a></li>
			     </c:when>
			     <c:otherwise>
		      		<li><a href="navigation.do" rel="main_nav_a">Home</a></li>
			     </c:otherwise>
			     
			</c:choose>
			<logic:equal name="user" property="role" value="a">
		        	<li><a href="viewRecent.do?action=viewRecent">View Reports</a></li>
		        </logic:equal>
          	<logic:equal name="user" property="isReporties" value="true" >
               	<li><a href="adminApplication.do?action=veiwReporties" rel="main_nav_a">Reportees</a></li>
             </logic:equal>
            <li><a href="adminApplication.do?action=feedBack" rel="main_nav_a">My Reflection</a></li>
            
              <c:if test="${sessionScope.sso != null }">
               	<li><a href="https://ciberapps.ciberindia.in/GIDC/Welcome/Welcome.aspx?${sessionScope.WelcomeURL}" rel="main_nav_a">Portal</a></li>
               </c:if>
          </ul>
          
        </div> <!-- /.nav-collapse -->
      </div> <!-- /.container -->
    </nav> <!-- /.navbar -->
  </div>
