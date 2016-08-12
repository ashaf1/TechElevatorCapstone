$(document).ready(function () {
	
	$("form").validate({
		
		debug: true,
		rules: {
			repairDate: {laterThan : true}
		},
		
		errorClass: "error",
		validClass: "valid"
	});
	
});

$.validator.addMethod("laterThan", 
		function(value, element) {
			var inspectDate = document.getElementById("inspectionDate").value;
			var repairDate = document.getElementById("repairDate").value;
			return inspectDate < repairDate;
		}, "Repair date must be later than inspection date");
