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
// 06/21/21 morning
// Accepted --- https://atcoder.jp/contests/arc119/submissions/23665541 233ms
const solve = (n, s, t) => {
    let is = [];
    let it = [];
    for (let i = 0; i < n; i++) {
        if (s[i] == '0') is.push(i);
        if (t[i] == '0') it.push(i);
    }
    // pr(is, it)
    if (is.length != it.length) {
        pr(-1);
    } else {
        let res = 0;
        for (let i = 0; i < is.length; i++) {
            if (is[i] != it[i]) res++;
        }
        pr(res);
    }
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line);
    });
    rl.on('close', () => {
        solve(Number(input[0]), input[1], input[2]);
    });
};

main()