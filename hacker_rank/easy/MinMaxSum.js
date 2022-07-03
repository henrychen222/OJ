/**
 * 02/08/22 night
 * https://www.hackerrank.com/challenges/mini-max-sum/
 */
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function (inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function () {
    inputString = inputString.split('\n');
    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

const pr = console.log;

const sm = (a) => a.reduce(((x, y) => x + y), 0);

// Accepted --- https://www.hackerrank.com/challenges/mini-max-sum/submissions/code/255561445
function miniMaxSum(a) {
    let sum = sm(a);
    let min = Math.min(...a), max = Math.max(...a);
    pr(sum - max, sum - min)
}

function main() {
    const arr = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    miniMaxSum(arr);
}
