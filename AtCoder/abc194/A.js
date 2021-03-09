/**
 * 03/06/21 morning
 * https://atcoder.jp/contests/abc194/tasks/abc194_a
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (a, b) => {
    let s = a + b;
    if (s >= 15 && b >= 8) {
        pr(1);
    } else if (s >= 10 && b >= 3) {
        pr(2);
    } else if (s >= 3) {
        pr(3);
    } else {
        pr(4);
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
        solve(input[0][0], input[0][1]);
    });
};

main()