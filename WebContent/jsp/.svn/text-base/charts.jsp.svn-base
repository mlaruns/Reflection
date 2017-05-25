<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/highchart/highcharts.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/highchart/exporting.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/highchart/custom-chart.js"></script>

    <script type="text/javascript">
      $(document).ready(function() {
  	 $("#chart1-container").hide();
    $("#compare").click(function() 
			{
        var contextPath = '<c:out value="${pageContext.request.contextPath}"/>';
      
        var empid=${sessionScope.empId};
         getRemoteDataDrawChart("./adminApplication.do?action=linechart1", createNewLineChart('chart1-container'),empid);
            
        });
        });
    </script>

 <div id="error" style="color:red;padding:10px;10px;10px;10px;"></div>
 <div id="chart1-container" style="min-width: 300px; max-width: 500px;  height: 300px; margin: 0 auto"></div>


 
   