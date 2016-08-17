<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Thank you for reporting a pothole at:</h3>

<p><c:if test="${pothole.addressNumber != null}">${pothole.addressNumber}</c:if> ${pothole.street}</p>
<p>${pothole.city}, ${pothole.zip}</p>


<c:import url="/WEB-INF/jsp/footer.jsp" />