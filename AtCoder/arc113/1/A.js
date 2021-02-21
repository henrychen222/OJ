/**
 * 02/21/21 morning
 * https://atcoder.jp/contests/arc113/tasks/arc113_a
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (k) => {
    let res = 0;
    for (let a = 1; a <= k; a++) {
        for (let b = 1; b <= Math.ceil(k / a); b++) {
            let max = Math.ceil(k / (a * b));
            a * b * max == k ? res += max : res += max - 1;
        }
    }
    pr(res);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(Number(line));
    });
};

main()