<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>    
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
      <div class="col-md-6">
      		<div class="row cspeak">
      			<h1><a href="#">&nbsp;</a></h1>
		    	<h2>&nbsp;</h2>
      		</div>
      		<div class="row">
      			<h3>What is Reflection</h3>
      			<p>Reflection is Ciber's In House Survey Tool.<br> Through Reflection, we encourage employee's participation to share their feedback and suggestions with us.</p>
      		</div>
        </div>	
        <div class="col-md-6">
	   	<div class="well admin-login">
		  <html:form styleId="loginForm" action="/LoginSSO" method="post">
		      <div class="form-group">
			  <label for="username" class="control-label">Username</label>
			  <input type="text" class="form-control" id="userName" name="userName" title="Please enter you username">
			  <span class="help-block"></span>
		      </div>
		      <div class="form-group">
			  <label for="password" class="control-label">Password</label>
			  <input type="password" class="form-control" id="password" name="password" title="Please enter your password">
			  <span class="help-block"></span>
		      </div>
		      
		      <div id="loginErrorMsg" class="alert alert-error hide"><html:errors/>
		          <logic:messagesPresent message="true">
 	 				<html:messages id="msg" message="true">
			   			 <div class="failure">
			      				<bean:write name="msg"/>
			    		</div><br/>
  					</html:messages>
				</logic:messagesPresent>
      			<logic:present scope="request" name="failure" />
      			</div>
		      <html:submit value="Login" styleClass="btn btn-primary btn-block" />
		  </html:form>
         </div>
         </div>
