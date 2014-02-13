<?php
$db=mysql_connect("mysql3.000webhost.com", "a5498763_cis264", "cis264jccc") or die('Could not connect');
mysql_select_db("a5498763_cisData") or die('NoSuchDB');
    $result = mysql_query("SELECT * FROM Accounts WHERE Username=\"".$_GET["username"]."\" AND Password=\"".$_GET["password"]."\";") or die('Could not query');
    $json = array();
$rows = array();
while($r = mysql_fetch_assoc($result)) {
    $rows[] = $r;
}
print json_encode($rows);
    mysql_close($db);
    
?>

SELECT * FROM Accounts WHERE Username="<value>" AND Password="<value>"

