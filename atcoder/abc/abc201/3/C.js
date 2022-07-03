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
 * 05/15/21 morning
 * https://atcoder.jp/contests/abc201/tasks/abc201_c
 */
// Accepted
const d = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
const solve = (s) => {
    let sn = s.length;
    let yes = new Set();
    let no = new Set();
    let notSure = new Set();
    for (let i = 0; i < sn; i++) {
        if (s[i] == 'o') {
            yes.add(i);
        } else if (s[i] == 'x') {
            no.add(i);
        } else {
            notSure.add(i);
        }
    }
    // pr(yes, no, notSure);
    let canUse = d.filter(x => !no.has(x));
    // pr(canUse)
    let res = 0;
    let n = canUse.length;
    for (const a of canUse) {
        for (const b of canUse) {
            for (const c of canUse) {
                for (const d of canUse) {
                    let tmp = '' + a + b + c + d;
                    if (ok(tmp, yes)) res++;
                    // pr(tmp, tmp.length)
                }
            }
        }
    }
    pr(res);
};

const ok = (s, must) => {
    for (const e of must) {
        if (s.indexOf(e) == -1) return false;
    }
    return true;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(line);
    });
};

main()


// pr(ok('1202', new Set([0, 1, 2])))


// let sure = yes.size;
// let allow = 10 - no.size;
// let rest = allow - sure;
// let plus = combination(allow, 4 - sure);
// pr(plus, factorial())
// let f = factorial(4, 4);
// if (sure == 0) {
//     pr(10 * 9 * 8 * 7 * f, 0)
// } else if (sure == 1) {
//     pr(9 * 8 * 7 * f, 1);
// } else if (sure == 2) {
//     pr(8 * 7 * f, 2);
// } else if (sure == 3) {
//     pr(factorial(3, 4) + plus)
//     // pr(7 * f, 3);
// } else if (sure == 4) {
//     pr(f, 4);
// }
// pr(0);

// const combination = (m, n) => {
//     return factorial(m, n) / factorial(n, n);
// };

// const factorial = (m, n) => {
//     let num = 1;
//     let cnt = 0;
//     for (let i = m; i > 0; i--) {
//         if (cnt == n) break;
//         num *= i;
//         cnt++;
//     }
//     return num;
// };