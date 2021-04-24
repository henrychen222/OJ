/**
 * 03/29/21 morning
 * https://codeforces.com/contest/1498/problem/B
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mx = Math.max;
///////////////////////////////////////////////////////////////////////////////////

// WA
// const solve = (n, w, a) => {
//     let sum = a.reduce((x, y) => x + y);
//     pr(ce(sum / w))
// };

// WA
const solve = (n, w, a) => {
    let m = new Map();
    for (const e of a) m.set(e, m.get(e) + 1 || 1);
    let max = mx.apply(Math, a);
    pr(m.get(max))
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
        let t = input[0][0];
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i][1], input[i + 1]);
            i += 2;
        }
    });
};

main()