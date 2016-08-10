<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Thank you for reporting a pothole at:</h3>

<p>${pothole.location.streetAddress}</p>
<p>${pothole.location.city}, ${pothole.location.state} ${pothole.location.zip}</p>

<c:forEach items="${allPotholes}" var="pothole">
	<p>${pothole.location.streetAddress}</p>
</c:forEach>

<c:import url="/WEB-INF/jsp/footer.jsp" />