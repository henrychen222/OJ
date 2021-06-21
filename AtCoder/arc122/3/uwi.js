///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const assert = (condition) => { if (!condition) throw new Error("Assertion failed"); }
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
const lg2 = Math.log2;
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
const aeq = (a, b) => a.length === b.length && a.every((v, i) => v === b[i]);
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const stin = (a) => a.sort((x, y) => x - y);
const stde = (a) => a.sort((x, y) => y - x);
const sortPart = (a, k) => { let l = a.slice(0, k); l.sort((x, y) => x - y); let r = a.slice(k); return l.concat(r); }; // sort first kth
const initialize2DArrayNew = (n, m) => { let data = []; for (let i = 0; i < n; i++) { let tmp = Array(m).fill(0); data.push(tmp); } return data; };
const initialize3DArray = (n, m, p) => { let res = []; for (let i = 0; i < n; i++) { let data = []; for (let j = 0; j < m; j++) { let tmp = new Array(p).fill(0); data.push(tmp); } res.push(data); } return res; };
const stmkey_in = (m) => new Map([...m].sort((x, y) => x[0] - y[0]));
const stmkey_de = (m) => new Map([...m].sort((x, y) => y[0] - x[0]));
const stmvalue_in = (m) => new Map([...m].sort((x, y) => x[1] - y[1]));
const stmvalue_de = (m) => new Map([...m].sort((x, y) => y[1] - x[1]));
const counter = (a_or_s) => { let map = new Map(); for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1); return map; };
const counter_value_in_indexA_in = (a_or_s) => { let m = new Map(); let n = a_or_s.length; for (let i = 0; i < n; i++) { if (!m.has(a_or_s[i])) m.set(a_or_s[i], []); m.get(a_or_s[i]).push(i); } return m; };
const counter_value_in_indexA_de = (a_or_s) => { let m = new Map(); let n = a_or_s.length; for (let i = 0; i < n; i++) { if (!m.has(a_or_s[i])) m.set(a_or_s[i], []); m.get(a_or_s[i]).unshift(i); } return m; };
const reverse2 = (s) => { let res = ""; for (let i = s.length - 1; i >= 0; i--) { res += s[i]; } return res; };
const isPalindrome = (s) => { let n = s.length; let i = 0; let j = n - 1; while (i < j) { if (s[i++] != s[j--]) return false; } return true; };
const ups = (s, i, c) => s.slice(0, i) + c + s.slice(i + 1);
const isSubsequence = (s, t) => { let sn = s.length; let tn = t.length; let i = j = 0; while (i < sn && j < tn) { if (s[i] == t[j]) { i++; j++; } else { i++; } } return j == tn; };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 06/21/21 noon
// Accepted --- https://atcoder.jp/contests/arc122/submissions/23671231 258ms
const solve = (n) => {
    let f = Array(86).fill(0n);
    f[0] = 1n;
    f[1] = 2n;
    for (let i = 2; i < 86; i++) f[i] = f[i - 2] + f[i - 1];
    let digit = Array(86).fill(0n);
    let base = -1;
    for (let i = 85; ~i; i--) {
        if (n >= f[i]) {
            n -= f[i];
            digit[i] = 1n;
            if (base == -1) base = i;
        }
    }
    // pr(base, f, digit)
    assert(n == 0);
    let route = [];
    for (let i = 0; i <= base; i++) {
        if (digit[base - i] == 1) route.push(i & 1 ? 2n : 1n);
        route.push(i & 1 ? 3n : 4n);
    }
    // pr("r", route)
    if (route[route.length - 1] == 4) {
        for (let i = 0; i < route.length; i++) {
            let cur = route.shift();
            if (cur == 1) {
                cur = 2n;
            } else if (cur == 2) {
                cur = 1n;
            } else if (cur == 4) {
                cur = 3n;
            } else {
                cur = 4n;
            }
            route.push(cur);
        }
    }
    // pr(route)
    pr(route.length);
    for (const e of route) pr(e.toString());
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(ll(line));
    });
};

main()