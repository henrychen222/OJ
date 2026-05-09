/**
 * 02/08/22 evening 05/08/26 afternoon
 * https://www.hackerrank.com/challenges/bomber-man/problem
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
 * Complete the 'bomberMan' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. STRING_ARRAY grid
 */

const pr = console.log;

const allOBombGrid = (n, m) => [...Array(n)].map(() => Array(m).fill('O'));

// Accepted --- https://www.hackerrank.com/challenges/bomber-man/submissions/code/471704900
function bomberMan(time, g) {
    // pr(g)
    g = g.map(a => a.split(""))
    let n = g.length, m = g[0].length;
    if (time == 1) {
    } else if (time % 2 == 0) {
        g = allOBombGrid(n, m);
    } else {
        g = detonateFromAllO(g); // explode once  // 1 5 9 13
        if (time % 4 != 3) {
            g = detonateFromAllO(g); // explode twice  3 7 11 15
        }
    }
    outputG(g)
}

const outputG = (g) => {
    let res = g.map(a => a.join(""));
    for (const e of res) pr(e);
};

const detonateFromAllO = (g) => {
    let n = g.length, m = g[0].length, res = allOBombGrid(n, m);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (g[i][j] == 'O') {
                res[i][j] = '.';
                if (i + 1 < n) {
                    res[i + 1][j] = '.';
                }
                if (i - 1 >= 0) {
                    res[i - 1][j] = '.';
                }
                if (j + 1 < m) {
                    res[i][j + 1] = '.';
                }
                if (j - 1 >= 0) {
                    res[i][j - 1] = '.';
                }
            }
        }
    }
    return res;
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
