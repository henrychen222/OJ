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
 * 05/20/21 morning
 * https://codeforces.com/contest/1527/problem/A
 */
// Pretests passed
let d = [1, 0];
// const MAX = 10 ** 9;
const solve = () => {
    // let x;
    // for (x = MAX; x > 0; x--) {
    //     let t = x;
    //     t &= (t - 1);
    //     if (t == 0) {
    //         d.push(x - 1);
    //     }
    // }
    for (let i = 2; 2 ** i <= 536870912; i++) {
        d.unshift(2 ** i - 1);
    }
    // pr(d);
};

const go = (x) => {
    let n = d.length;
    for (let i = 0; i < n; i++) {
        if (x > d[i]) return pr(d[i]);
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
        input.push(Number(line));
    });
    rl.on('close', () => {
        solve();
        let t = input[0];
        let i = 1;
        while (t--) {
            go(input[i]);
            i++;
        }
    });
};

main()


// const solve = (n) => {
//     if (n == 1) return pr(0);
//     pr(n & 1 ? n - 2 : n - 1)
// };