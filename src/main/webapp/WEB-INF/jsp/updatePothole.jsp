<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Please enter location information about the pothole below</h3>

<form action="updatePothole" method="POST">

	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<input type="hidden" name="potholeId" value="${param.potholeId}"/>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label for="priorityLevel">Priority Level: </label>
				<select name="priorityLevel" class="form-control update">
					<option value="">Select A Priority Level</option>
					<option value="Low">Low</option>
					<option value="Medium">Medium</option>
					<option value="High">High</option>
				</select>
			</div>
			<div class="form-group">
				<label for="inspectionDate">Inspection Date: </label>
				<input type="date" name="inspectionDate" class="form-control update"/>
			</div>
			<div class="form-group">
				<label for="repairDate">Repair Date: </label>
				<input type="date" name="repairDate" class="form-control update"/>
			</div>
			<div class="form-group">
				<label for="status">Status</label>
				<select name="status" class="form-control update">
					<option value="NEW">New</option>
					<option value="Inspection Scheduled">Inspection Scheduled</option>
					<option value="Repair_Scheduled">Repair Scheduled</option>
					<option value="Repaired">Repaired</option>
				</select>
			</div>	
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>


<c:import url="/WEB-INF/jsp/footer.jsp" />