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
 * 04/21/20 morning
 * https://codeforces.com/contest/1516/problem/0
 */
// const solve = (n, k, a) => {
//     pr(n, k, a)
//     let sm = sum(a);
//     sm -= a[n - 1];
//     pr("sum", sm, k)
//     if (sm > k) {
//         pr(a);
//         // while(n)
//     } else if (sm == k) {
//         let res = Array(n).fill(0);
//         res[n - 1] += k;
//         pr(res, k);
//     } else {
//         let res = Array(n - 1).fill(0);
//         // k -= sm;
//         pr("k", k);
//         res.push(k - sm);
//         if (k & 1) {
//             pr("res", res);
//             // swap(res, n - 1, n - 2);
//             res[n - 2]++;
//             res[n - 1]--;
//             pr(res);
//         } else {
//             pr(res);
//         }
//     }
//     // while (k > 0) {
//     //     for (let i = 0, j = n - 1; i < n; i++) {
//     //         if (a[i] - k < 0) {
//     //             a[i] = 0;
//     //             k -= a[i];
//     //             a[j] -= a[i];
//     //         } else {
//     //             a[i] -= k;
//     //             a[j] -= k;
//     //         }
//     //     }
//     // }
// };

// evening uwi
const solve = (n, k, a) => {
    let res = [...a];
    for (let i = 0; i < n - 1; i++) {
        let tmp = mi(a[i], k);
        res[i] -= tmp;
        res[n - 1] += tmp;
        k -= tmp;
    }
    pr(res.join(" "));
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
        let t = input[0][0];
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i][1], input[i + 1]);
            i += 2;
        }
    });
};

main()