/**
 * 03/13/21 morning
 * https://atcoder.jp/contests/abc195/tasks/abc195_b
 * 
 * i * x + j * y =
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- https://atcoder.jp/contests/abc195/submissions/20906219
// reference: https://atcoder.jp/contests/abc195/submissions?f.User=uwi
const solve = (a, b, w) => {
    w *= 1000;
    let min = -1;
    let max = -1;
    for (let k = 1; k <= 1000000; k++) {
        if (a * k <= w && w <= b * k) {
            max = k;
            if (min == -1) min = k;
        }
    }
    min == -1 ? pr("UNSATISFIABLE") : pr(min, max);
}

// // don't know
// const solve = (a, b, w) => {
//     w *= 1000;
//     let rl = w / a >> 0
//     let rr = w / b >> 0;
//     pr(a, b, w, rl, rr);
//     let min = Number.MAX_SAFE_INTEGER;
//     let max = 0;
//     for (let x = 1; x * a <= w; x++) {
//         for (let y = 1; y * b <= w; y++) {
//             for (let i = 1; i <= a; i++) {
//                 for (let j = 1; j <= b; j++) {
//                     pr(x, y, i, j)
//                     if (i * x + j * y == w) {
//                         min = mi(min, i + j);
//                         max = mx(max, i + j);
//                     }
//                 }
//             }
//         }
//     }
//     if (min == Number.MAX_SAFE_INTEGER || max == 0) pr('UNSATISFIABLE');
//     pr(min, max);
// };

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
        solve(input[0][0], input[0][1], input[0][2]);
    });
};

main()