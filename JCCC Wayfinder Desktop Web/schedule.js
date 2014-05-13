function displaySchedule(){
    if(loginBoolean)
    {
      scheduleDisBoolean=true;
      disDailySchedule();


    }
    else
    {
      //alert('User Not Logged in or in Guest Mode');
      $('.logOut').hide();
      $('#schedule_button').hide();
    }
  }

  function buildingToLocation(building){
              if(building.toUpperCase()=="CLB"){
                return new google.maps.LatLng(38.9233935, -94.7278336);
              }else if(building.toUpperCase()=="ATB"){
                return new google.maps.LatLng(38.9231911,-94.7308248);
              }else if(building.toUpperCase()=="LIB"){
                return new google.maps.LatLng(38.924214, -94.72767190000002);
              }else if(building.toUpperCase()=="CSB"){
                return new google.maps.LatLng(38.9231457, -94.72993550000001);
              }else if(building.toUpperCase()=="CC"){
                return new google.maps.LatLng(38.9252624, -94.7279145);
              }else if(building.toUpperCase()=="COM"){
                return new google.maps.LatLng(38.9245613,-94.72993550000001);
              }else if(building.toUpperCase()=="GP"){
                return new google.maps.LatLng(38.9233574, -94.7292281);
              }else if(building.toUpperCase()=="GEB"){
                return new google.maps.LatLng(38.924214, -94.7292281);
              }else if(building.toUpperCase()=="GYM"){
                return new google.maps.LatLng(38.9240505, -94.73171409999998);
              }else if(building.toUpperCase()=="HCDC"){
                return new google.maps.LatLng(38.9232574,-94.73527139999999);
              }else if(building.toUpperCase()=="HCA"){
                return new google.maps.LatLng(38.9230872,-94.72655580000003);
              }else if(building.toUpperCase()=="HSC"){
                return new google.maps.LatLng(38.9237438, -94.73527139999999);
              }else if(building.toUpperCase()=="ITC"){
                return new google.maps.LatLng(38.9225006, -94.73179490000001);
              }else if(building.toUpperCase()=="NMOCA"){
                return new google.maps.LatLng(38.924852, -94.72682399999997);
              }else if(building.toUpperCase()=="OCB"){
                return new google.maps.LatLng(38.9245613,-94.728429);
              }else if(building.toUpperCase()=="PA"){
                return new google.maps.LatLng(38.924395, -94.73527139999999);
              }else if(building.toUpperCase()=="RC"){
                return new google.maps.LatLng(38.9243700, -94.72684989999999);
              }else if(building.toUpperCase()=="SCI"){
                return new google.maps.LatLng(38.9245847, -94.73058229999998);
              }else if(building.toUpperCase()=="WLB"){
                return new google.maps.LatLng(38.9221687, -94.73094609999998);
              }
              else
              {
                 alert('not found');
                 return null;
              } 
      }

      function disDailySchedule(){
        $('#schedule-panel').append('<table class="schedule_table"><tr><th>Daily Schedule</th><tr></table>');
        $('#schedule-panel').append('<table class="schedule_table"><tr><th >Course Section</th><th >Class Days</th><th >Course Building</th><th>Start Time</th><th>Select Route Here</th></tr></table>');
        for(g=0;g<json.course.length;g++)
        {
          if((json.day[g].indexOf(date.getDay()+1))!=-1)//OG version
          {
            $('#schedule-panel').append('<table class="schedule_table" id="dailyTable" title="Schedule"><tr><td>'+json.course[g]+'</td><td>'+dayConversion(json.day[g])+'</td><td>'+json.building[g]+'</td><td>'+timeConversion(json.startTime[g])+'</td><td><input type="checkbox" class="checkBox" value="'+json.building[g]+'"></td></tr></table>');
          }  
        }
      }

      function disFullSchedule(){
        $('.schedule_table2').hide();
        $('.schedule_table').hide();
        $('#schedule-panel').append('<table class="schedule_table2"><tr><th>Full Schedule</th><tr></table>');
        $('#schedule-panel').append('<table class="schedule_table2"><tr><th >Course Section</th><th >Class Days</th><th >Course Building</th><th>Start Time</th><th>Select Route Here</th></tr></table>');

           for(var sc_pos=0;sc_pos<json.course.length;sc_pos++)
               {
                  if(typeof(json.day[sc_pos])!='undefined')
                  {
                         $('#schedule-panel').append('<table class="schedule_table2" id="fullTable" title="Schedule"><tr><td>'+json.course[sc_pos]+'</td><td>'+dayConversion(json.day[sc_pos])+'</td><td>'+json.building[sc_pos]+'</td><td>'+timeConversion(json.startTime[sc_pos])+'</td><td><input type="checkbox" class="checkBox" value="'+json.building[sc_pos]+'"></td></tr></table>');
                  }
                  else
                  {
                      $('#schedule-panel').append('<table class="schedule_table2" id="fullTable" title="Schedule"><tr><td>'+json.course[sc_pos]+'</td><td>Online Class</td><td>Online Class</td><td>Online Class</td><td><input type="checkbox" class="checkBox" value="'+json.building[sc_pos]+'"></td></tr></table>');
                  }

          }
      }

      function dayConversion(schedArray){
        var tempString="";
        for(var z=0;z<schedArray.length;z++)
        {
              if(schedArray[z]==2)
              {
                tempString=tempString+" M ";
              }
              else if(schedArray[z]==3){
                tempString=tempString+" T ";
              }else if(schedArray[z]==4){
                tempString=tempString+" W ";
              }else if(schedArray[z]==5){
                tempString=tempString+" TR ";
              }else if(schedArray[z]==6){
                tempString=tempString+" F ";
              }else if(schedArray[z]==7){
                tempString=tempString+" SA ";
              }else if(schedArray[z]==1){
                tempString=tempString+" SU ";
              }
              else
              {
                tempString=tempString+"-";
              }
        }
        return tempString;
      }

      function showDaily(){
        $('.schedule_table').hide();
        $('.schedule_table2').hide();
        $('.schedule_table').show();
      }

      function timeConversion(timeStr){
				var newTime="";
				var hours = parseInt(timeStr.split(":")[0]);
				var hours24 = ((hours+ 11) % 12) + 1;
				var amPm = hours > 11 ? 'PM' : 'AM';
				var minutes = parseInt(timeStr.split(":")[1]);
				if(minutes==0)
				{
					return newTime=hours24+':'+minutes+'0 '+amPm;
				}
				else
				{
					return newTime=hours24+':'+minutes+' '+amPm;
				}
			}