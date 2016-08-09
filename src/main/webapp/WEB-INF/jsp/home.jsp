<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Welcome to Pothole Solutions!</h3>

<c:url var="reportPotholeHref" value="/report" />
<a href="${reportPotholeHref}">Report a Pothole</a>

<c:import url="/WEB-INF/jsp/footer.jsp" />