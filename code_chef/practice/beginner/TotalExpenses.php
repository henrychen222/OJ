<?php
// 10/17/21 afternoon
// https://www.codechef.com/problems/FLOW009
error_reporting(E_ERROR | E_PARSE);

function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return nas(); }
function pr($x) { echo $x.PHP_EOL; }

// Accepted --- https://www.codechef.com/viewsolution/52576462 0.01sec
function solve () {
   $a = nas();
   $q = $a[0];
   $p = $a[1];
   $res = $q * $p;
   if ($q > 1000) $res *= 0.9;
   pr($res);
}

function main () {
   $t = ni();
   while($t--) solve();
}

main()
?>