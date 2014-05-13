 //var testing = new google.maps.LatLng(38.924852, -94.72682399999997);
 
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
                // Loop through array of marker Arrays and setMap to null to remove marker from map
                for(var x=0;x<markerArray.length;x++){
                    markerArray[x].setMap(null);
                }          
           }
// disableAllMarkersHere Function Code Ends Here

  function showLink(){
    $('.btb-sidemenu_3').append('<a href=\"http://students.jccc.edu/jphachan/">Send Route to Google Maps Application</a>');



    var a = document.getElementById('end').value;
    var newLink ="http://maps.google.com/?daddr="+a+"&dirflg=w";
    window.open(newLink);
    $('.btb-sidemenu_3 a').attr('href', newLink);
  }

  
  function scheduleLinkNav(dest){
    $('.btb-sidemenu_3').append('<a href=\"http://students.jccc.edu/jphachan/">Send Route to Google Maps Application</a>');



    var scheduleDestination = dest;
    var newLinkTwo ="http://maps.google.com/?daddr="+scheduleDestination+"&dirflg=w";
     window.open(newLinkTwo);
    //$('.btb-sidemenu_3 a').attr('href', newLinkTwo);
  }


  function removeLink(){
    
    $('.btb-sidemenu_3').find('a').remove();
    
  }

  
  //As soon as map.php is loaded without errors execute the Jquery function.
  $(document).ready(function(){

        //Code below hides all panels on map.php 
        //The only panel remaining is the map panel
  			$('#btbside_menu_1').hide();
        $('#directions-panel').hide();
        $('#schedule-panel').hide();

            //When the user clicks on the a href with an id of #nav_button 
            //execute the function passed to the .click function call
            $('#nav_button').click(function() {

              //Create variable and assign the specific panel as the value
              var $panel = $('#btbside_menu_1');
              var $d_panel = $('#directions-panel');
              
              //After the a href with an id of #nav_button is excuted
              //Change the font color of the link
              //Font color of map and schedule change to white 
              $('#nav_button').css('color','black');
              $('#map_button').css('color','white');
              $('#schedule_button').css('color','white');

              //Code below hides all panels except for the Navigation Input Panel
            	$('#map-canvas').hide();
            	$('#btbside_menu_1').show();
              $('#schedule-panel').hide();
              $d_panel.hide();

            	$panel.css('float','none');
              
              
              map.panTo(usrLocationArray[usrLocationArray.length-1]);
              map.setZoom(17);
            	
			}); 

			$('#map_button').click(function() {

        //Apply a href font color change 
        $('#nav_button').css('color','white');
        $('#map_button').css('color','black');
        $('#schedule_button').css('color','white');

        //Assign map canvas to variable map_div
				var $map_div = $('#map-canvas');
				//$map_div.css('width','100%');

        //Because map canvas is previous hidden on page start
        //Unhide map and adjust if the window has changed
        $('#map-canvas').show();
        google.maps.event.trigger(map, 'resize');

        //Hide schedule and navigation input panels
        $('#btbside_menu_1').hide();
        $('#schedule-panel').hide();


        //If a route navigation is currently being displayed 
        //show directions panel
         if(navigationBoolean)
        {
          //alert(navigationBoolean+' Nav On');
          $('#directions-panel').show();

        }else{
          //alert(navigationBoolean+' Nav Off');
          $('#directions-panel').hide();

        }
                
            	
			});

      $('#schedule_button').click(function(){



            $('#schedule_button').css('color','black');
            $('#map_button').css('color','white');
            $('#nav_button').css('color','white');

        

            $('#schedule-panel').show();
            $('#map-canvas').hide();
            $('#btbside_menu_1').hide();
            $('#directions-panel').hide();

               if(navigationBoolean)
              {
                //alert(navigationBoolean+' Nav On');
                $('#directions-panel').hide();

              }
        });

      $('#full_button').click(function(){
      	$('#full_button').css('color','black');
      	$('#daily_button').css('color','white');
      	disFullSchedule();

      });

      $('#daily_button').click(function(){
      	$('#daily_button').css('color','black');
      	$('#full_button').css('color','white');
      	showDaily();

      });

      $('#clearRoute_button').click(function(){

            removeAllRoutes();

           
        });

        $("#schedule-panel").on("click", ".checkBox", function(event){

                var thisCheck = $(this);
              
              if(thisCheck.is(':checked'))
              {
              //alert('checked '+thisCheck.val());
            

             //alert('value returned is: '+buildingToLocation(thisCheck.val()));

                  scheduleRoute(buildingToLocation(thisCheck.val()));


                  $('#schedule_button').css('color','white');
                  $('#map_button').css('color','black');
                  $('#nav_button').css('color','white');

              }
              else
              {
              //alert('not checked');
              removeAllRoutes();
              

              }
        });

        
      displaySchedule();



      

        });



