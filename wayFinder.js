

      var directionsDisplay;

      // Initialize Static Variables 
      var directionsService = new google.maps.DirectionsService();
      var map;
      var markerArray = [];
      var allRoutesArray = [];
      var usrLocationArray = [];
      var circleArray = [];
      var pos = 0;
      var user_location;

      var watchID;
      var geoLoc;

      var cityCircle;

     
 
     
      

      function initialize() {

        //Start browser detect method 
        //detectBrowser();

        // Set map options for the map object
        var mapOptions = {
          center: new google.maps.LatLng(38.9248956, -94.72700000),
          zoom: 18,
          

        };

        //Create new map objet with the mapOptions object
         map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);

         getLocationUpdate();
       

      }


      // As soon as window loads, execute the function initialize
      google.maps.event.addDomListener(window, 'load', initialize);
