<?php
// 10/17/21 afternoon
// https://www.codechef.com/problems/DIFFSUM
// error_reporting(E_ERROR | E_PARSE);

function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return array_map('intval', nas()); }
function yes() { return 'Yes'.PHP_EOL; }
function no() { return 'No'.PHP_EOL; }

// Accepted --- https://www.codechef.com/viewsolution/52576372 0.19sec
function main () {
   $x = ni();
   $y = ni();
   // echo $x.' '.$y.PHP_EOL;
   echo ($x > $y ? abs($y - $x) : $x + $y).PHP_EOL;
}

main()
?>