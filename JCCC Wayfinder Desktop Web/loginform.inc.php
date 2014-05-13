<?php
$_SESSION['json'] = 0;
if (isset($_POST['username']) && isset($_POST['password'])) {

	$username = $_POST['username']; // aaardva1 or aaardva2
	$password = $_POST['password']; // Aa7654321! or Aa123456!
	
	$phpArray = array('course'=>null, 'startTime'=>null, 'day'=>null, 'building'=>null);
	
	
	if (!empty($username) && !empty($password)) { // Checks for empty input boxes
	
		$id = null;
		$json_a = null;
		$dbhandler = "http://jcccwayfinder.byethost5.com/DatabaseHandler.php?username=$username&password=$password";
				
		$fh = fopen($dbhandler, 'r'); // Pass username and password to database handler, activates script, 'r'eads JSON return
		$theData = fgets($fh);  // Stores JSON as string
		fclose($fh);
			
		if((trim($theData))==='[]') { // Test for empty JSON
			echo 'Username or Password do not match! <br />';
		}
		else {
			$json_a=json_decode($theData,true); // Parse JSON into array
			if($json_a[0]['PASSWORD']===$password) { // Test password case match
				$id = $json_a[0]['ID'];
				$student_info = 'https://ac-tstemobile.jccc.edu/banner-mobileserver/api/2.0/courses/overview/'.$id.'?term=201401';
				
				// Pass username and password to Banner authentication
				$ch = curl_init();
				curl_setopt($ch, CURLOPT_URL, $student_info);
				curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
				curl_setopt($ch, CURLOPT_USERPWD, "$username:$password");
				curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);
				curl_setopt ($ch, CURLOPT_SSL_VERIFYPEER, TRUE); 
				curl_setopt ($ch, CURLOPT_CAINFO, "cacert.pem");  // Production location of certificate file
				//curl_setopt ($ch, CURLOPT_CAINFO, "C:\\xampp\\htdocs\\jptest\\cacert.pem");  // Development location of certificate file
				//curl_setopt ($ch, CURLOPT_SSL_VERIFYHOST, 0);  // Bypass certificate
				//curl_setopt ($ch, CURLOPT_SSL_VERIFYPEER, 0);  // Bypass certificate
				$output = curl_exec($ch);  // Store Student data JSON as string
				$info = curl_getinfo($ch);  // Stores HTTP status and other useful info for debugging
				//print 'error:'.curl_error($ch).'<br />';  // Curl debugging
				curl_close($ch);				
				
				// echo 'output:';
				// print_r($output);
				// echo '<br />';
				//echo 'info:';
				//print_r($info);
				//echo '<br />';
				/* {"person":{"id":"987654321","name":"Aardvark, Alfred"},
					 "terms":[{"id":"201401","name":"Credit Spring 2014","startDate":"2014-01-13","endDate":"2014-05-16",
					 "sections":[{"sectionId":"11741","sectionTitle":"College Algebra","courseName":"MATH 171","courseDescription":"College Algebra","courseSectionNumber":"003","firstMeetingDate":"2014-01-13","lastMeetingDate":"2014-05-16","credits":3,"ceus":null,"instructors":[{"firstName":"Brian","lastName":"Balman","middleInitial":"Richard","instructorId":"00322030","primary":"true","formattedName":"Balman, Brian R."}],"learningProvider":null,"learningProviderSiteId":null,"primarySectionId":null,
													"meetingPatterns":[{"instructionalMethodCode":"F2F","startDate":"2014-01-13","endDate":"2014-05-16","startTime":"17:00Z","endTime":"17:50Z",
													"daysOfWeek":[2,3,4,5,6],"room":"205","building":"Classroom Laboratory Building",
													"buildingId":"CLB","campusId":"1"}],"isInstructor":false},
									 {"sectionId":"11385","sectionTitle":"Composition I Course","courseName":"ENGL 121","courseDescription":"Composition I Course","courseSectionNumber":"003","firstMeetingDate":"2014-01-13","lastMeetingDate":"2014-05-16","credits":3,"ceus":null,"instructors":[{"firstName":"Katherine","lastName":"Karle","middleInitial":null,"instructorId":"00690326","primary":"true","formattedName":"Karle, Katherine"}],"learningProvider":null,"learningProviderSiteId":null,"primarySectionId":null,
													"meetingPatterns":[{"instructionalMethodCode":"F2F","startDate":"2014-01-13","endDate":"2014-05-16","startTime":"14:00Z","endTime":"14:50Z",
													"daysOfWeek":[2,4,6],"room":"242","building":"General Education Building",
													"buildingId":"GEB","campusId":"1"}],"isInstructor":false},
									 {"sectionId":"10717","sectionTitle":"Elementary Debate","courseName":"SPD 130","courseDescription":"Elementary Debate","courseSectionNumber":"001","firstMeetingDate":"2014-01-13","lastMeetingDate":"2014-05-16","credits":3,"ceus":null,"instructors":[{"firstName":"Justin","lastName":"Stanley","middleInitial":"Matthew","instructorId":"00662784","primary":"true","formattedName":"Stanley, Justin M."},{"firstName":"Daniel","lastName":"Stout","middleInitial":"R","instructorId":"00716882","primary":"false","formattedName":"Stout, Daniel R."}],"learningProvider":null,"learningProviderSiteId":null,"primarySectionId":null,
													"meetingPatterns":[{"instructionalMethodCode":"F2F","startDate":"2014-01-15","endDate":"2014-05-16","startTime":"00:00Z","endTime":"02:50Z",
													"daysOfWeek":[4],"room":"216","building":"Carlsen Center",
													"buildingId":"CC","campusId":"1"}],"isInstructor":false},
									 {"sectionId":"10555","sectionTitle":"Lifetime Fitness I","courseName":"HPER 240","courseDescription":"Lifetime Fitness I","courseSectionNumber":"001","firstMeetingDate":"2014-01-13","lastMeetingDate":"2014-05-16","credits":1,"ceus":null,"instructors":[{"firstName":"Sharon","lastName":"Thompson","middleInitial":"L","instructorId":"00322379","primary":"true","formattedName":"Thompson, Sharon L."}],"learningProvider":null,"learningProviderSiteId":null,"primarySectionId":null,
													"meetingPatterns":[],"isInstructor":false}]}]} */
				
				$json_b = json_decode($output, true); // Parse JSON into array
				
				// Pull necessary data from student data array ClassID, StartTime, DaysOfWeek, BuildingID into session array to pass to next page
				for($i=0; $i<count($json_b['terms'][0]['sections']); $i++) {
					$phpArray['course'][$i] = $json_b['terms'][0]['sections'][$i]['courseName'];
					if(count($json_b['terms'][0]['sections'][$i]['meetingPatterns'])>0) {
						$phpArray['startTime'][$i] = substr($json_b['terms'][0]['sections'][$i]['meetingPatterns'][0]['startTime'], 0, -1);
						$phpArray['building'][$i] = $json_b['terms'][0]['sections'][$i]['meetingPatterns'][0]['buildingId'];
						for($k=0; $k<count($json_b['terms'][0]['sections'][$i]['meetingPatterns'][0]['daysOfWeek']); $k++) {
							$phpArray['day'][$i][$k] = $json_b['terms'][0]['sections'][$i]['meetingPatterns'][0]['daysOfWeek'][$k];
						}
					}
				}
				
				// print_r($phpArray);
				// echo '<br />';
			/* Array ( [course] => Array ( [0] => MATH 171 [1] => ENGL 121 [2] => SPD 130 [3] => HPER 240 ) 
						  [startTime] => Array ( [0] => 17:00 [1] => 14:00 [2] => 00:00 ) 
						  [day] => Array ( [0] => Array ( [0] => 2 [1] => 3 [2] => 4 [3] => 5 [4] => 6 ) [1] => Array ( [0] => 2 [1] => 4 [2] => 6 ) [2] => Array ( [0] => 4 ) ) 
						  [building] => Array ( [0] => CLB [1] => GEB [2] => CC ) )  */

				// $_SESSION['phpArray'] = $phpArray;
				
				$jArr = json_encode($phpArray);
				
				// echo $jArr.'<br />'; 
				// For aaardva1 result is {"course":["MATH 171","ENGL 121","SPD 130","HPER 240"],"startTime":["17:00","14:00","00:00"],"day":[[2,3,4,5,6],[2,4,6],[4]],"building":["CLB","GEB","CC"]}
				
				$_SESSION['json'] = $jArr;
				
				// echo $_SESSION['json'];
				// echo '<br />';
				
				$_SESSION['user_id'] = $id; // Store StudentID into session variable
				header('Location: index.php'); // Redirect to load map
				// echo loggedIn();
				// echo '<a href="logout.php">Log Out</a>';
			}
			else {
				echo 'Incorrect Password! <br />';
			}
		}	
	} 
	else {
		echo 'You must enter a Username and Password!';
	}
}

?>
<!DOCTYPE html>
<html>
  <head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  		<style type = "text/css">

		  	.login {
		      background-image:url("app_background_gradient.png");
		      width: 100%;
		      position: absolute;
		      top: 0;
		      left: 0;
		    }
  
    		.userPass{		   
		      width: 100%;
    		}
    
    		.userPass p {
		      text-align: center;
    		}
    
    		@media screen and (max-device-width: 480px) and (orientation: portrait){
  				.userPass{
  					background-size: 100% 100%;
  					width: 95%;
  					margin-right: 5%;
  				}
			}
  		</style>	
  </head>
  
  <body class="login">
	<div class="userPass">
		<form action="<?php echo $current_file; ?>" method="POST">

			

			<p>
				<img src="jcccWayFinder_Login.png" alt="Smiley face" height="300" width="300">
				<br />
				Username: <input type="text" name="username"><br />
				Password: <input type="password" name="password"><br />
				
				<input type="submit" value="Login"> 
				<br /><br /><br />
				<font size="5"><a href="map.php?loggedIn=false" >GUEST</a></font><br />
				
			</p>
		</form>
	</div>
	</body>
	</html>