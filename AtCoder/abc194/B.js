/**
 * 03/06/21 morning
 * https://atcoder.jp/contests/abc194/tasks/abc194_b
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (n, d) => {
    let a = [];
    let b = [];
    for (let i = 0; i < n; i++) {
        a.push([i, d[i][0]]);
        b.push([i, d[i][1]]);
    }
    a.sort((x, y) => x[1] - y[1]);
    b.sort((x, y) => x[1] - y[1]);
    if (a[0][0] == b[0][0]) {
        pr(mi(a[0][1] + b[0][1], mx(a[0][1], b[1][1]), mx(a[1][1], b[0][1])))
    } else {
        pr(mx(a[0][1], b[0][1]));
    }
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => Number(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input.slice(1));
    });
};

main()