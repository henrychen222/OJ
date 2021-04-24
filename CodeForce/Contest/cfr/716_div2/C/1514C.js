/**
 * 04/19/21 morning
 * https://codeforces.com/contest/1514/problem/C
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

// let memo, a, n, res;
// const solve = (num) => {
//     pr(num)
//     a = [];
//     for (let x = 1; x <= num - 1; x++) a.push(x);
//     pr(a);
//     memo = new Map();
//     n = num - 1;
//     for (let i = 0; i < n; i++) {
//         dfs(1, i, i);
//     }
//     pr(res);
// };

// const dfs = (p, i, j) => {
//     pr(p, i, j)
//     if (j >= n) return;
//     pr(p, i, j)
//     if (p % n == 1) {
//         pr(p, i, j)
//         pr(a.slice(i, j + 1))
//         res.push(a.slice(i, j + 1));
//     }
//     p *= a[j];
//     dfs(a, i, j + 1);
// };


// TLE
const solve = (num) => {
    // pr(num)
    a = [];
    for (let x = 1; x <= num - 1; x++) a.push(x);
    let n = num - 1;
    let N = 2 ** n;
    let maxLen = 0;
    let res = new Map();
    for (let i = 0; i < N; i++) {
        let data = [];
        for (let j = 0; j < n; j++) {
            if (i & (1 << j)) {
                data.push(a[j]);
            }
        }
        // pr(data);
        let p = 1n;
        for (const e of data) {
            p *= BigInt(e);
        }
        if (p % BigInt(num) == 1) {
            maxLen = mx(maxLen, data.length);
            res.set(maxLen, data);
        }
    }
    pr(maxLen);
    pr(res.get(maxLen).join(" "));
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(Number(line));
    });
};

main()