/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2014-09-10 12:03:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import testjdbc.DbBean;
import java.util.List;
import java.util.Map;

public final class line_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
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
   

      out.write(" \r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Line Chart</title>\r\n");
      out.write("\t\t<script src=\"js/Chart.js\"></script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div style=\"width:30%\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<canvas id=\"canvas\" height=\"450\" width=\"600\"></canvas>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar randomScalingFactor = function(){ return Math.round(Math.random()*100)};\r\n");
      out.write("\t\tvar lineChartData = {\r\n");
      out.write("\t\t\t//labels : [\"January\",\"February\",\"March\",\"April\",\"May\",\"June\",\"July\"],\r\n");
      out.write("\t\t\tlabels :");
      out.print(labels);
      out.write(",\r\n");
      out.write("\t\t\tdatasets : [\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tlabel: \"My First dataset\",\r\n");
      out.write("\t\t\t\t\tfillColor : \"rgba(220,220,220,0.2)\",\r\n");
      out.write("\t\t\t\t\tstrokeColor : \"rgba(220,220,220,1)\",\r\n");
      out.write("\t\t\t\t\tpointColor : \"rgba(220,220,220,1)\",\r\n");
      out.write("\t\t\t\t\tpointStrokeColor : \"#fff\",\r\n");
      out.write("\t\t\t\t\tpointHighlightFill : \"#fff\",\r\n");
      out.write("\t\t\t\t\tpointHighlightStroke : \"rgba(220,220,220,1)\",\r\n");
      out.write("\t\t\t\t\t//data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]\r\n");
      out.write("\t\t\t\t\tdata : ");
      out.print(data);
      out.write("\r\n");
      out.write("\t\t\t\t}/*,\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tlabel: \"My Second dataset\",\r\n");
      out.write("\t\t\t\t\tfillColor : \"rgba(151,187,205,0.2)\",\r\n");
      out.write("\t\t\t\t\tstrokeColor : \"rgba(151,187,205,1)\",\r\n");
      out.write("\t\t\t\t\tpointColor : \"rgba(151,187,205,1)\",\r\n");
      out.write("\t\t\t\t\tpointStrokeColor : \"#fff\",\r\n");
      out.write("\t\t\t\t\tpointHighlightFill : \"#fff\",\r\n");
      out.write("\t\t\t\t\tpointHighlightStroke : \"rgba(151,187,205,1)\",\r\n");
      out.write("\t\t\t\t\tdata : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]\r\n");
      out.write("\t\t\t\t}*/\r\n");
      out.write("\t\t\t]\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\twindow.onload = function(){\r\n");
      out.write("\t\tvar ctx = document.getElementById(\"canvas\").getContext(\"2d\");\r\n");
      out.write("\t\twindow.myLine = new Chart(ctx).Line(lineChartData, {\r\n");
      out.write("\t\t\tresponsive: true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
