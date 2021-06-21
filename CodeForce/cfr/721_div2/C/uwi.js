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
 * 05/20/21 afternoon
 */

// Accepted --- 826ms https://codeforces.com/contest/1527/submission/116860250
const solve = (n, a) => {
    let res = 0n;
    let m = new Map();
    for (let i = 0; i < n; i++) {
        res += BigInt(m.get(a[i]) || 0) * BigInt((n - i));
        let plus = BigInt(i + 1);
        m.set(a[i], BigInt(m.get(a[i]) || 0) + plus);
    }
    pr(res.toString());
};

// Accepted --- 888ms https://codeforces.com/contest/1527/submission/116859919
const solve1 = (n, a) => {
    // pr(n, a)
    let res = 0n;
    let m = new Map();
    for (let i = 0n; i < n; i++) {
        res += (m.get(a[i]) || 0n) * (n - i);
        // pr(m, res);
        let plus = i + 1n;
        m.set(a[i], (m.get(a[i]) || 0n) + plus);
        // pr(m);
    }
    pr(res.toString());
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        // input.push(line.split(" ").map(x => BigInt(x)));
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