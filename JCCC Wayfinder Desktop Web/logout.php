<?php
require 'core.inc.php';

session_destroy(); // delete session data
header('Location: index.php'); // redirect to index

?>