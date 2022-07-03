///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
const lge = Math.log;
const lg10 = Math.log10;
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);
const lcm = (a, b) => (a / gcd(a, b)) * b;
const amax = (a) => mx.apply(Math, a);
const amin = (a) => mi.apply(Math, a);
const sm = (a) => a.reduce(((x, y) => x + y), 0);
const aeq = (a, b) => JSON.stringify(a) == JSON.stringify(b);
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const stin = (a) => a.sort((x, y) => x - y);
const stde = (a) => a.sort((x, y) => y - x);
const counter = (a_or_s) => { let map = new Map(); for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1); return map; };
const initialize2DArrayNew = (m, n) => { let data = []; for (let i = 0; i < m; i++) { let tmp = new Array(n).fill(Number.MAX_SAFE_INTEGER); data.push(tmp); } return data; };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 05/15/21 night
 * https://codeforces.com/contest/1525/problem/D
 */

// Accepted --- 592ms
const solve = (n, a) => {
    let dp = initialize2DArrayNew(n + 1, n + 1);
    let x = [];
    let y = [];
    for (let i = 0; i < n; i++) a[i] == 1 ? x.push(i) : y.push(i);
    // pr(x);
    // pr(y);
    let xn = x.length;
    let yn = y.length;
    // pr(xn, yn);
    dp[0][0] = 0;
    for (let i = 0; i < xn + 1; i++) {
        for (let j = 0; j < yn + 1; j++) {
            dp[i][j + 1] = mi(dp[i][j + 1], dp[i][j]);
            // pr(dp[i][j+1])
            if (i < xn && j < yn) {
                dp[i + 1][j + 1] = mi(dp[i + 1][j + 1], dp[i][j] + abs(x[i] - y[j]));
            }
        }
    }
    pr(dp[xn][yn]);
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
        solve(input[0][0], input[1]);
    });
};

main()