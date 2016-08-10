<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Please enter location information about the pothole below</h3>

<form action="updatePothole" method="POST">

	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<label for="streetAddress">Street Address: </label>
	<input type="text" name="streetAddress" />
	
	<label for="city">City: </label>
	<input type="text" name="city" />
	
	<label for="priorityLevel">Priority Level: </label>
	<select name="priorityLevel">
		<option value="low">Low</option>
		<option value="medium">Medium</option>
		<option value="high">High</option>
	</select>
	<label for="status"></label>
	<select for="status">
		<option value="new">New</option>
		<option value="inspectionScheduled">Inspection Scheduled</option>
	</select>
	
	<label for="zip">Zip Code: </label>
	<input type="text" name="zip" />
	<br>
	<label for="comments">Comments: </label>
	<input type="text" name="comments" />
	
	<input type="submit" value="Submit" />
</form>


<c:import url="/WEB-INF/jsp/footer.jsp" />