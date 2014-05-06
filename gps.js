function showLocation(position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            //alert("Latitude : " + latitude + " Longitude: " + longitude);

            



            user_location = new google.maps.LatLng(latitude,longitude);

            usrLocationArray.push(user_location);

            //map.panTo(usrLocationArray.length-1);

            map.panTo(usrLocationArray[usrLocationArray.length-1]);

            drawCircle();


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
            //setTimeout(stopWatch,30000);

            var options = {timeout:30000,enableHighAccuracy:true};
            geoLoc = navigator.geolocation;
            watchID = geoLoc.watchPosition(showLocation, 
                                           errorHandler,
                                           options);
         }else{
            alert("Sorry, browser does not support geolocation!");
         }
      }

      function drawCircle(){

       //alert(latitude+' '+longitude);

       cenPos= usrLocationArray[usrLocationArray.length-1];

       var circleOptions ={
            strokeColor: '#FF0000',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#FF0000',
            fillOpacity: 0.35,
            map: map,
            center: cenPos,
            radius: 1 };

           circleArray.push(new google.maps.Circle(circleOptions));




      }

      function stopWatch(){
        navigator.geolocation.clearWatch(watchID);
      }

      function removeCircle(){
        circleArray.pop().setMap(null);
      }
