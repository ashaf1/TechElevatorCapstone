<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Pothole Metrics</h2>
<div id="metrics">
	<p><b>Average time between report and repair (days):</b> ${avgRepairTime} days</p>
	<p><b>First Name:</b> ${streetWithMostPotholes}</p>
	<p><b>Last Name:</b> ${cityMostPotholes}</p>
	<p><b>Role:</b> ${user.role}</p>
	<c:url var="changePasswordHref" value="/users/${currentUser}/changePassword" />
	<a href="${changePasswordHref}">Change Password</a>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />