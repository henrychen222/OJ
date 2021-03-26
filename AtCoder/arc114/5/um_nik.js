/**
 * 03/15/20 evening
 * https://atcoder.jp/contests/arc114/tasks/arc114_e
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 88ms https://atcoder.jp/contests/arc114/submissions/20974490
const MOD = 998244353;
const N = 200002;
const solve = (h, w, x1, y1, x2, y2) => {
    // pr(h, w, x1, y1, x2, y2)
    let cut = Array(N).fill(1);
    for (let x = 2; x < N; x++) {
        cut[x] = minus(0, multi(MOD / x >> 0, cut[MOD % x]));
    }
    let A = abs(x1 - x2) + abs(y1 - y2);
    let B = [mi(x1, x2) - 1, h - mx(x1, x2), mi(y1, y2) - 1, w - mx(y1, y2)];
    // pr(A, B)
    let res = 1;
    for (let i = 0; i < 4; i++) {
        for (let x = 1; x <= B[i]; x++) {
            res = add(res, cut[A + x]);
        }
    }
    pr(res);
};

const add = (x, y) => {
    x += y;
    if (x >= MOD) return x - MOD;
    return x;
};

const minus = (x, y) => {
    x -= y;
    if (x < 0) return x + MOD;
    return x;
};

// const multi = (x, y) => x * y % MOD;

const BMOD = 998244353n;
const SAFE = Number.MAX_SAFE_INTEGER;
const multi = (x, y) => {
    let m = x * y;
    if (m <= SAFE) return x * y % MOD;
    return Number(BigInt(x) * BigInt(y) % BMOD);
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
        solve(input[0][0], input[0][1], input[1][0], input[1][1], input[1][2], input[1][3]);
    });
};

main()