<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Please update information about the pothole below:</h3>

<form action="updatePothole" method="POST">

	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<input type="hidden" name="potholeId" value="${param.potholeId}"/>
	<%-- <c:if test="${currentPothole.status != 'NEW'}">
		<c:url var="rescheduleInspectionHref" value="/users/${currentUser}/updatePothole?potholeId=${param.potholeId}">
			<c:param name="rescheduleInspection" value="true" />
		</c:url>
		<a href="${rescheduleInspectionHref}">Reschedule Inspection</a>
	</c:if> --%>
	<div class="row">
		<div class="col-sm-6">
			<c:choose>
				<c:when test="${currentPothole.status == 'NEW' || param.rescheduleInspection == 'true'}">
				<input type="hidden" name = "priorityLevel" value=""/>
						<div id="inspectionDate" class="form-group">
							<label for="inspectionDate">Inspection Date: </label>
							<c:choose>
								<c:when test="${currentPothole.inspectionDate != null}">
									<input type="date" name="inspectionDate" class="form-control update" value="${currentPothole.inspectionDate}" id="inspectionDate" min="${currentPothole.createDate}"/>
								</c:when>
								<c:otherwise>
									<input type="date" name="inspectionDate" class="form-control update" id="inspectionDate" min="${currentPothole.createDate}"/>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<label for="status">Status:</label>
							<select name="status"  class="form-control update">
								<c:choose>
									<c:when test="${currentPothole.status == 'NEW'}">
										<option value="NEW" selected="selected">NEW</option>
									</c:when>
									<c:otherwise>
										<option value="NEW">NEW</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${currentPothole.status != 'NEW'}">
										<option value="Inspection Scheduled" selected="selected">Inspection Scheduled</option>
									</c:when>
									<c:otherwise>
										<option value="Inspection Scheduled">Inspection Scheduled</option>
									</c:otherwise>
								</c:choose>
								<!-- <option value="Repair Scheduled">Repair Scheduled</option>
								<option value="Repaired">Repaired</option> -->
							</select>
						</div>
				</c:when>
				<c:when test="${currentPothole.status != 'NEW'}">
					<c:url var="rescheduleInspectionHref" value="/users/${currentUser}/updatePothole?potholeId=${param.potholeId}">
						<c:param name="rescheduleInspection" value="true" />
					</c:url>
					<a href="${rescheduleInspectionHref}">Reschedule Inspection</a>
					<c:choose>
						<c:when test="${currentPothole.inspectionDate != null && currentPothole.status != 'Repair Scheduled' && currentPothole.status != 'Repaired'}">
							<h5>Inspection scheduled on:</h5>
							<h5 id="inspectionDate">${currentPothole.inspectionDate}</h5>
						</c:when>
						<c:when test="${currentPothole.inspectionDate != null && currentPothole.status == 'Repair Scheduled' || currentPothole.status == 'Repaired'}">
							<h5>Inspected on:</h5>
							<h5 id="inspectionDate">${currentPothole.inspectionDate}</h5>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${currentPothole.fixedDate != null && currentPothole.status != 'Repaired'}">
							<h5>Repairs scheduled for:</h5>
							<h5>${currentPothole.fixedDate}</h5>
						</c:when>
						<c:when test="${currentPothole.fixedDate != null && currentPothole.status == 'Repaired'}">
							<h5>Repaired on:</h5>
							<h5>${currentPothole.fixedDate}</h5>
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
								<input type="date" name="repairDate" class="form-control update" value="${currentPothole.fixedDate}" id="repairDate" min="${currentPothole.inspectionDate}"/>
							</c:when>
							<c:otherwise>
								<input type="date" name="repairDate" class="form-control update" id="repairDate" min="${currentPothole.inspectionDate}"/>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
					<label for="status">Status:</label>
						<select name="status" id="status" class="form-control update">
							<c:choose>
								<c:when test="${currentPothole.status == 'Repair Scheduled'}">
									<option value="Repair Scheduled" selected="selected">Repair Scheduled</option>
								</c:when>
								<c:otherwise>
									<option value="Repair Scheduled">Repair Scheduled</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${currentPothole.status == 'Repaired'}">
									<option value="Repaired" selected="selected">Repaired</option>
								</c:when>
								<c:otherwise>
									<option value="Repaired">Repaired</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${currentPothole.status == 'Duplicate'}">
									<option value="Duplicate" selected="selected">Duplicate</option>
								</c:when>
								<c:otherwise>
									<option value="Duplicate">Duplicate</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>		
				</c:when>		
				</c:choose>
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>
<script src="update.validation.js"></script>
<c:import url="/WEB-INF/jsp/footer.jsp" />