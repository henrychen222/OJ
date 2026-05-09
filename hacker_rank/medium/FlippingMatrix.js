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
 * 04/05/23 afternoon 05/08/26 afternoon
 * https://www.hackerrank.com/challenges/flipping-the-matrix/
 */
// Accepted --- https://www.hackerrank.com/challenges/flipping-the-matrix/submissions/code/471703709
function flippingMatrix(g) {
    let n = g.length;
    let res = 0;
    for (let i = 0; i < n >> 1; i++) {
        for (let j = 0; j < n >> 1; j++) {
            // 4 symmetric cells
            const a = g[i][j];
            const b = g[i][n - 1 - j];
            const c = g[n - 1 - i][j];
            const d = g[n - 1 - i][n - 1 - j];
            res += Math.max(a, b, c, d);
        }
    }
    return res;
}

const pr = console.log;

function main() {
    const q = parseInt(readLine().trim(), 10);
    for (let qItr = 0; qItr < q; qItr++) {
        const n = parseInt(readLine().trim(), 10);
        let matrix = Array(2 * n);
        for (let i = 0; i < 2 * n; i++) {
            matrix[i] = readLine().replace(/\s+$/g, '').split(' ').map(matrixTemp => parseInt(matrixTemp, 10));
        }
        const result = flippingMatrix(matrix);
        pr(result);
    }
}


/*
1
2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108


*/