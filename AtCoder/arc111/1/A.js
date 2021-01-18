/**
 * 1.9 morning
 * https://atcoder.jp/contests/arc111/tasks/arc111_a
 */

// WA
const solve = (N, M) => {
    let tmp = Math.floor(10 ** N / M) % M;
    console.log(tmp);
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
        solve(input[0][0], input[0][1]);
    });
};

main()