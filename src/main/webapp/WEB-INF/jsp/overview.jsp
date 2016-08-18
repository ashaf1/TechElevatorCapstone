<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Pothole Metrics</h2>
<div id="metrics">
	<p><b>Average time between report and repair (days):</b> ${avgRepairTime} days</p>
	<p><b>Street with most unfixed potholes:</b> ${streetWithMostPotholes}</p>
	<p><b>City with most unfixed potholes:</b> ${cityMostPotholes}</p>
	<p><b>Zip/City area with most unfixed potholes:</b> ${zipCityWithMostPotholes}</p>
	<p><b>Number of "High" priority potholes:</b> ${highPriorityPotholes}</p>
	<p><b>City with most "High" priority potholes:</b> ${cityMostHighPriorityPotholes}</p>
	<p><b>Potholes fixed in last month:</b> ${potholesFixedInLastMonth}</p>
	<p><b>Potholes reported in last month:</b> ${potholesReportedInLastMonth}</p>
	
	
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />