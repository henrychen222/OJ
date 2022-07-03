/**
 * 06/30/21 night
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
'use strict';
process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');
    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'extraLongFactorials' function below.
 *
 * The function accepts INTEGER n as parameter.
 */
const ll = BigInt;
const pr = console.log;
let dp;
const N = 100;
function calMax () {
    dp = Array(N).fill(1n);
    for (let i = 1; i < N; i++) {
        dp[i] = dp[i - 1] * ll((i + 1));
    }
}

// Accepted https://www.hackerrank.com/challenges/extra-long-factorials/submissions/code/221417815
function extraLongFactorials(n) {
    pr(n)
    // Write your code here
    pr(dp[n - 1].toString());
}

function main() {
    calMax()
    const n = parseInt(readLine().trim(), 10);
    extraLongFactorials(n);
}
