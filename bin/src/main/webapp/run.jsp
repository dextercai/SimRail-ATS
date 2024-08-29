<%@ page import="rin.simrail.web.Craw" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Timer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SimRail車内警報装置</title>
</head>
<body>
    <h1>SimRail車内警報装置</h1>
    <%
        PrintWriter print = response.getWriter();
        String server = (String) request.getAttribute("server");
        String carNumber = (String) request.getAttribute("carNumber");
    %>
    <%  Timer timer = new Timer();
        while (true) {
        if (carNumber != null && server != null) {
            String[] data = Craw.craw(new String[]{server, carNumber});
            if (Integer.parseInt(data[0]) <=60 && Integer.parseInt(data[1]) <= 1000){
                //警報
            }
            try {
                timer.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            print.println("Server or Car Number is null");
        }
    }%>
</body>
</html>