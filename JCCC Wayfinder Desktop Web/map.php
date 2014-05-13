<?php 
require 'core.inc.php';
// echo $_SESSION['json'];
// echo '<a href="logout.php">Log Out</a>';
$logged = $_GET['loggedIn'];
?>

<!DOCTYPE html>
<html>
  <head>

  <!-- CHANGED  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" /> -->

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="wayFinderStyles.css" type="text/css" />
	 
	 <script type="text/javascript"> 
		
		var loginBoolean = <?php echo $logged ?>; 
		
		if(loginBoolean){
		var json = <?php echo $_SESSION['json'] ?>;
		}
    
    
		
    /*
		
    if(navigator.platform=="Win32")
    {
        alert(navigator.userAgent+' desktop');

    }
    else
    {
        alert('mobile');
        alert(navigator.userAgent+' desktop');
    }

    var OSName="Unknown OS";
if (navigator.appVersion.indexOf("Win")!=-1) OSName="Windows";
if (navigator.appVersion.indexOf("Mac")!=-1) OSName="MacOS";
if (navigator.appVersion.indexOf("X11")!=-1) OSName="UNIX";
if (navigator.appVersion.indexOf("Linux")!=-1) OSName="Linux";

alert(OSName);

*/

	 </script>

    <script type="text/javascript" src="jquery-2.1.0.js"></script>
    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyAXm4i-f_G5gFL-8YvXCFXUt_MMhbhGV2M&sensor=true">
    </script>
   
    <script type="text/javascript"
      src="extra.js">
    </script>
    <script type="text/javascript"
      src="gps.js">
    </script>
    <script type="text/javascript"
      src="navigation.js">
    </script>

    <script type="text/javascript"
      src="wayFinder.js">
    </script>

    <script type="text/javascript"
      src="schedule.js">
    </script> 
      
    
  </head>
  <body class="body">

    <header class="header">

    <!--
        <img alt="Johnson County Community College" class="site-logo" height="50%" src="jccc-logo-450x64.png" width="50%">
    -->
        <a href="http://jande179.byethost14.com/jptest/index.php"><img alt="Johnson County Community College" class="site-logo" height="50%" width="50%" src="jccc-logo-450x64.png"></a>

    </header>

    <nav id="nav_bar" class="nav"><!-- Nav begins here-->
              <ul>
                <li><a href="#" id="map_button">Map</a></li>
                <li><a href="#" id="nav_button">Navigation Input</a></li> 
                <li><a href="#" id="schedule_button">Student Schedule</a></li>
                <li><a href="#" id="clearRoute_button">Clear Routes</a></li> 
                <li><a href="logout.php" class="logOut">Log Out</a></li>
              </ul>
    </nav><!-- Nav ends here-->

  

    <div 
          id="map-canvas"/>
    </div>

    <aside id="btbside_menu_1" class="btb-sidemenu_1" >
            <h1 class="center">Building to Building Navigation</h1>
            <b>Start:</b>
            
            <select id="start">
                <option value="0">User Location</input>
                <option value="38.9231911,-94.7308248">Arts and Technology Bldg / ATB</input>
                <option value="38.924214, -94.72767190000002">Billington Library / LIB</input>
                <option value="38.9231457, -94.72993550000001">Campus Services Building / CSB</input>
                <option value="38.9252624, -94.7279145">Carlsen Center / CC</input>
                <option value="38.9233935, -94.7278336">Classroom Laboratory Building / CLB</input>
                <option value="38.9245613,-94.72993550000001">College Commons Building / COM</input>
                <option value="38.9233574, -94.7292281">Galileo's Pavilion / GP</input>
                <option value="38.924214, -94.7292281">General Education Building / GEB</input>
                <option value="38.9240505, -94.73171409999998">Gymnasium / GYM</input>
                <option value="38.9232574,-94.73527139999999">Hiersteiner Child Development Center / HCDC</input>
                <option value="38.9230872,-94.72655580000003">Hospitality and Culinary Academy / HCA</input>
                <option value="38.9237438, -94.73527139999999">Horticultural Science Center / HSC</input>
                <option value="38.9225006, -94.73179490000001">Industrial Training Center / ITC</input>
                <option value="38.924852, -94.72682399999997">Nerman Museum of Contemporary Art / NMOCA</input>
                <option value="38.9245613,-94.728429">Office and Classroom BLD / OCB</input>
                <option value="38.924395, -94.73527139999999">Police Academy / PA</input>
                <option value="38.9243700, -94.72684989999999">Regineer Center/ RC</input>
                <option value="38.9237222, -94.72876329999997">Science Building / SCI</input>
                <option value="38.9245847, -94.73058229999998">Student Center / SC</input>
                <option value="38.9221687, -94.73094609999998">Welding Lab Bldg / WLB</input>
            </select>
              
              <b>End:</b>
              
              <select id="end">
                <option value="38.9231911,-94.7308248">Arts and Technology Bldg / ATB</input>
                <option value="38.924214, -94.72767190000002">Billington Library / LIB</input>
                <option value="38.9231457, -94.72993550000001">Campus Services Building / CSB</input>
                <option value="38.9252624, -94.7279145">Carlsen Center / CC</input>
                <option value="38.9233935, -94.7278336">Classroom Laboratory Building / CLB</input>
                <option value="38.9245613,-94.72993550000001">College Commons Building / COM</input>
                <option value="38.9233574, -94.7292281">Galileo's Pavilion / GP</input>
                <option value="38.924214, -94.7292281">General Education Building / GEB</input>
                <option value="38.9240505, -94.73171409999998">Gymnasium / GYM</input>
                <option value="38.9232574,-94.73527139999999">Hiersteiner Child Development Center / HCDC</input>
                <option value="38.9230872,-94.72655580000003">Hospitality and Culinary Academy / HCA</input>
                <option value="38.9237438, -94.73527139999999">Horticultural Science Center / HSC</input>
                <option value="38.9225006, -94.73179490000001">Industrial Training Center / ITC</input>
                <option value="38.924852, -94.72682399999997">Nerman Museum of Contemporary Art / NMOCA</input>
                <option value="38.9245613,-94.728429">Office and Classroom BLD / OCB</input>
                <option value="38.924395, -94.73527139999999">Police Academy / PA</input>
                <option value="38.9243700, -94.72684989999999">Regineer Center/ RC</input>
                <option value="38.9237222, -94.72876329999997">Science Building / SCI</input>
                <option value="38.9245847, -94.73058229999998">Student Center / SC</input>
                <option value="38.9221687, -94.73094609999998">Welding Lab Bldg / WLB</input>
            </select>
            
            <input type="submit" value="Simple Route" onclick="simpleRoute();">
            <input type="submit" value="Alternate Routes" onclick="displayAllAltRoutes();">
            <!-- <input type="submit" value="Remove Last Route" onclick="removeRoute();"> -->
            
            
           
         
            <!--
                 <input type="submit" value="remove circle" onclick="removeCircle();">   
                 <input type="submit" value="refresh map" onclick="refreshMap();">
                  <a href="http://maps.google.com/?saddr=38.9252624,-94.7279145&daddr=38.9243700, -94.72684989999999">Nav Link With Dest & Origin</a>
            -->
            
              

            
           
    </aside>


     <aside class="checklist" id="schedule-panel">

     
          <div id="schedule_nav">
            <ul>
                <li><a href="#" id="daily_button">Daily</a></li>
                <li><a href="#" id="full_button">Full</a></li> 
            </ul>
         </div>

          <!--
          <input type="Submit" value="Daily" onClick="showDaily();">
          <input type="Submit" value="Full" onClick="disFullSchedule();">
          -->
    

          <script type="text/javascript"> 

          document.write('<table><tr><th>'+date+'</th><tr></table>');

          </script>

          
          <br>             
         
            
            

            <!--
            <input type="submit" value="Disable All Markers" onclick="disableAllMarkers();">
            <input type="submit" value="Enable All Markers" onclick="enableAllMarkers();">
            <input type="submit" value="Current Pos Watch" onclick="getLocationUpdate();">
            <input type="submit" value="Stop Watch" onclick="stopWatch();">
            -->
      </aside>
  
      <aside class="btb-sidemenu_3" id="directions-panel">
         

          <h1>Direction Panel</h1>

         


      </aside>

  </body>
</html>
