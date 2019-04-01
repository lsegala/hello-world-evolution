<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
Hello<logic:present name="helloWorldForm" property="name">, <bean:write name="helloWorldForm" property="name" /></logic:present>!