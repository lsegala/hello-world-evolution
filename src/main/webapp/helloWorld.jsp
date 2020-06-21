<%@ page contentType="text/html; charset=ISO-8859-1" %>
<html>
    <body>
        <h1>Hello<%=request.getAttribute("name") != null? ", "+request.getAttribute("name") : ""%>!</h1>
    </body>
</html>