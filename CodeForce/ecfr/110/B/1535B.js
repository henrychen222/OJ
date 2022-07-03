///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const mxll = (...args) => args.reduce((m, e) => e > m ? e : m);
const mill = (...args) => args.reduce((m, e) => e < m ? e : m);
const sqll = (v) => { if (v < 0n) throw 'negative input'; if (v < 2n) return v; const dfs = (n, x0) => { let x1 = ((n / x0) + x0) >> 1n; if (x0 === x1 || x0 === (x1 - 1n)) return x0; return dfs(n, x1); }; return dfs(v, 1n); }; // has >> 0
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
const lge = Math.log;
const lg10 = Math.log10;
const ll = BigInt;
const combination = (m, n) => { return factorial(m, n) / factorial(n, n); };
const factorial = (m, n) => { let num = 1n; let cnt = 0; for (let i = ll(m); i > 0; i--) { if (cnt == n) break; num *= i; cnt++; } return num; };
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);
const lcm = (a, b) => (a / gcd(a, b)) * b;
const bitCount = (n) => { n = n - ((n >> 1) & 0x55555555); n = (n & 0x33333333) + ((n >> 2) & 0x33333333); return ((n + (n >> 4) & 0xF0F0F0F) * 0x1010101) >> 24; };
const powmod = (a, b, mod) => { let r = 1n; while (b > 0n) { if (b % 2n == 1) r = r * a % mod; b >>= 1n; a = a * a % mod; } return r; };
const amax = (a) => mx.apply(Math, a);
const amin = (a) => mi.apply(Math, a);
const sm = (a) => a.reduce(((x, y) => x + y), 0);
const aeq = (a, b) => JSON.stringify(a) == JSON.stringify(b);
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const stin = (a) => a.sort((x, y) => x - y);
const stde = (a) => a.sort((x, y) => y - x);
const sortPart = (a, k) => { let l = a.slice(0, k); l.sort((x, y) => x - y); let r = a.slice(k); return l.concat(r); }; // sort first kth
const initialize2DArrayNew = (m, n) => { let data = []; for (let i = 0; i < m; i++) { let tmp = Array(n).fill(0); data.push(tmp); } return data; };
const stmkey_in = (m) => new Map([...m].sort((x, y) => x[0] - y[0]));
const stmkey_de = (m) => new Map([...m].sort((x, y) => y[0] - x[0]));
const stmvalue_in = (m) => new Map([...m].sort((x, y) => x[1] - y[1]));
const stmvalue_de = (m) => new Map([...m].sort((x, y) => y[1] - x[1]));
const counter = (a_or_s) => { let map = new Map(); for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1); return map; };
const counter_value_in_indexA_in = (a_or_s) => { let m = new Map(); let n = a_or_s.length; for (let i = 0; i < n; i++) { if (!m.has(a_or_s[i])) m.set(a_or_s[i], []); m.get(a_or_s[i]).push(i); } return m; };
const counter_value_in_indexA_de = (a_or_s) => { let m = new Map(); let n = a_or_s.length; for (let i = 0; i < n; i++) { if (!m.has(a_or_s[i])) m.set(a_or_s[i], []); m.get(a_or_s[i]).unshift(i); } return m; };
const reverse2 = (s) => { let res = ""; for (let i = s.length - 1; i >= 0; i--) { res += s[i]; } return res; };
const isPalindrome = (s) => { let n = s.length; let i = 0; let j = n - 1; while (i < j) { if (s[i++] != s[j--]) return false; } return true; };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 06/04/21 morning
 * https://codeforces.com/contest/1535/problem/B
 */

// Accepted
const solve = (n, A) => {
    let even = [];
    let odd = [];
    for (const e of A) e & 1 ? odd.push(e) : even.push(e);
    let a = even.concat(odd);
    let res = 0;
    for (let i = 0; i < n; i++) {
        if (a[i] % 2 == 0) {
            res += n - 1 - i;
            continue;
        }
        for (let j = i + 1; j < n; j++) {
            if (gcd(a[i], 2 * a[j]) > 1) {
                res++;
            }
        }
    }
    pr(res);
};

// Wrong
const solve1 = (n, a) => {
    let m = counter(a);
    let even = new Set();
    let odd = new Set();
    for (const e of a) e & 1 ? odd.add(e) : even.add(e);
    let res = 0;
    for (const x of even) {
        for (const y of odd) {
            if (x == y) continue;
            res += m.get(x) * m.get(y);
            pr("pair1", x, y)
        }
    }
    for (const x of even) {
        for (const y of even) {
            if (x == y) continue;
            res += m.get(x) * m.get(y);
            pr("pair2", x, y)
        }
    }
    for (const x of odd) {
        for (const y of odd) {
            if (x == y) continue;
            if ((gcd(x, 2 * y) > 1) || (gcd(2 * x, y) > 1)) {
                pr("pair3", x, y)
                res += m.get(x) * m.get(y);
            }
        }
    }
    pr(res);
    for (const [k, occ] of m) {
        if (occ >= 2) {
            pr("pair4", k, k);
            res += Number(combination(occ, 2));
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
        let t = input[0][0];
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()