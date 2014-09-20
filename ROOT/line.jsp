<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%> 
<%@page import="testjdbc.DbBean" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<% 
         DbBean dd = new DbBean();
		String labels ="[";
		String data	  ="[";
 		String sql =" select * from caldata ";
 		List ll =  dd.SelectRS("select * from CalValue");
		for(int i=0;i<ll.size();i++){
			Map map = (Map)ll.get(i); 
			
			labels +=	map.get("Frequency").toString();
			data   +=   map.get("Loss").toString();
			if(i<ll.size()-1){
				labels += ",";
				data += ",";
			}
			
		}
		labels += "]";
		data += "]";
   
%> 
<!doctype html>
<html>
	<head>
		<title>Line Chart</title>
		<script src="js/Chart.js"></script>
	</head>
	<body>
		<div style="width:30%">
			<div>
				<canvas id="canvas" height="450" width="600"></canvas>
			</div>
		</div>


	<script>
		var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
		var lineChartData = {
			//labels : ["January","February","March","April","May","June","July"],
			labels :<%=labels%>,
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					//data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
					data : <%=data%>
				}/*,
				{
					label: "My Second dataset",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
				}*/
			]

		}

	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}


	</script>
	</body>
</html>
