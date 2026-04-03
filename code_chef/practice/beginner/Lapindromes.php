<?php
/**
 * 10/17/21 evening 01/11/23 night fixed
 * https://www.codechef.com/problems/LAPIN
 */
error_reporting(E_ERROR | E_PARSE);
function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return nas(); }
function pr($x) { echo $x.PHP_EOL; }
function pra($a) { echo json_encode($a).PHP_EOL; }

// reference: https://discuss.codechef.com/t/lapin-editorial/2335
// WA, some issue https://www.codechef.com/viewsolution/52577313


// Accepted --- https://www.codechef.com/viewsolution/85267565
// TLE --- https://www.codechef.com/viewsolution/85267513
function solve() {
    $s = line();
    $n = strlen($s);
    $a = initializeArray(26);
    $b = initializeArray(26);
    for($i = 0; $i < $n >> 1; $i++)  $a[ord($s[$i]) - ord('a')]++;
    for($i = ($n+1) >> 1; $i < $n; $i++) $b[ord($s[$i]) - ord('a')]++;
    for ($i = 0; $i < $n; $i++) { // issue here should $i < 26 stupid
        if ($a[$i] != $b[$i]) {
            pr('NO');
            return;
        }
    }
    pr('YES');
}

// WA --- https://www.codechef.com/viewsolution/52576982
// Accepted --- https://www.codechef.com/viewsolution/85267053
function solve1() {
    $s = line();
    $n = strlen($s);
    $left = '';
    $right = '';
    if ($n & 1) {
        for ($i = 0, $j = $n - 1; $i < $n >> 1; $i++, $j--) {
            $left .= $s[$i];
            $right .= $s[$j];
        }
    } else {
        for ($i = 0, $j = $n - 1; $i < $n / 2; $i++, $j--) {
            $left .= $s[$i];
            $right .= $s[$j];
        }
    }
     // pr($left . ' ' . $right);
      pr(ok($left, $right) ? 'YES': 'NO');
}

function ok ($s, $t) {
    $n = strlen($s);
    $a = initializeArray(26);
    $b = initializeArray(26);
    for ($i = 0; $i < $n; $i++) $a[ord($s[$i]) - ord('a')]++;
    for ($i = 0; $i < $n; $i++) $b[ord($t[$i]) - ord('a')]++;
//    pra($a);
//    pra($b);
    for ($i = 0; $i < $n; $i++) { // issue here should $i < 26 stupid
        if ($a[$i] != $b[$i]) return false;
    }
    return true;
}

function initializeArray ($n) {
    $a = array();
    for ($i = 0; $i < $n; $i++) array_push($a, 0);
    return $a;
}

function main() {
    $t = ni();
    while ($t--) solve();
}

main();