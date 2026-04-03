<?php
/**
 * 
 * 
 */

error_reporting(E_ERROR | E_PARSE);
function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return array_map('intval', nas()); }
function pr($x) { echo $x.PHP_EOL; }
function pra($a) { echo json_encode($a).PHP_EOL; }
function Arr ($n) { $a = array(); for ($i = 0; $i < $n; $i++) array_push($a, 0); return $a;}
function initializeGraph ($n) { $g = array(); for ($i = 0; $i < $n; $i++) { array_push($g, array()); } return $g; };

function solve($n, $k, $a) {
}

function main() {
    $t = ni();
    while ($t--) {
        list($n, $k) = nai();
        $a = nai();
        solve($n, $k, $a);
    }
}

main();