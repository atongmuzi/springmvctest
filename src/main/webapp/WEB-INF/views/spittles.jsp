
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page session="false" %>--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
hello atong!
hello ahua!
hello hot!
hello ahua!
alin
<P>  The ModelAndView name is ${user.name}. </P>
<P>  The psss  is ${user.pass}. </P>
<c:forEach items="${spittleList}" var="spittle">
    <div class="message">
        <c:out value="${spittle.message}"></c:out>
    </div>
</c:forEach>

</body>
</html>
