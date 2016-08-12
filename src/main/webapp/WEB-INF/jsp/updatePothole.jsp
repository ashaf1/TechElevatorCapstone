<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Please update information about the pothole below:</h3>

<form action="updatePothole" method="POST">

	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<input type="hidden" name="potholeId" value="${param.potholeId}"/>
	<c:if test="${currentPothole.status != 'NEW'}">
		<c:url var="rescheduleInspectionHref" value="/users/${currentUser}/updatePothole?potholeId=${param.potholeId}">
			<c:param name="rescheduleInspection" value="true" />
		</c:url>
		<a href="${rescheduleInspectionHref}">Reschedule Inspection</a>
	</c:if>
	<div class="row">
		<div class="col-sm-6">
			<c:choose>
				<c:when test="${currentPothole.status == 'NEW' || param.rescheduleInspection == 'true'}">
				<input type="hidden" name = "priorityLevel" value=""/>
						<div id="inspectionDate" class="form-group">
							<label for="inspectionDate">Inspection Date: </label>
							<input type="date" name="inspectionDate" class="form-control update"/>
						</div>
						<div class="form-group">
							<label for="status">Status:</label>
							<select name="status"  class="form-control update">
								<option value="NEW">New</option>
								<option value="Inspection Scheduled">Inspection Scheduled</option>
								<!-- <option value="Repair Scheduled">Repair Scheduled</option>
								<option value="Repaired">Repaired</option> -->
							</select>
						</div>
				</c:when>
				<c:when test="${currentPothole.inspectionDate != null}">
					<h5>Inspected on ${currentPothole.inspectionDate}.</h5>
					<c:choose>
						<c:when test="${currentPothole.fixedDate != null && currentPothole.status != 'Repaired'}">
							<h5>Repairs scheduled for ${currentPothole.fixedDate}</h5>
						</c:when>
						<c:when test="${currentPothole.fixedDate != null && currentPothole.status == 'Repaired'}">
							<h5>Repaired on ${currentPothole.fixedDate}</h5>
						</c:when>
					</c:choose>
					<div id ="priorityLevel" class="form-group">
						<label for="priorityLevel">Priority Level: </label>
						<select name="priorityLevel" class="form-control update">
							<option value="">Select A Priority Level</option>
							<c:choose>
								<c:when test="${currentPothole.priorityLevel == 'Low'}">
									<option value="Low" selected="selected">Low</option>
								</c:when>
								<c:otherwise>
									<option value="Low">Low</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${currentPothole.priorityLevel == 'Medium'}">
									<option value="Medium" selected="selected">Medium</option>
								</c:when>
								<c:otherwise>
									<option value="Medium">Medium</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${currentPothole.priorityLevel == 'High'}">
									<option value="High" selected="selected">High</option>
								</c:when>
								<c:otherwise>
									<option value="High">High</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<div id="repairDate" class="form-group">
						<label for="repairDate">Repair Date: </label>
						<c:choose>
							<c:when test="${currentPothole.fixedDate != null}">
								<input type="date" name="repairDate" class="form-control update" value="${currentPothole.fixedDate}"/>
							</c:when>
							<c:otherwise>
								<input type="date" name="repairDate" class="form-control update"/>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
					<label for="status">Status:</label>
						<select name="status" id="status" class="form-control update">
							<option value="Repair Scheduled">Repair Scheduled</option>
							<option value="Repaired">Repaired</option>
							<option value="Duplicate">Duplicate</option>
						</select>
					</div>		
				</c:when>		
				</c:choose>
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />