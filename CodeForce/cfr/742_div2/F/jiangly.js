///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const prt = (x) => process.stdout.write(x + " ")
const assert = (condition) => { if (!condition) throw new Error("Assertion failed"); }
const mi = Math.min;
const mx = Math.max;
const mxll = (...args) => args.reduce((m, e) => e > m ? e : m);
const mill = (...args) => args.reduce((m, e) => e < m ? e : m);
const sqll = (v) => { if (v < 0n) throw 'negative input'; if (v < 2n) return v; const dfs = (n, x0) => { let x1 = ((n / x0) + x0) >> 1n; if (x0 === x1 || x0 === (x1 - 1n)) return x0; return dfs(n, x1); }; return dfs(v, 1n); }; // has >> 0
const abs = Math.abs;
const fl = Math.floor;
const int = parseInt;
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
const initializeGraph = (n) => { let G = []; for (let i = 0; i < n; i++) { G.push([]); } return G; };
const addEdgeToG = (G, Edges) => { for (const [x, y] of Edges) { G[x].push(y); G[y].push(x); } };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 09/05/21 evening
 * https://codeforces.com/contest/1567/problem/F
 */

// Accepted --- 343ms https://codeforces.com/contest/1567/submission/128015263
const dir = [[0, -1], [-1, 0], [0, 1], [1, 0]];
const solve = (n, m, g) => {
    // pr(n, m)
    // pr(g)
    let adj = initializeGraph(n * m);
    pr(adj);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (g[i][j] == 'X') {
                let q = [];
                for (const [dx, dy] of dir) {
                    let x = i + dx, y = j + dy;
                    // pr("ijxy", i, j, x, y)
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    // pr("xy", x, y)
                    if (g[x][y] == '.') {
                        q.push(x * m + y);
                    }
                }
                if (q.length & 1) return pr('NO');
                for (let k = 0; k < q.length; k += 2) {
                    adj[q[k]].push(q[k + 1]);
                    adj[q[k + 1]].push(q[k]);
                    pr(adj);
                }
            }
        }
    }
    pr(adj)
    let res = initialize2DArrayNew(n, m);
    let que = [];
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (res[i][j] > 0 || g[i][j] == 'X') continue;
            res[i][j] = 1;
            que.push(i * m + j);
            while (que.length) {
                let cur = que.shift();
                for (const v of adj[cur]) {
                    pr(v);
                    let d = int(v / m);
                    if (res[d][v % m] == 0) {
                        res[d][v % m] = res[int(cur / m)][cur % m] ^ 5;
                        que.push(v);
                    }
                }
            }
        }
    }
    pr('YES');
    // pr(res);
    for (let i = 0; i < n; i++) {
        let data = [];
        for (let j = 0; j < m; j++) {
            if (g[i][j] == 'X') {
                for (const [dx, dy] of dir) {
                    let x = i + dx, y = j + dy;
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    if (g[x][y] == '.') {
                        res[i][j] += res[x][y];
                    }
                }
            }
            data.push(res[i][j]);
            // j == m - 1 ? pr(res[i][j]) : prt(res[i][j])
        }
        pr(data.join(" "))
    }
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    // rl.on('line', (line) => {
    //     input.push(line.split(" "));
    // });
    // rl.on('close', () => {
    //     let a = input.shift();
    //     // solve(a[0] - '0', a[2] - '0', input); // wrong of m
    //     solve(a[0] - '0', a.slice(2).join("") - '0', input); // wrong n 
    // });
    rl.on('line', (line) => {
        input.push(line);
    });
    rl.on('close', () => {
        let a = input.shift().split(" ");
        input = input.map(s => s.split(""))
        solve(a[0] - '0', a[1] - '0', input);
    });
};

main()