<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Pothole Report</h2>

<h3> Search Potholes by Criteria: </h3>
<div class = "form-group">
	<form action= "reports" method = "POST"> 
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
		<div class ="searchCriteria">
			<label for="status">Status:</label>
				<select name="status"  class="form-control update">
					<option value="">Select A Status</option>
					<option value="NEW">New</option>
					<option value="Inspection Scheduled">Inspection Scheduled</option>
					<option value="Repair Scheduled">Repair Scheduled</option>
					<option value="Repaired">Repaired</option>
					<option value="Duplicate">Duplicate</option>
				</select>
			</div>	
		<div class ="searchCriteria">	
			<label for= "priorityLevel"> Priority Level:</label>
				<select name="priorityLevel" class = "form-control update">
					<option value="">Select A Priority Level</option>
					<option value="Low">Low</option>
					<option value="Medium">Medium</option>
					<option value="High">High</option>
				</select>
			</div>				
			<div class ="searchCriteria"><label for = "street">Street: </label>
				<input type = "text" name= "street" class = "form-control update">
			</div>
			<div class ="searchCriteria"><label for= "city" >City: </label>
				<input type = "text" name = "city" class = "form-control update">
			</div>
			<div class ="searchCriteria"><label for = "zip">Zip Code: </label>
				<input type = "text" name = "zip" class= "form-control update">
			</div>		
			<div class ="searchCriteria"><button type="submit" class="btn btn-default">Search</button>
		    </div>
 	</form>

</div>

<%-- <table id="potholeReport">
	<tr>
		<th>Pothole ID</th>
		<th>Street Address</th>
		<th>City</th>
		<th>Zip</th>
		<th>Comments</th>
		<th>Submitted On</th>
		<th class="status">Status</th>
		<th>Inspection Date</th>
		<th>Repair Date</th>
		<th>Priority</th>
	</tr>
	<c:if test="${filteredPotholes.length == 0}">
	<c:forEach items="${potholes}" var="pothole">
		<tr>
			<c:url var="updatePotholeHref" value="/users/${currentUser}/updatePothole">
				<c:param name="potholeId">${pothole.potholeId}</c:param>
			</c:url>
			<td id="potholeId"><a href="${updatePotholeHref}">${pothole.potholeId}</a></td>
			<td>${pothole.streetAddress}</td>
			<td>${pothole.city}</td>
			<td>${pothole.zip}</td>
			<td>${pothole.comments}</td>
			<td>${pothole.createDate}</td>
			<c:choose>
				<c:when test="${pothole.status == 'NEW'}">
					<td id="new">${pothole.status}</td>
				</c:when>
				<c:otherwise>
					<td class="status">${pothole.status}</td>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pothole.inspectionDate != null}">
					<td>${pothole.inspectionDate}</td>
				</c:when>
				<c:otherwise>
					<td>Not yet scheduled</td>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pothole.fixedDate != null}">
					<td>${pothole.fixedDate}</td>
				</c:when>
				<c:otherwise>
					<td>Not yet scheduled</td>
				</c:otherwise>
			</c:choose>
			<td id="priority">${pothole.priorityLevel}</td>
		</tr>
	</c:forEach>
</table> --%>

<c:import url="/WEB-INF/jsp/footer.jsp" />