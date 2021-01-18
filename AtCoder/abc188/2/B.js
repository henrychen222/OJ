/**
 * 1.10 morning
 * https://atcoder.jp/contests/abc188/tasks/abc188_b
 */

// Accepted
const solve = (n, arr) => {
    let A = arr[0];
    let B = arr[1];
    let res = 0;
    for (let i = 0; i < n; i++) {
        res+= A[i] * B[i];
    }
    if (res == 0) return console.log('Yes')
    console.log('No');
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