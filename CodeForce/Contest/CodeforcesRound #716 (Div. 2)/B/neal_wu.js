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
/**
 * Accepted --- 62ms 
 * https://codeforces.com/contest/1514/submission/113552302
 * https://codeforces.com/contest/1514/submission/113552000
 */
const MOD = BigInt(1e9 + 7);
const solve = (n, k) => {
    pr(powmod(n, k, MOD).toString());
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => BigInt(x)));
    });
    rl.on('close', () => {
        let t = input[0][0];
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i][1]);
            i++;
        }
    });
};

main()