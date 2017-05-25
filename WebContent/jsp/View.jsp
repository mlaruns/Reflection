<%@page import="com.ciber.beans.JohariWidowAdjectives"%>
<%@page import="com.ciber.dao.QuestionsDAOImpl"%>
<%@page import="java.util.*"%>
<%@page import="com.ciber.beans.Questions"%>
<%@page import="com.ciber.template.AppConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="./../WEB-INF/pager-taglib.tld" prefix="pg"%>

<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="com.ciber.beans.AnsweOptions"%>
<section class="main">
	<h1>View Attempted Answers</h1>
</section>
<div class="table-responsive clear_both">
	<table class="table table-striped">

				<%
					List<Questions> list = new ArrayList<Questions>();
					list = (List<Questions>) session.getAttribute("viewQuestions");
				%> 
				<%
				 	Iterator iterator = list.iterator();
				 	int totalSize = 0;
				 	int no = 1;
				 	while (iterator.hasNext()) 
				 	{
				 		int j = 65;
				 		Questions questions = (Questions) iterator.next();
 				%>
							<tr>
								<td id="questionid">
									<%=no + ". "%> <%=questions.getQuestion()%><br>
									<%="Ans: "%> <%=questions.getAnswer()%>
								</td>
							</tr>
				<%
						no++;
 					}
 				%>
 				
 				<%
 				    String viewJohAns = (String) session.getAttribute("viewJohAns"); 				    
				%> 
 				<tr>
					<td id="questionid">
						11. How do you describe your manager?<br>
						<%="Ans: "%> <%=viewJohAns%>
					</td>
				</tr>
	</table>
</div>

