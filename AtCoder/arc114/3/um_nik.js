/**
 * 03/14/21 afternoon
 * https://atcoder.jp/contests/arc114/submissions?f.User=Um_nik
 */

//////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// still TLE, use Java Accepted https://atcoder.jp/contests/arc114/submissions/20953012
const MOD = 998244353;
const MAX = 5001;
const solve = (n, m) => {
    let dp = initialize2DArrayNew(MAX, MAX);
    for (let x = 0; x < MAX; x++) {
        dp[x][0] = 1;
        for (let i = 1; i < MAX; i++) dp[x][i] = multi(dp[x][i - 1], x);
    }
    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let x = 1; x <= m; x++) {
            res = add(res, multi(dp[m - x][i], dp[m][n - 1 - i]));
            // pr(res);
        }
    }
    for (let d = 1; d < n; d++) {
        for (let x = 1; x <= m; x++) {
            res = add(res, multi(multi(n - d, x - 1), multi(dp[m - x][d - 1], dp[m][n - 1 - d])));
        }
    }
    pr(res);
};

const add = (x, y) => {
    x += y;
    if (x >= MOD) return x - MOD;
    return x;
};

const BMOD = 998244353n;
const SAFE = Number.MAX_SAFE_INTEGER;
const multi = (x, y) => { // issue here: number overflow if not use BigInt, BigInt will cause TLE
    let m = x * y;
    if (m <= SAFE) return x * y % MOD;
    return Number(BigInt(x) * BigInt(y) % BMOD);
};

const initialize2DArrayNew = (m, n) => {
    let data = [];
    for (let i = 0; i < m; i++) {
        let tmp = new Array(n).fill(0n);
        data.push(tmp);
    }
    return data;
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