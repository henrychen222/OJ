/**
 * 10.16 afternoon
 * https://codeforces.com/problemset/problem/4/A
 */

const solve = () => {};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        let res = solve(Number(line)) ? 'YES' : 'NO';
        console.log(res);
    });
};

main()