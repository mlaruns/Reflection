<%@page import="com.ciber.beans.JohariWidowAdjectives"%>
<%@page import="com.ciber.dao.QuestionsDAOImpl"%>
<%@page import="java.util.*"%>
<%@page import="com.ciber.beans.Questions"%>
<%@page import="com.ciber.template.AppConstants"%>
<%@ page errorPage="/jsp/sessionInvalidate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="./../WEB-INF/pager-taglib.tld" prefix="pg"%>

<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="com.ciber.beans.AnsweOptions"%>
<style>
.asterik{
  color: #e32;
 
}

</style>


<script type="text/javascript">
	// Creating the Array to Store the Radio Button Values
	var valArr = new Array();
	var map = new Object();
	window.history.forward();
	var johariWidowAdjectivesSize;
	
	function noBack() 
	{ 
		window.history.forward();
	} 
		var isCheck=false;
		
	function clickCheck(val){
	
	}
	// First Page Data is Saved here
	function save(pageNumber){
		
		var queryString="";
	   
	    var radio = $("input:radio");
	    var size = $('#sizeId').val();
	    for(var i=1;i<=size;i++){
		   if ($('input[id=myRadio_'+i+']:checked').length==0 ) {  
			  alert("Please answer all the questions");
			 return false;
		   }  
		
	   } 
	    
	    for(var i = 0; i < radio.length; i++){
		 if(radio[i].checked){
		 var temp=radio[i].name+'-'+radio[i].value;
	     //valArr.push(temp);
	     queryString=queryString+radio[i].name+"="+radio[i].value+"&";
		 }
	 }
	    
	    var johariWidowAdjectiveSelected= '';
	    var johariSelectedCount= 0;
	    for(var j=0; j<johariWidowAdjectivesSize; j++){
	        if(document.getElementById('JohariCheckBox'+j).checked){	
	        	johariSelectedCount++;
		    	if(johariWidowAdjectiveSelected ==''){
		    		johariWidowAdjectiveSelected +=document.getElementById('JohariCheckBox'+j).value;
		    	}else{
		    		johariWidowAdjectiveSelected += ','+document.getElementById('JohariCheckBox'+j).value;
		    	}
	        }
	    }
	    if(johariSelectedCount != 4){
	    	alert("Please select only four johari question options.");
	    	return false;
	    }
	    
	    queryString += 'jwal='+johariWidowAdjectiveSelected;
	     $.ajax({
	        url: "./question.do?"+queryString,
	       				dataType : "json",
						success : function(data) {
								response(data);
						}
			});
	    if(pageNumber==0){
	    	confirm1();
	        }
	}
	//function to restrict number of charecters in the text area
	function limitText(limitField, limitNum) {
	    if (limitField.value.length > limitNum) {
	        limitField.value = limitField.value.substring(0, limitNum);
	    } 
	}
	
	function updateArray(val){
		valArr.push(val);
		sessionStorage.setItem("valArr",valArr);
	}
	
	function onNext(pageNumber){
		map = JSON.parse(sessionStorage.getItem("map"));  
		var radio2 = document.getElementsByTagName("input");
	    for(var j = 0; j < radio2.length; j++){
		 if(radio2[j].checked){
		// var temp2 = group2[j].name+'-'+group2[j].value;
	     //valArr.push(temp2);
	       map[radio2[j].name]=radio2[j].value;
		 }
		}
		sessionStorage.setItem("map",JSON.stringify(map));
		if(pageNumber==0){
		submit();
	    }
	}
	
	function submit(){
		window.location.href='./check.do'; 
	}
	
	function prv(qno){
		qno=qno-2;
		window.location.href='index'+3+'.jsp?'+'qno='+qno+"&pr=y";
	}
	
	function confirm1()
	{
		var r=confirm("Are you sure you want to Submit?");
		if (r==true)
		{
			return window.location.href='./check.do';
		}
		else
		{
			return;
		}
	}

</script>

<section class="main">
	<h1>Reflections</h1>
</section>
<pg:pager url="./question.do" maxIndexPages="3" maxPageItems="25">
<div class="table-responsive clear_both">
	<table class="table table-striped">
			<%
				QuestionsDAOImpl dao= new QuestionsDAOImpl();
				Map map = dao.sortHashMap((Map) session.getAttribute("QuestionsMap"));
				List list=new ArrayList(map.values());
				int size = list.size();
			%> 
			<input type="hidden" id ="sizeId" value = "<%=size %>" />
		<%
 		Iterator iterator = list.iterator();
 		int totalSize = 0;
 			int no = 1;
 			int k = 0;
 			int r = 0;
 			int j=0;
			String str = "";
 			while (iterator.hasNext()) {
 				Questions questions = (Questions) iterator.next();
 				
		 %> <pg:item>
		 	<tr>
				<td>
				<div class="td_bgcolor">
				<%=no%> <%=questions.getQuestion()%>
				<span class="asterik">*</span>
				<img src="<%=request.getContextPath()%>/images/Sign-Info-icon.png" width="15" height="15" id="infotooltip" title="<%=questions.getDescription()%>"/>
				</div>
				<div style=" padding-left: 5px; padding-top: 5px;">
				<logic:iterate id="element"
						collection="<%= questions.getOption() %>">
						<logic:equal name="element" property="questionType" value="option"> 
						<logic:equal name="element" property="options" value="${pageScope.questions.answer}"> 
							<input id="myRadio_<%=no%>" type="radio" class="radioBtnClass"  onclick="clickCheck(this)"
								name="<%=questions.getQuesID()%>" value="${pageScope.element.options}"  />
							<bean:write name="element" property="options"  />
						</logic:equal>
						<logic:notEqual name="element" property="options" value="${ pageScope.questions.answer}"> 
							<input id="myRadio_<%=no%>" type="radio" class="radioBtnClass"   onclick="clickCheck(this)"
								name="<%=questions.getQuesID()%>" value="${pageScope.element.options}"/>
							<bean:write name="element" property="options" />
						</logic:notEqual>
						</logic:equal>
						<logic:notEqual name="element" property="questionType" value="option"> 
							<bean:write name="element" property="options" />
								<textarea  id="<%=questions.getQuesID()%>" name="<%=questions.getQuesID()%>" rows="0" cols="110%" onKeyDown="limitText(this,254);" onKeyUp="limitText(this,254);">${ pageScope.questions.answer}</textarea>
						</logic:notEqual>
							<%
							j++;
						%>
					</logic:iterate>
				
				</div>
			</td>
		</tr>
				</pg:item> <%
 				r++;
		     	k++;
 				no++;
 				
 			}
 %> <%
 	//}
 %>
 
          
<tr>
				<td>
				<div class="td_bgcolor" style="float:left;width: 1100px">
				<div style="float:left;width: 100%">11. How do you describe your manager?</div>
				<div style="width: 100%;float: left;padding: 3px">
				<%
                List<JohariWidowAdjectives>  adjectives= (List) session.getAttribute("JohariWidowList");
				for(int i=0; i<adjectives.size(); i++){
					JohariWidowAdjectives widowAdjectives = adjectives.get(i);
				
			%>  
				 <div style="width:150px;float: left;"> 
				    <div style="width:30px;float: left;">
				       <input type="checkbox" class="form-control" id="JohariCheckBox<%=i%>" value="<%=widowAdjectives.getOptionId()%>" style="width: 20px"/>
				    </div>
				 	<div style="float: left;padding-top: 10px"><%= widowAdjectives.getOptionName() %></div>
				</div>
				<% 
				if((i+1) % 5 == 0){
					
					%>
				
				  </div>
				  <div style="width: 100%;float: left;padding: 3px">
				  <%} %>
				  <%if(i+11 == adjectives.size()){ %>
				  	</div>
				  <%} %>
				<%} %>
				</div>
	</table>
	</div>
	<table>
		<tr>
			<td>&nbsp;</td>
			
		</tr>
		<tr>
			<td>
			<%if(k >= 26) {%>
			<pg:index>
			
				<pg:prev>
					<a href="<%=pageUrl%>" onclick="save(<%=pageNumber%>)">[<< Prev]</a>
				</pg:prev>
				<pg:pages>
					<a href="<%=pageUrl%>" onclick="save(<%=pageNumber%>)"><%=pageNumber%></a>
				</pg:pages>
				<pg:next ifnull="true">
					<%
						if (pageUrl != null) {
					%>
					
					<a href="<%=pageUrl%>" id="nextId" onclick="save(<%=pageNumber%>)">[Next >>]</a>
					
					<%
						} else {
					%>
					<input type="submit" id="subBtn" class="btn btn-primary" value="Submit" style="float:right;" onclick="save(0)"//>
						
					<%
						}
					%>
				</pg:next>
			</pg:index>
			
			<%}else{%>
			<input type="submit" id="subBtn" class="btn btn-primary" value="Submit" onclick="save(0)" />
			<%} %>
			</td>
		</tr>
	</table>
</pg:pager>
<script type="text/javascript" >
	$(document).ready(function(){
			noBack();
			$("img").tooltip();
			
			<% List<JohariWidowAdjectives>  adjectivesList= (List) session.getAttribute("JohariWidowList"); %>  
			johariWidowAdjectivesSize = <%=adjectivesList.size()%>;
			
	});

	$(document).on("pageshow",function(){
		if (event.persisted) noBack();
	});
</script>
