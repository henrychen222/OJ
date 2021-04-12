/**
 * 04/11/21 morning
 * https://atcoder.jp/contests/abc198/tasks/abc198_a
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (N) => {
    let res = 0;
    for (let i = 1; i < N; i++) {
        for (let j = 1; i + j <= N; j++) {
            if (i + j == N) res++;
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