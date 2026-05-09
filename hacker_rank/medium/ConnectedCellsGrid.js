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
 * 05/08/26 afternoon
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid/
 */

// Accepted --- https://www.hackerrank.com/challenges/connected-cell-in-a-grid/submissions/code/471705311
// similar problem: https://leetcode.com/problems/number-of-islands/description/
function connectedCell(g) {
    // Write your code here
    let a = getAllAreas(g);
    return Math.max(...a);
}

// const dx = [1, -1, 0, 0], dy = [0, 0, 1, -1];
const dx = [1, -1, 0, 0, 1, 1, -1, -1], dy = [0, 0, 1, -1, 1, -1, 1, -1];
const getAllAreas = (g) => {
    const allow = 1, forbid = 0, floodFillMakeConnected = 'x';
    let n = g.length, m = g[0].length, res = [];
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (g[i][j] == allow) {
                let q = [[i, j]], area = 0;
                while (q.length) {
                    let [x, y] = q.shift();
                    for (let k = 0; k < 8; k++) {
                        let nx = x + dx[k], ny = y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == forbid || g[nx][ny] == floodFillMakeConnected) continue;
                        g[nx][ny] = floodFillMakeConnected;
                        area++;
                        q.push([nx, ny]);
                    }
                }
                res.push(area == 0 ? 1 : area);
            }
        }
    }
    return res;
};

function main() {
    const n = parseInt(readLine().trim(), 10);
    const m = parseInt(readLine().trim(), 10);
    let matrix = Array(n);
    for (let i = 0; i < n; i++) {
        matrix[i] = readLine().replace(/\s+$/g, '').split(' ').map(matrixTemp => parseInt(matrixTemp, 10));
    }
    const result = connectedCell(matrix);
    console.log(result)
}