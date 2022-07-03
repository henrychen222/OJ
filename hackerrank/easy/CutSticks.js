/**
 * 02/08/22 night
 * https://www.hackerrank.com/challenges/cut-the-sticks/problem
 */

'use strict';

const fs = require('fs');

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
 * Complete the 'cutTheSticks' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

const pr = console.log;

// Accepted --- https://www.hackerrank.com/challenges/cut-the-sticks/submissions/code/255564988
function cutTheSticks(a) {
    let res = [];
    while (a.length) {
        res.push(a.length);
        let min = Math.min(...a);
        let b = [];
        for (const x of a) {
            if (x - min > 0) {
                b.push(x - min);
            }
        }
        a = b;
    }
    return res;
}

function main() {
    const n = parseInt(readLine().trim(), 10);
    const arr = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));
    const result = cutTheSticks(arr);
    for (const e of result) pr(e);
}
