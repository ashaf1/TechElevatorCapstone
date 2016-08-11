<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h3>Please enter location information about the pothole below</h3>

<form action="report" method="POST">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label for="streetAddress">Street Address: </label>
				<input type="text" name="streetAddress" class="form-control"/>
			</div>	
			<div class="form-group">
				<label for="city">City: </label>
				<input type="text" name="city" class="form-control"/>
			</div>
				
			<div class="form-group">
				<label for="zip">Zip Code: </label>
				<input type="text" name="zip" class="form-control"/>
			</div>
			<div class="form-group">	
				<label for="comments">Comments: </label>
				<textarea rows="4" cols="50" name="comments" id="comments" class="form-control"></textarea>
				
			</div>	
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>


<c:import url="/WEB-INF/jsp/footer.jsp" />