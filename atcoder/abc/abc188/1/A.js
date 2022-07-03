/**
 * 1.10 morning
 * https://atcoder.jp/contests/abc188/tasks/abc188_a
 */

// Accepted
const solve = (x, y) => {
    let behind = Math.min(x, y);
    let lead = Math.max(x, y);
    if (behind + 3 > lead) return console.log('Yes')
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
        solve(input[0][0], input[0][1]);
    });
};

main()