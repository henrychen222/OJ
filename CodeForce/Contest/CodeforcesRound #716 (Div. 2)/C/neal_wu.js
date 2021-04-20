// 04/19/21 afternoon

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const err = console.error;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);
const lcm = (a, b) => (a / gcd(a, b)) * b;
const powmod = (a, b, mod) => {
    let r = 1n;
    while (b > 0n) {
        if (b % 2n == 1) r = r * a % mod;
        b >>= 1n;
        a = a * a % mod;
    }
    return r; // return BigInt
};
const combination = (m, n) => {
    return factorial(m, n) / factorial(n, n); // return BigInt
};
const factorial = (m, n) => {
    let num = 1n;
    let cnt = 0;
    for (let i = BigInt(m); i > 0; i--) {
        if (cnt == n) break;
        num *= i;
        cnt++;
    }
    return num;
};
const arrayEqual = (a, b) => JSON.stringify(a) == JSON.stringify(b);
const counter = (a_or_s) => {
    let map = new Map();
    for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1);
    return map;
};
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 109ms https://codeforces.com/contest/1514/submission/113555763
const solve = (num) => {
    res = [];
    let p = 1;
    let last = num - 1;
    for (let x = 1; x < last; x++) {
        if (gcd(num, x) == 1) {
            p = p * x % num;
            res.push(x);
        }
    }
    if (p == last) res.push(last);
    pr(res.length);
    pr(res.join(" "));
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