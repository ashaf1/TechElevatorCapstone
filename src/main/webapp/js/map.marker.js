$(document).ready(function (e) {
	
	refreshMapMarkers();
	
	function initMap() {
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
            center: {lat: 41.4993, lng: -81.6944},
            zoom: 12
        });
	}
	
	function refreshMapMarkers() {
		$.ajax("home", {
			type : "GET",
			dataType : "json"
		}).success(function(result) {
			populateMapMarkers(result)
		}).fail(logRequestFailure);
	}
	
	function populateMapMarkers(mapData) {
		var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
            center: {lat: 41.4993, lng: -81.6944},
            zoom: 12
        });
		var $mapBody = $("#map");
		var geocoder = new google.maps.Geocoder();
		for(var i = 0; i < mapData.length; i++) {
			var address;
			if(mapData[i].addressNumber == null){
				address = mapData[i].street+" "+mapData[i].zip;
			} else {
				address = mapData[i].addressNumber +" "+mapData[i].street+" "+mapData[i].zip;
			}
			geocoder.geocode({'address' : address}, function(results, status) {
				if(status == 'OK') {
					var marker = new google.maps.Marker({
						map: map,
						position: results[0].geometry.location
					});
				} else if (status === google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {    
		            setTimeout(function() {
		                Geocode(address);
		            }, 200);
		        } else {
					alert('Geocode was not successful for the following reason: '+status);
				}	
			});
				
		}
	}
	
	function showStatusAndInspectionDateFields() {
		if ($("#status").val() == "NEW"){
			$("#repairDate").hide();
			$("#priorityLevel").hide();
		}
	}
	
	
	function logRequestFailure(xhr, status, errorMessage) {
		console.log(status);
		console.log(result);
	}
	
});
