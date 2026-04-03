<?php
/**
 * 10/17/21 evening
 * https://www.codechef.com/problems/FLOW014
 */

function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return nas(); }
function pr($x) { echo $x.PHP_EOL; }

// Accepted --- https://www.codechef.com/viewsolution/52576642
function solve() {
   $a = nai();
   // pr($a[0].' '.$a[1].' '.$a[2]);
   if ($a[0] > 50 && $a[1] < 0.7 && $a[2] > 5600) {
       pr(10);
   } else if ($a[0] > 50 && $a[1] < 0.7) {
       pr(9);
   } else if ($a[1] < 0.7 && $a[2] > 5600) {
       pr(8);
   } else if ($a[0] > 50 && $a[2] > 5600) {
       pr(7);
   } else if ($a[0] > 50 || $a[1] < 0.7 || $a[2] > 5600) {
       pr(6);
   } else {
       pr(5);
   }
}

function main() {
    $t = ni();
    while ($t--) solve();
}

main()
?>