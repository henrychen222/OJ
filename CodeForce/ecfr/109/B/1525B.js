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
 * 05/15/21 night
 * https://codeforces.com/contest/1525/problem/B
 */

// TLE
const solve = (n, a) => {
    let sa = [...a];
    stin(sa);
    // pr(sa);
    // pr(n, a)
    let res = 0;
    if (isAscending(a)) return pr(res);
    while (!isAscending(a)) {
        // for (let i = n - 1; ~i; i--) {
        for (let i = 0; i < n; i++) {
            let should = i + 1;
            if (a[i] != should) {
                let idx = sa[a[i] - 1];
                let l = a.slice(0, idx);
                let r = a.slice(idx);
                // let l = a.slice(0, i + 1);
                // let r = a.slice(i + 1);
                if (l.length == n || r.length == n) continue;
                let ol = [...l];
                let or = [...r];
                // pr(l, r)
                stin(l);
                stin(r);
                if (!aeq(l, ol)) res++;
                if (!aeq(r, or)) res++;
                a = l.concat(r);
                // break;
            }
        }
        
    }
    pr(res);
};

const isAscending = (arr) => {
    return arr.every((x, i) => {
        return i === 0 || x > arr[i - 1];
    });
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
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()