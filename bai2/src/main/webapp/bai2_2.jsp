<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculation Result</title>
</head>
<body>
<%! int x = 10; int y; int z = 0; %>
<%
  y = 200;
  z = x + y;

%>
<%=out.append("Ket qua la: ").append(String.valueOf(z))%>
<h2>Hoặc ta có thể xuất kiểu expression</h2>
<hr>
<%="Ket qua la: " + z %>
</body>
</html>
