$(document).ready(function (e) {
	function showStatusAndInspectionDateFields() {
		if ($("#status").val() == "NEW"){
			$("#repairDate").hide();
			$("#priorityLevel").hide();
		}
	}		
	
});
