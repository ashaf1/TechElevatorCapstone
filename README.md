Along with a partner, using Java, Spring MVC, postgreSQL, JavaScript, a bit of RESTful web services, and the Google Maps API,
we developed a program that is designed to track potholes for the city of Cleveland, OH and surrounding municipalities. As an 
employee of the Streets Department, you have access to all reported potholes and also have the ability to update the status 
of the potholes (i.e. change whether or not they have been repaired, when the inspection date is, etc.). If an employee happens 
to have the role of an administrator, he/she can create new users as well as everything normal employees can do. Members of the 
public are able to log on to our pothole tracker to report a pothole by submitting an address or nearest intersection, zip code, 
and some comments about the pothole. This data is then saved in a postgres database. The address, or cross-street, and zip code 
are then used by the Google Maps Geocoder to translate into a latitude/longitude combination and place a marker on the map at 
that location. Public users are able to see pothole-ridden areas so they can be avoided. Just as well, there is a pothole metrics 
page in which users can see the status of the pothole situation in the city. These metrics include but are not limited to: 
average time between report date and repair date, street with the most unfixed potholes, and city with the most unfixed potholes. 
