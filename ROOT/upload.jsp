<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %> 
<%@page import="java.util.Enumeration" %> 
<%@page import="testcsv.CsvAnalysis" %>
<%@page import="testjdbc.DbBean" %>
<%@page import="java.util.List" %>
<% 
    String saveDirectory = "C:\\test\\"; 
    // 限制上傳之檔案大小為 5 MB 
    int maxPostSize = 5 * 1024 * 1024 ; 
    MultipartRequest multi = new MultipartRequest(request , 
                       saveDirectory , maxPostSize, "UTF-8"); 
   String filenames = multi.getOriginalFileName("File1"); 
   
         //out.println("上傳了檔案" + filenames + "<br>"); 
         
         CsvAnalysis cc = new CsvAnalysis();
         DbBean dd = new DbBean();
         List dataList = cc.csvString(saveDirectory+filenames);
         
         //out.println("value" + dataList + "<br>");
         out.println(dataList);
         //[[2402, 2403, 2404, 2405, 2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415, 2416, 2417, 2418, 2419, 2420], 
          //[5.59, 5.61, 5.58, 5.6, 5.63, 5.6, 5.62, 5.62, 5.73, 5.69, 5.66, 5.69, 5.68, 5.71, 5.69, 5.68, 5.66, 5.67, 5.66]]
 		for(int i=0;i<dataList.size();i++){
 			System.out.println(dataList.get(i).toString());
 			
 			List insertList  = (List)dataList.get(i);
 			 out.println(insertList);
 			int result = dd.InsertData("insert into CalValue(Frequency,Loss) values (?,?) ", insertList);
 			 out.println(result);
// 			int jj=0;
// 			jj=dataList.size();
// 			out.println("i : " + jj + "<br>"); 
 		}
 		
   
%> 