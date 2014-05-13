// Code for Simple Route //
      function simpleRoute(){
      	 navigationBoolean = true;
         var start = document.getElementById('start').value;
         var end = document.getElementById('end').value;

         

         if(start==0){
          start=user_location;
          showLink();
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
                polylineOptions: poly,


                });

                allRoutesArray[pos].setPanel(document.getElementById('directions-panel'))

               pos++;

             }
           });
          // Directions Request Code End

            $('#btbside_menu_1').hide();
          	$('#map-canvas').show();
            $('#directions-panel').show();
            google.maps.event.trigger(map, 'resize');

            $('#nav_button').css('color','white');
          	$('#map_button').css('color','black');

         }
// End Code for Simple Route //

//  displayAllRoutes Function Code Starts Here
          function displayAllAltRoutes(){

          	navigationBoolean = true;
            var startThree = document.getElementById('start').value;
            var endThree = document.getElementById('end').value;

            if(startThree==0){
              startThree=user_location;
              showLink();
              }
            else{
               startThree = document.getElementById('start').value;
            }


          // Request Object Defined Here with addition to provideRouteAlternatives: true
          var request = {
              origin:startThree,
              destination:endThree,
              provideRouteAlternatives: true,
              travelMode: google.maps.TravelMode.WALKING,

          };



          // Directions Request Code Begins Here
          // Paramaters include the Request Object and a Call Back function that exectues
          // After the request has been initiated.
          directionsService.route(request, function(response, status) {
          if (status == google.maps.DirectionsStatus.OK) {

               //alert('Total Routes '+response.routes.length);
              
              // For Loop to loop through Array of All Routes Array 
              //for(var h=0;h<response.routes.length;h++){

              	for(var h=0;h<1;h++){

                 //alert(response.routes.length);
                allRoutesArray[pos] = new google.maps.DirectionsRenderer({
                                           map: map,
                                           directions: response,
                                           routeIndex: h,
                                           hideRouteList: false

                                      });

                allRoutesArray[pos].setPanel(document.getElementById('directions-panel'));
                  pos++;
                }
              }
           });

          $('#btbside_menu_1').hide();
          $('#map-canvas').show();
          google.maps.event.trigger(map, 'resize');
          $('#directions-panel').show();

          $('#nav_button').css('color','white');
          $('#map_button').css('color','black');

         }

// displayAllRoutes Function Code Starts Ends Here

          function scheduleRoute(buildingVal){


              navigationBoolean = true;
              
            var schedStart = user_location;
            var schedEnd = buildingVal;
            scheduleLinkNav(buildingVal);

          // Request Object Defined Here with addition to provideRouteAlternatives: true
          var request = {
              origin:schedStart,
              destination:schedEnd,
              provideRouteAlternatives: true,
              travelMode: google.maps.TravelMode.WALKING,

          };



          // Directions Request Code Begins Here
          // Paramaters include the Request Object and a Call Back function that exectues
          // After the request has been initiated.
          directionsService.route(request, function(response, status) {
          if (status == google.maps.DirectionsStatus.OK) {

               //alert('Total Routes '+response.routes.length);
              
              // For Loop to loop through Array of All Routes Array 
              //for(var h=0;h<response.routes.length;h++){

                for(var num=0;num<1;num++){

                 //alert(response.routes.length);
                allRoutesArray[pos] = new google.maps.DirectionsRenderer({
                                           map: map,
                                           directions: response,
                                           routeIndex: num,
                                           hideRouteList: false

                                      });

                allRoutesArray[pos].setPanel(document.getElementById('directions-panel'));
                  pos++;
                }
              }
           });

          $('#schedule-panel').hide();
          $('#btbside_menu_1').hide();
          $('#map-canvas').show();
          google.maps.event.trigger(map, 'resize');
          $('#directions-panel').show();

          $('#nav_button').css('color','white');
          $('#map_button').css('color','black');

          }



  function removeAllRoutes(){

  	removeLink();
    $('.checkBox').prop('checked',false);
  	navigationBoolean = false;
  	$('#directions-panel').hide();
  	
     while(pos>0)
     {
      allRoutesArray[pos-1].setMap(null);
      allRoutesArray[pos-1].setPanel(null);

      allRoutesArray.pop();
      pos--;
     }
  }


