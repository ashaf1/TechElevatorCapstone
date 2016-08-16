$(document).ready(function (e) {
	
	
	function refreshMapMarkers() {
		$.ajax("home", {
			type : "GET",
			dataType : "JSON"
		})
	}
	
	function showStatusAndInspectionDateFields() {
		if ($("#status").val() == "NEW"){
			$("#repairDate").hide();
			$("#priorityLevel").hide();
		}
	}		
	
});
