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

// not correct
const solve = (n, s, t) => {
    minSwap(n, s, t);
};

/**
 * https://www.geeksforgeeks.org/minimum-number-of-swaps-to-make-two-binary-string-equal/
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */
const minSwap = (n, s1, s2) => {
    let c0 = c1 = 0;
    for (let i = 0; i < n; i++) {
        if (s1[i] == '0' && s2[i] == '1') {
            c0++;
        } else if (s1[i] == '1' && s2[i] == '0') {
            c1++;
        }
    }
    let ans = (c0 / 2 >> 0) + (c1 / 2 >> 0);
    if (c0 % 2 == 0 && c1 % 2 == 0) {
        pr(ans)
    } else if ((c0 + c1) % 2 == 0) {
        pr(ans + 2)
    } else {
        pr(-1)
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