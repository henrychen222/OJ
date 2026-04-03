<?php
// 10/17/21 afternoon
// error_reporting(E_ERROR | E_PARSE);

function line() { return trim(fgets(STDIN)); }
function ni() { return line(); }
function nas($sDelimeter = ' ') { return explode($sDelimeter, line()); }
function nai() { return array_map('intval', nas()); }
function yes() { return 'Yes'.PHP_EOL; }
function no() { return 'No'.PHP_EOL; }

// Accepted --- https://atcoder.jp/contests/abc223/submissions/26661843 20ms
function main () {
   $x = ni();
   if ($x < 100) {
      echo no();
      return;
   }
   echo $x % 100 == 0 ? yes() : no();
}

main()

?>