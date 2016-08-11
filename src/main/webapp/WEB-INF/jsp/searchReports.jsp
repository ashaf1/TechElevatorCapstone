<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Pothole Report</h2>

<table id="potholeReport">
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
</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />