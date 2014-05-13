<?php
require 'core.inc.php';

if (loggedIn()) {
	header('Location: map.php?loggedIn=true');  // redirect to map
} else {
	include 'loginform.inc.php';  // redirect to loginform
}

?>