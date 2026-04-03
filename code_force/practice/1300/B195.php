<?php
/**
 * 01/11/23 afternoon
 * https://codeforces.com/problemset/problem/195/B
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

// Accepted --- https://codeforces.com/problemset/submission/195/188935925
function solve($n, $m) {
   $pq = new SplMinHeap();
   for ($i = 1; $i <= $m; $i++) {
     $dis = abs(($m + 1) / 2 - $i);
     // echo $dis." ".$i."\n";
     $pq->insert([0, $dis, $i]);
   }
   $g = initializeGraph($m+1);
   $res = Arr($n + 1);
   for ($i = 1; $i <= $n; $i++) {
      $cur = $pq->extract();
      // echo $cur[0]." ".$cur[1]." ".$cur[2]."\n";
      $cur[0]++;
      array_push($g[$cur[2]], $i);
      $pq->insert($cur);
   }
   for ($i = 1; $i <= $m; $i++) {
       foreach ($g[$i] as $ball) $res[$ball] = $i;
   }
   for ($i = 1; $i <= $n; $i++) pr($res[$i]);
}

function main() {
    list($n, $m) = nai();
    solve($n, $m);
}

main();