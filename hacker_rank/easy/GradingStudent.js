/**
 * 02/08/22 night
 * https://www.hackerrank.com/challenges/grading/problem
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
 * Complete the 'lilysHomework' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

const pr = console.log;

// Accepted --- https://www.hackerrank.com/challenges/grading/submissions/code/255560490
function gradingStudents(a) {
    let res = [];
    for (const x of a) {
        if (x < 38) {
           res.push(x);
        } else {
            let s = x + '', last = s[s.length - 1];
            if ('38'.indexOf(last) != -1) {
                res.push(x + 2);
                continue;
            }
            if ('49'.indexOf(last) != -1) {
                res.push(x + 1);
                continue;
            }
            res.push(x);
        }
    }
    return res;
}

function main() {

    const gradesCount = parseInt(readLine().trim(), 10);

    let grades = [];

    for (let i = 0; i < gradesCount; i++) {
        const gradesItem = parseInt(readLine().trim(), 10);
        grades.push(gradesItem);
    }
    const res = gradingStudents(grades);
    for (const e of res) pr(e);
}
