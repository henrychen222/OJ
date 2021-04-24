/**
 * 02/19/21 morning
 * https://codeforces.com/contest/1490/problem/A
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 93ms https://codeforces.com/contest/1490/submission/107962626
const solve = (n, a) => {
    // pr(n, a);
    let res = 0;
    for (let i = 0; i + 1 < n; i++) {
        let min = mi(a[i], a[i + 1]);
        let max = mx(a[i], a[i + 1]);
        while (max > min && max / min > 2) {
            max = Math.ceil(max / 2);
            res++;
        }
    }
    pr(res);
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
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()