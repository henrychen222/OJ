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
 * 04/05/23 afternoon
 * https://www.hackerrank.com/challenges/flipping-the-matrix/
 */

const preSum = (a) => { let pre = [0]; for (let i = 0; i < a.length; i++) { pre.push(pre[i] + a[i]); } return pre; };
const subArraySum = (a, l, r) => a[r + 1] - a[l];

// bottowLeft quadrant -> bottowRight quadrant -> TopRight quadrant -> TopLeft quadrant
function flippingMatrix(g) {
    let n = g.length, m = g[0].length, preRow = g.map(a => preSum(a)), preCol = preSum2DCol(g), res = 0;
    // pr(preRow)
    // pr(preCol)
    for (let i = n / 2; i < n; i++) {
        let lsum = subArraySum(preRow[i], 0, m / 2 - 1), rsum = subArraySum(preRow[i], m / 2, m - 1);
        if (lsum > rsum) g[i].reverse();
    }
    pr("step1", g);
    preRow = g.map(a => preSum(a)), preCol = preSum2DCol(g);
    for (let j = m / 2; j < m; j++) {
        let upSum = subArraySum(preCol[j], 0, n / 2 - 1), downSum = subArraySum(preCol[j], n / 2, n - 1);
        if (downSum > upSum) {
            reverseCol(g, j);
        }
    }
    pr("step2", g);
    preRow = g.map(a => preSum(a)), preCol = preSum2DCol(g);
    for (let i = 0; i < n / 2; i++) {
        let lsum = subArraySum(preRow[i], 0, m / 2 - 1), rsum = subArraySum(preRow[i], m / 2, m - 1);
        if (lsum < rsum) {
            g[i].reverse();
        }
    }
    pr("step3", g, cal(g));
}


const cal = (g) => {
    let n =g.length, m =g[0].length, res = 0;
    for (let i = 0; i < n / 2; i++) {
        for (let j = 0; j < m / 2; j++) res += g[i][j];
    }
    return res;
};

const preSum2DCol = (g) => {
    let n = g.length, m = g[0].length, res = [];
    for (let j = 0; j < m; j++) {
        let v = [];
        for (let i = 0; i < n; i++) v.push(g[i][j]);
        res.push(preSum(v));
    }
    return res;
};

const reverseCol = (g, col) => {
    let n = g.length, v = [];
    for (let i = 0; i < n; i++) v.push(g[i][col]);
    for (let i = 0; i < n; i++) g[i][col] = v.pop();
};

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