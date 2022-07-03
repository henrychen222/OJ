/**
 * 1.30 morning
 * https://atcoder.jp/contests/abc190/tasks/abc190_b
 */

// Accepted
const solve = (n, s, d, a) => {
    for (const e of a) {
        let x = e[0];
        let y = e[1];
        if (x < s && y > d) return console.log('Yes');
    }
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
        solve(input[0][0], input[0][1], input[0][2], input.slice(1));
    });
};

main()