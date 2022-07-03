/**
 * 10.13 morning
 * https://atcoder.jp/contests/abc162/tasks/abc162_b
 */

// Accepted --- 192ms
// https://atcoder.jp/contests/abc162/submissions/17385060
const solve = (N) => {
    let sum = 0;
    for (let i = 1; i <= N; i++) {
        if (i % 3 == 0 || i % 5 == 0) continue;
        sum += i;
    }
    return sum;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        terminal: false
    });

    rl.on('line', function (line) {
        console.log(solve(line));
    })
};

main()