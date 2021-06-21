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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 05/22/21 morning
 * https://atcoder.jp/contests/abc202/tasks/abc202_c
 */

// After contest Accepted --- https://atcoder.jp/contests/abc202/submissions/22838354 160ms
const solve = (n, a, b, c) => {
    let res = 0;
    let ma = counter(a);
    let mc = counter(c);
    for (const [vc, fc] of mc) {
        if (ma.has(b[vc - 1])) {
            res += ma.get(b[vc - 1]) * fc;
        }
    }
    pr(res);
};

// TLE
const solve2 = (n, a, b, c) => {
    // pr(n, a, b, c);
    let res = 0;
    let ma = counter(a);
    let mb = counter(b);
    let mc = counter(c);
    // pr(ma, mb, mc);
    for (const [va, fa] of ma) {
        for (const [vc, fc] of mc) {
            if (va == b[vc - 1]) {
                // pr(va);
                res += fa * fc;
            }
        }
    }
    pr(res);
};

// TLE
const solve1 = (n, a, b, c) => {
    // pr(n, a, b, c);
    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (a[i] == b[c[j] - 1]) {
                res++;
            }
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
        solve(input[0][0], input[1], input[2], input[3]);
    });
};

main()