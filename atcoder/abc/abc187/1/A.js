/**
 * 1.2 morning
 * https://atcoder.jp/contests/abc187/tasks/abc187_a
 */

// Accepted
const solve = (s) => {
    let a = s.split(" ");
    let max = 0;
    for (const st of a) {
        let sum = 0;
        for (const c of st) {
            sum += Number(c);
        }
        max = Math.max(max, sum);
    }
    console.log(max);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(line);
    });
};

main()