<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Welcome to Pothole Solutions!</h2>

<c:url var="reportPotholeHref" value="/report" />
<p id="reportLink"><a href="${reportPotholeHref}">Report a Pothole</a></p>

<c:import url="/WEB-INF/jsp/footer.jsp" />