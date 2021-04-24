/**
 * 10.21 afternoon
 * https://codeforces.com/problemset/problem/1433/E
 */

// Accepted --- 62ms
// reference: https://codeforces.com/contest/1433/submission/96200362
const solve = (n) => {
    let res = 1;
    for (let i = 1; i <= n; i++) {
        res *= i;
    }
    res /= n;
    res /= (n >> 1);
    return res;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        console.log(solve(Number(line)));
    });
};

main()