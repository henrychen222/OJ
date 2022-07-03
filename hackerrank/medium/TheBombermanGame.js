/**
 * 02/08/22 evening
 * https://www.hackerrank.com/challenges/bomber-man/problem
 */

'use strict';

const { time } = require('console');
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
 * Complete the 'bomberMan' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. STRING_ARRAY grid
 */

const pr = console.log;

const initialize2DArray = (n, m) => { let d = []; for (let i = 0; i < n; i++) { let t = Array(m).fill(0); d.push(t); } return d; };

// 6/26 pass
function bomberMan(after, g) {
    let end = 1 + after;
    g = g.map(a => a.split(""));
    let n = g.length, m = g[0].length;
    let time = initialize2DArray(n, m);
    // pr(g);
    for (let t = 1; t <= end; t++) {
        // pr(t, end)
        if (t == 1) {
            for (let i = 0; i < n; i++) {
                for (let j = 0; j < m; j++) {
                    if (g[i][j] == 'O') {
                        time[i][j] = 2;
                    }
                }
            }
            // pr(t);
            // debug(g)
            continue;
        }
        if (t == 2) {
            timePass(g, time);
            // pr(t);
            // debug(g)
            continue;
        }
        if (t & 1) { // 3 5 7 9 ...
            // pr(t, "plantBomb before");
            plantBombAndTimePass(g, time);
            // pr(t, "plantBomb after");
            // debug(g)
        } else { // 4 6 8 10 ...
            // pr(t, "detonate before");
            detonateAndTimePass(g, time)
            // pr(t, "detonateAnd after");
            // debug(g)
        }
    }
    debug(g);
}

const debug = (g) => {
    let res = g.map(a => a.join(""));
    for (const e of res) pr(e);
};

const detonateAndTimePass = (g, time) => {
    let n = g.length, m = g[0].length;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (g[i][j] == 'O') {
                // pr(i, j, time[i][j])
                if (time[i][j] == 0) {
                    // pr("bomb", i, j);
                    g[i][j] = '.';
                    time[i][j] = 0;
                    // neighhour bomb, no relation time but has to reset neighbour time
                    if (i + 1 < n) {
                        g[i + 1][j] = '.';
                        time[i + 1][j] = 0;
                    }
                    if (i - 1 >= 0) {
                        g[i - 1][j] = '.';
                        time[i - 1][j] = 0;
                    }
                    if (j + 1 < m) {
                        g[i][j + 1] = '.';
                        time[i][j + 1] = 0;
                    }
                    if (j - 1 >= 0) {
                        g[i][j - 1] = '.';
                        time[i][j - 1] = 0;
                    }
                } else if (time[i][j] > 0) {
                    time[i][j]--;
                }
            } else {
                time[i][j] = 0;
            }
        }
    }
};

const timePass = (g, time) => {
    let n = g.length, m = g[0].length;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (g[i][j] == 'O') {
                time[i][j]--;
            } else {
                time[i][j] = 0;
            }
        }
    }
};

const plantBombAndTimePass = (g, time) => {
    let n = g.length, m = g[0].length;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (g[i][j] == 'O') {
                time[i][j]--;
            } else {
                g[i][j] = 'O';
                time[i][j] = 2;
            }
        }
    }
};

function main() {
    // const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const firstMultipleInput = readLine().replace(/\s+$/g, '').split(' ');

    const r = parseInt(firstMultipleInput[0], 10);

    const c = parseInt(firstMultipleInput[1], 10);

    const n = parseInt(firstMultipleInput[2], 10);

    let grid = [];

    for (let i = 0; i < r; i++) {
        const gridItem = readLine();
        grid.push(gridItem);
    }

    const result = bomberMan(n, grid);

    // ws.write(result.join('\n') + '\n');

    // ws.end();
}
