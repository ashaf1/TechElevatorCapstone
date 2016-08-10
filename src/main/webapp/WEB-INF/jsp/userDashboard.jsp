<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>My Account</h2>
<div id="myAccount">
	<p><b>Username:</b> ${user.userName}</p>
	<p><b>First Name:</b> ${user.firstName}</p>
	<p><b>Last Name:</b> ${user.lastName}</p>
	<p><b>Role:</b> ${user.role}</p>
	<c:url var="changePasswordHref" value="/users/${currentUser}/changePassword" />
	<a href="${changePasswordHref}">Change Password</a>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />