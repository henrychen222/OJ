<?php
// 10/17/21 afternoon
// https://www.codechef.com/problems/SMPAIR
error_reporting(E_ERROR | E_PARSE);

function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return nas(); }
function pr($x) { echo $x.PHP_EOL; }

// Accepted --- https://www.codechef.com/viewsolution/52576515 0.56sec
function solve () {
    $n = ni();
    $a = nai();
    sort($a);
    pr($a[0] + $a[1]);
}

// partial AC 60/100   TLE
function solve1 () {
   $n = ni();
   $a = nai();
//   pr($n);
//   print_r($a);
   $min = PHP_INT_MAX;
   for ($i = 0; $i < $n; $i++) {
       for ($j = $i + 1; $j < $n; $j++) {
            $min = min($min, $a[$i] + $a[$j]);
       }
   }
   pr($min);
}

function main () {
   $t = ni();
   while($t--) solve();
}

main()
?>