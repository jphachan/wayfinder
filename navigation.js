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
              //alert(response.routes[0].overview_path.length);

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

            $('#btbside_menu_1').hide();
          	$('#map-canvas').show();
            $('#directions-panel').show();

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

                        allRoutesArray[pos].setPanel(document.getElementById('directions-panel'));

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

          $('#btbside_menu_1').hide();
          $('#map-canvas').show();
          $('#directions-panel').show();

         }

// displayAllRoutes Function Code Starts Ends Here

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

  function removeAllRoutes(){
     while(pos>0)
     {
      allRoutesArray[pos-1].setMap(null);
      allRoutesArray[pos-1].setPanel(null);

      allRoutesArray.pop();
      pos--;
     }
  }


