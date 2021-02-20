/**
 * 1.30 morning
 * https://atcoder.jp/contests/abc190/tasks/abc190_a
 */

// Accepted
const solve = (a, b, c) => {
    if (c == 0) {
        if (a > b) {
            return console.log('Takahashi');
        } else {
            return console.log('Aoki');
        }
    } else {
        if (a >= b) {
            return console.log('Takahashi');
        } else {
            return console.log('Aoki');
        }
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
        solve(input[0][0], input[0][1], input[0][2]);
    });
};

main()