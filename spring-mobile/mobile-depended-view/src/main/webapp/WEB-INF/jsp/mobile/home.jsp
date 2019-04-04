<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello Spring MVC</title>
</head>

<body>
    <p>MOBILE HOME</p>
    <p>User-Agent: <c:out value="${header['User-Agent']}" /></p>
    <p>Device: <c:out value="${requestScope.currentDevice}" /></p>
    <p>SitePreference : <c:out value="${requestScope.currentSitePreference}" /></p>
</body>
</html>