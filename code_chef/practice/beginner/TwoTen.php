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

// Accepted --- https://www.codechef.com/viewsolution/52576730 0.02sec
function solve () {
    $x = ni();
    $res = 0;
    if ($x % 5 && $x % 10) {
        pr(-1);
        return;
    }
    while ($x % 10) {
        $x *= 2;
        $res++;
    }
    pr($res);
}

function main () {
    $t = ni();
    while($t--) solve();
}

main();