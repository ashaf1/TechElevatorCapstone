<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Please enter location information about the pothole below</h3>

<form action="updatePothole" method="POST">

	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<input type="hidden" name="potholeId" value="${param.potholeId}"/>
	<label for="priorityLevel">Priority Level: </label>
	<select name="priorityLevel">
		<option value="">Select A Priority Level</option>
		<option value="low">Low</option>
		<option value="medium">Medium</option>
		<option value="high">High</option>
	</select>
	
	<label for="inspectionDate">Inspection Date</label>
	<input type="date" name="inspectionDate"/>
	
	<label for="repairDate">Repair Date</label>
	<input type="date" name="repairDate"/>
	<label for="status"></label>
	<select name="status">
		<option value="NEW">New</option>
		<option value="Inspection Scheduled">Inspection Scheduled</option>
		<option value="Repair_Scheduled">Repair Scheduled</option>
		<option value="Repaired">Repaired</option>
	</select>	
	<input type="submit" value="Submit" />
</form>


<c:import url="/WEB-INF/jsp/footer.jsp" />