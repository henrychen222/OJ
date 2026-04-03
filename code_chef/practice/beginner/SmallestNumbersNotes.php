<?php
// 10/17/21 afternoon
// https://www.codechef.com/problems/FLOW005
// error_reporting(E_ERROR | E_PARSE);

function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return array_map('intval', nas()); }
function pr($x) { echo $x.PHP_EOL; }

// Accepted
function solve () {
    $x = ni();
    $res = 0;
    if ($x >= 100) {
       $res += $x / 100 >> 0;
       $x %= 100;
    }
    // pr($x.' '.$res);
    if ($x >= 50) {
       $res += $x / 50 >> 0;
       $x %= 50;
    }
    // pr($x.' '.$res);
    if ($x >= 10) {
       $res += $x / 10 >> 0;
       $x %= 10;
    }
    // pr($x.' '.$res);
    if ($x >= 5) {
       $res += $x / 5 >> 0;
       $x %= 5;
    }
    // pr($x.' '.$res);
    if ($x >= 2) {
        $res += $x / 2 >> 0;
        $x %= 2;
    }
    // pr($x.' '.$res);
    pr($x == 0 ? $res : $res + 1);
}

function main () {
   $t = ni();
   while($t--) solve();
}

main()
?>