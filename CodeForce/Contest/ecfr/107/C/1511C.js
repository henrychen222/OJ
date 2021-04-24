/**
 * 04/12/21 noon
 * https://codeforces.com/contest/1511/problem/C
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// TLE
const solve = (n, q, a, t) => {
    let res = [];
    for (const e of t) {
        for (let i = 0; i < n; i++) {
            let item = a[i];
            if (item == e) {
                res.push(i + 1);
                a.splice(i, 1);
                a.unshift(item);
                break;
            }
        }
    }
    pr(res.join(" "));
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
        solve(input[0][0], input[0][1], input[1], input[2])
    });
};

main()