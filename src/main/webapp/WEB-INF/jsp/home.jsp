<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<style>
 #map {
        width: 100%;
        height: 400px;
     }
  </style>

<h2>Welcome to Pothole Solutions!</h2>

<c:url var="reportPotholeHref" value="/report" />
<p id="reportLink"><a href="${reportPotholeHref}">Report a Pothole</a></p>

<h3>Pothole Map</h3>
    <div id="map"></div>
    <script>
      function initMap() {
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
            center: {lat: 41.4993, lng: -81.6944},
            zoom: 12
        });
      }
    </script>
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3emkM7-taWJSEiEmOWIKxTCBdcLI01vo&callback=initMap">
    </script>

<c:import url="/WEB-INF/jsp/footer.jsp" />