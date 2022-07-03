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
 * https://codeforces.com/contest/1535/problem/C
 */

// don't know
const solve = (s) => {
    let n = s.length;
    let a = s.split("");
    let res = 0;
    pr(a);
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            // if (j - i + 1 < 3) continue;
            let tmp = a[j - 1] + a[j];
            if (tmp == '00' || tmp == '11') {
                continue;
            }
            if (all(a.slice(i, j + 1))) {
                pr(s.slice(i, j + 1));
                res++;
            }
        }
    }
    pr(res);
};

const all = (a) => new Set(a).size == 3;

// Wrong
const solve1 = (s) => {
    pr(s);
    let n = s.length;
    let res = new Set();
    for (let i = 0; i + 1 < n; i++) {
        if (s[i] == '?') {
            for (let j = i + 1; j < n; j++) {
                if (s[j] == '?') {
                    res.add(i + ' ' + j);
                } else if (s[j] == '0') {
                    for (let k = j + 1, next = '1'; k < n; k++, next ^= 1) {
                        if (s[k] == '?' || s[k] == next) res.add(i + ' ' + k);
                    }
                } else if (s[j] == '1') {
                    res.add(i + ' ' + j);
                    for (let k = j + 1, next = '0'; k < n; k++, next ^= 1) {
                        if (s[k] == '?' || s[k] == next) res.add(i + ' ' + k);
                    }
                }
            }
        } else if (s[i] == '1') {
            for (let j = i + 1, next = '0'; j < n; j++, next ^= 1) {
                if (s[j] == '?' || s[j] == next) res.add(i + ' ' + j);
            }
        } else {
            for (let j = i + 1, next = '1'; j < n; j++, next ^= 1) {
                if (s[j] == '?' || s[j] == next) res.add(i + ' ' + j);
            }
        }
    }
    pr(res.size, res);
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
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()