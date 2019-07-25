<%@ page import="com.DataBaseOperations"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.Invoice"%>

<html>
<head>
<title>Sample Application JSP Page1</title>
</head>
<body bgcolor=white>

<table border="0">
<tr>
<td>
<img src="images/pdqlogo.gif">
</td>
<td>
<h1>Accounting module - GST</h1>
<p>
</td>
</tr>
</table>

<table>
<%= new String("Hello!") %>

<% ArrayList list = new DataBaseOperations().getInvoiceData(); 
	Invoice invoice = null;
%>

<tr>
	<td>Vendor Id</td>
	<td>Company Id</td>
	<td>Amount</td>
</tr>

 <% for(int i = 0; i < list.size(); i+=1) { 
	invoice = new Invoice();
	invoice = (Invoice)list.get(i);
 %>
        <tr>      
            <td><%=invoice.getVendorId() %></td>
			<td><%=invoice.getCompanyId()%></td>
			<td><%=invoice.getAmt()%></td>
        </tr>
    <% } %>
</table>
</body>
</html>
