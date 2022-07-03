/**
 * 1.10 morning
 * https://atcoder.jp/contests/abc188/tasks/abc188_d
 */

// don't understand
const solve = (n, c, arr) => {
    console.log(n, c, arr);
    let res = 0;
    for (const e of arr) {
        let a = arr[0];
        let b = arr[1];
        let c = arr[2];
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
        solve(input[0][0], input[0][1], input.slice(1));
    });
};

main()