

      var directionsDisplay;

      // Initialize Static Variables 
      var directionsService = new google.maps.DirectionsService();
      var map;
      var markerArray = [];
      var allRoutesArray = [];
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

       

      }

      function detectBrowser() {
         var useragent = navigator.userAgent;
         var mapdiv = document.getElementById("map-canvas");

          if (useragent.indexOf('iPhone') != -1 || useragent.indexOf('Android') != -1 ) {
            mapdiv.style.width = '100%';
            mapdiv.style.height = '100%';

          } else {
            mapdiv.style.width = '70%';
            mapdiv.style.height = '100%';
          }
        }

// Code for Simple Route //
      function simpleRoute(){

         var start = document.getElementById('start').value;
         var end = document.getElementById('end').value;

         

         if(start==0){
          start=user_location;
         }
         else{
          var start = document.getElementById('start').value;
         }
      
         

         //Options applied to the drawn line Object
          var polyYOptions = {
              strokeColor: '#FF0000',
              strokeOpacity: 1.0,
              strokeWeight: 3 };

         //Initialize Request Object 
          var request = {
              origin:start,
              destination:end,
              travelMode: google.maps.TravelMode.WALKING

          };


          // Directions Request Code Begins Here
          // Paramaters include the Request Object and a Call Back function that exectues
          // After the request has been initiated. 
          directionsService.route(request, function(response, status) {
                  if (status == google.maps.DirectionsStatus.OK){
                      poly = new google.maps.Polyline(polyYOptions);
                        

             // directionsDisplay.setDirections(response);
              alert(response.routes[0].overview_path.length);

              // Adds the DirectionsRenderer Object to allRoutesArray
              // Essentially this Object displays the route Also
              allRoutesArray[pos] = new google.maps.DirectionsRenderer({
                map: map,
                directions: response,
                polylineOptions: poly

                });

                allRoutesArray[pos].setPanel(document.getElementById('directions-panel'))

               pos++;

             }
           });
          // Directions Request Code End

         }
// End Code for Simple Route //

// WayPointRoute Function Code Begin Here
         function wayPointRoute(){
            var startTwo = document.getElementById('start').value;
            var endTwo = document.getElementById('end').value;


             if(startTwo==0){
                startTwo=user_location;
              }
              else{
                var startTwo = document.getElementById('start').value;
              }

            

            // An Array of Google LngLat Objects that represent the location of the way point.
            var waypts = [];

            // Array to recieve selected choices from the corresponding form check box
            var checkboxArray = document.getElementById('waypoints');

            // For loop, Loops through checkbox array for selections made by user.
            // If selection is found, add an object with location and stop over attributes defined.
            for (var i = 0; i < checkboxArray.length; i++) {
                  if (checkboxArray.options[i].selected == true) {
                          waypts.push({
                          location:checkboxArray[i].value,
                          stopover:true});
                      }
                  }

            // Request Object defined for later use in DirectionService function
            // Normal request object except for waypoints: property being assigned the array of way points
            // Also optimzieWaypoints set to true
             var request = {
                  origin: startTwo,
                  destination: endTwo,
                  waypoints: waypts,
                  optimizeWaypoints: true,
                 travelMode: google.maps.TravelMode.WALKING
             };


              // Directions Request Code Begins Here
              // Paramaters include the Request Object and a Call Back function that exectues
              // After the request has been initiated.
              directionsService.route(request, function(response, status) {
                 if (status == google.maps.DirectionsStatus.OK) {
                      //directionsDisplay.setDirections(response);


                      // Adds the DirectionsRenderer Object to allRoutesArray
                      // Essentially this Object displays the route Also
                      allRoutesArray[pos] = new google.maps.DirectionsRenderer({
                              map: map,
                              directions: response
                             
                             });

                      pos++;
                     }
                  });
         }
//  WayPointRoute Function Code Ends Here

//  displayAllRoutes Function Code Starts Here
          function displayAllAltRoutes(){
            var startThree = document.getElementById('start').value;
            var endThree = document.getElementById('end').value;

            if(startThree==0){
              startThree=user_location;
              }
            else{
               startThree = document.getElementById('start').value;
            }


          // Request Object Defined Here with addition to provideRouteAlternatives: true
          var request = {
              origin:startThree,
              destination:endThree,
              provideRouteAlternatives: true,
              travelMode: google.maps.TravelMode.WALKING
          };



          // Directions Request Code Begins Here
          // Paramaters include the Request Object and a Call Back function that exectues
          // After the request has been initiated.
          directionsService.route(request, function(response, status) {
          if (status == google.maps.DirectionsStatus.OK) {

               alert('Total Routes '+response.routes.length);
              
              // For Loop to loop through Array of All Routes Array 
              for(var h=0;h<response.routes.length;h++){

                 //alert(response.routes.length);
                allRoutesArray[pos] = new google.maps.DirectionsRenderer({
                                           map: map,
                                           directions: response,
                                           routeIndex: h
                                      });
                allRoutesArray[pos].setPanel(document.getElementById('directions-panel'));
                  pos++;
                }
              }
           });

         }

// displayAllRoutes Function Code Starts Ends Here

// enableAllMarkers Functio Code Starts Here
         function enableAllMarkers(){

            // Google LatLng Objects for each building on JCCC Campus
            var myLatlng = new google.maps.LatLng(38.9225006, -94.73179490000001);
            var myLatlng_two = new google.maps.LatLng(38.924214, -94.72767190000002);
            var Carlsen_center = new google.maps.LatLng(38.9252624, -94.7279145);
            var Regineer_center = new google.maps.LatLng(38.9243700, -94.72684989999999);
            var Office = new google.maps.LatLng(38.9245613,-94.728429);
            var Classroom_lab = new google.maps.LatLng(38.9233935, -94.7278336);
            var science = new google.maps.LatLng(38.9237222, -94.72876329999997);
            var Hospitality = new google.maps.LatLng(38.9230872,-94.72655580000003);
            var Galileo = new google.maps.LatLng(38.9233574, -94.7292281);
            var Student_center = new google.maps.LatLng(38.9245847, -94.73058229999998);
            var Campus_services = new google.maps.LatLng(38.9231457, -94.72993550000001);
            var art_tech = new google.maps.LatLng(38.9231911,-94.7308248);
            var welding_lab = new google.maps.LatLng(38.9221687, -94.73094609999998);
            var gymnasium = new google.maps.LatLng(38.9240505, -94.73171409999998);
            var general_edu = new google.maps.LatLng(38.924214, -94.7292281);
            var commons = new google.maps.LatLng(38.9245613,-94.72993550000001);
            var museum = new google.maps.LatLng(38.924852, -94.72682399999997);
            var horticultural = new google.maps.LatLng(38.9237438, -94.73527139999999);
            var police = new google.maps.LatLng(38.924395, -94.73527139999999);
            var child_development = new google.maps.LatLng(38.9232574,-94.73527139999999);
        

          // Marker Objects for each Building
          var itc = new google.maps.Marker({
          position: myLatlng,
          map: map,
          title: 'Industrial Training Center'
          });

          // Adds Marker Object to Array of all Marker Objects
          markerArray[0]=itc;

          var bl = new google.maps.Marker({
          position: myLatlng_two,
          map: map,
          title: 'Billington Library'
          });
          markerArray[1]=bl;

          var cc = new google.maps.Marker({
          position: Carlsen_center,
          map: map,
          title: 'Carlsen Center'
          });
          markerArray[2]=cc;

          var rc = new google.maps.Marker({
          position: Regineer_center,
          map: map,
          title: 'Regineer Center'
          });
          markerArray[3]=rc;

          var clb = new google.maps.Marker({
          position: Classroom_lab,
          map: map,
          title: 'Regineer Center'
          });
          markerArray[4]=clb;

          var sc = new google.maps.Marker({
          position: science,
          map: map,
          title: 'Science Building'
          });
          markerArray[5]=sc;

          var hca = new google.maps.Marker({
          position: Hospitality,
          map: map,
          title: 'Hospitality and Culinary Academy'
          });
          markerArray[6]=hca;

          var gp = new google.maps.Marker({
          position: Galileo,
          map: map,
          title: 'Galileos Pavilion'
          });
          markerArray[7]=gp;

          var stuc = new google.maps.Marker({
          position: Student_center,
          map: map,
          title: 'Student Center'
          });
          markerArray[8]=stuc;

          var camser = new google.maps.Marker({
          position: Campus_services,
          map: map,
          title: 'Campus Services Bldg'
          });
          markerArray[9]=camser;

          var art = new google.maps.Marker({
          position: art_tech,
          map: map,
          title: 'Arts and Technology Bldg'
          });
          markerArray[10]=art;

          var welding = new google.maps.Marker({
          position: welding_lab,
          map: map,
          title: 'Welding Lab Bldg'
          });
          markerArray[11]=welding;

          var gym = new google.maps.Marker({
          position: gymnasium,
          map: map,
          title: 'Gymnasium'
          });
          markerArray[12]=gym;

          var geb = new google.maps.Marker({
          position: general_edu,
          map: map,
          title: 'General Education Building'
          });
          markerArray[13]=geb;

          var college_commons = new google.maps.Marker({
          position: commons,
          map: map,
          title: 'College Commons Building'
          });
          markerArray[14]=college_commons;

          var nmoca = new google.maps.Marker({
          position: museum,
          map: map,
          title: 'Nerman Museum of Contemporary Art'
          });
          markerArray[15]=nmoca;

          var hsc = new google.maps.Marker({
          position: horticultural,
          map: map,
          title: 'Horticultural Science Center'
          });
          markerArray[16]=hsc;

          var pa = new google.maps.Marker({
          position: police,
          map: map,
          title: 'Police Academy'
          });
          markerArray[17]=pa;

          var hcdc = new google.maps.Marker({
          position: child_development,
          map: map,
          title: 'Hiersteiner Child Development Center'
          });
          markerArray[18]=hcdc;

          var ocb = new google.maps.Marker({
          position: Office,
          map: map,
          title: 'Office and Classroom Bldg'
          });
          markerArray[19]=ocb;

         }
// enableAllMarkers Functio Code Ends Here

// disableAllMarkersHere Function Code Starts Here
         function disableAllMarkers(){

          alert('number of current markers'+' '+markerArray.length);

                // Loop through array of marker Arrays and setMap to null to remove marker from map
                for(var x=0;x<markerArray.length;x++){
                    markerArray[x].setMap(null);
                }          
           }
// disableAllMarkersHere Function Code Ends Here

// Functions here is for future use, disregard for now
          function getHeading(){
          
           alert(google.maps.geometry.spherical.computeHeading(posOne,posTwo));
          }

          function calcDistance(){
            alert(google.maps.geometry.spherical.computeDistanceBetween(posOne,posTwo)*3.28084+' '+'Ft');
            alert(google.maps.geometry.spherical.computeDistanceBetween(posOne,posTwo));
          }

// ********************************************************************************************************

// removeRoute Function code starts here
          function removeRoute(){

            // Removes Last DirectionsRenderer Object, which is just the route 
            allRoutesArray[pos-1].setMap(null);
            allRoutesArray[pos-1].setPanel(null);

            alert('Total Amount of Routes '+allRoutesArray.length);

            // Removes the last object off the array Route. 
            allRoutesArray.pop();

            // Pos is simply the last index value that a DirectionsRenderer object was added
            // subtracting one will adjust for the next objet to be added correctly in order.
            pos--;
          }        
// removeRoute Function code ends here

  function getLocation(){
            if (navigator.geolocation)
              {
                 navigator.geolocation.getCurrentPosition(showPosition,{enableHighAccuracy: true});
              }else{
                alert( 'Geolocation is not supported by this browser.')
              }

    }

  function showPosition(position){
      alert('Lat: '+position.coords.latitude+' Long: '+position.coords.longitude); 

        user_location = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

       


  }

// userLocation Function ends here

  function placeLocMarker(){

      var userLoc = new google.maps.Marker({
          position: user_location,
          map: map,
          title: 'User Location'
          });
  }


        function showLocation(position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            alert("Latitude : " + latitude + " Longitude: " + longitude);

            drawCircle(latitude,longitude);

            user_location = new google.maps.LatLng(latitude,longitude);

            map.panTo(user_location);


          }

        function errorHandler(err) {
            if(err.code == 1) {
              alert("Error: Access is denied!");
            }else if( err.code == 2) {
              alert("Error: Position is unavailable!");
            }
          }

        function getLocationUpdate(){
         if(navigator.geolocation){
            // timeout at 60000 milliseconds (60 seconds)
            var options = {timeout:60000,enableHighAccuracy:true};
            geoLoc = navigator.geolocation;
            watchID = geoLoc.watchPosition(showLocation, 
                                           errorHandler,
                                           options);
         }else{
            alert("Sorry, browser does not support geolocation!");
         }
      }

      function drawCircle(latitude,longitude){

       //alert(latitude+' '+longitude);

       cenPos= new google.maps.LatLng(latitude, longitude);

       var circleOptions ={
            strokeColor: '#FF0000',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#FF0000',
            fillOpacity: 0.35,
            map: map,
            center: cenPos,
            radius: 1 };

            cityCircle = new google.maps.Circle(circleOptions);


      }

      function stopWatch(){
        navigator.geolocation.clearWatch(watchID);
      }


      // As soon as window loads, execute the function initialize
      google.maps.event.addDomListener(window, 'load', initialize);
