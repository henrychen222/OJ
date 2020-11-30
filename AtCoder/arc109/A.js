/**
 * 11.28 morning
 * https://atcoder.jp/contests/arc109/tasks/arc109_a
 */

// Accepted
const solve = (line) => {
    let tmp = line.split(" ").map(x => Number(x));
    let a = tmp[0];
    let b = tmp[1];
    let x = tmp[2];
    let y = tmp[3];
    if (a == b) {
        console.log(x);
    } else if (a > b) {
        let one = x + (a - 1 - b) * y;
        let two = x + 2 * (a - 1 - b) * x;
        console.log(Math.min(one, two));
    } else {
        let one = x + 2 * (b - a) * x;
        let two = (b - a) * y + x;
        console.log(Math.min(one, two));
    }
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