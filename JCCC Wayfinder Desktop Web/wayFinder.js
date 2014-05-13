      
      /*
      var j_schedule = { "course":["MATH 171","ENGL 121","SPD 130","HPER 240"],
        "startTime":["17:00","14:00","00:00"],
         "day":[[2,3,4,5,6],[2,4,6],[4]],
         "building":["CLB","GEB","CC"]
       };

       var loginBoolean = true;

       */
       var hoursMinuteArray;
       var classArrayPos = 0;
       var classArray = [];
       
       var date = new Date();
       var sc_pos;

       var endingLocation;

      

       var navigationBoolean = false;

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

    

      //var testing = usrLocationArray[usrLocationArray.length-1];
      var link ="http://maps.google.com/?daddr=";


     
 
     
      

      function initialize() {

        //Start browser detect method 
        //detectBrowser();

        // Set map options for the map object
        var mapOptions = {
          center: new google.maps.LatLng(38.9248956, -94.72700000),
          zoom: 18,
          scaleControl: true
          
        };

        //Create new map objet with the mapOptions object
         map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);



         
         getLocationUpdate();
         
       

      }



      // As soon as window loads, execute the function initialize
      google.maps.event.addDomListener(window, 'load', initialize);
      
      
      /*
      google.maps.event.addDomListener(window, 'resize', function(){
          map.setCenter(usrLocationArray[usrLocationArray.length-1]);
      });
      */
