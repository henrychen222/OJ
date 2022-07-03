/**
 * 02/08/22 night
 * https://www.hackerrank.com/challenges/time-conversion/problem
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
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

const pr = console.log;

// Accepted --- https://www.hackerrank.com/challenges/time-conversion/submissions/code/255563129
function timeConversion(s) {
    let period = s.slice(-2);
    let a = s.slice(0, -2).split(":");
    if (period == 'AM') {
        if (a[0] == '12') {
            a[0] = '00';
        }
        return a.join(":");
    } else {
        if (a[0] != '12') {
            a[0] = (a[0] - '0' + 12) + '';
        }
        return a.join(":");
    }
}

function main() {
    const s = readLine();
    const result = timeConversion(s);
    pr(result)
}
