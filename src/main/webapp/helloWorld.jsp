<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <body>
        <h1>Hello<c:if test="${not empty name}">, ${name}</c:if>!</h1>
    </body>
</html>