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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 05/26/21 night
// issue
const solve = (x, w, e) => {
    pr(x, w, e);
    let dp = initialize3DArray(62, 62, 62);
    for (let i = 0; i <= 60; i++) {
        for (let j = 0; i + j <= 60; j++) {
            dp[i][j][60 - i - j] = new pair(0, -1);
        }
    }
    for (let a = 60; a >= 0; --a) {
        for (let b = 60 - a; b >= 0; --b) {
            for (let c = 60 - a - b - 1; c >= 0; --c) {
                dp[a][b][c] = new pair(-1, -1);
                // compute dp[a][b][c]
                let p_a = 1 / 3;
                let p_b = 1 / 3;
                let p_c = 1 / 3;
                if (a + b + c != 0) {
                    p_a = b / (a + b + c);
                    p_b = c / (a + b + c);
                    p_c = a / (a + b + c);
                }
                // move a
                let tmp = dp[a + 1][b][c].first + p_a * e + p_b * w;
                // pr(a, b, c, dp[a][b][c], dp[a][b][c].first, dp[a][b][c].second)
                let updateaf = mx(dp[a][b][c].first, tmp);
                dp[a][b][c] = new pair(updateaf, mx(dp[a][b][c].second, 0)); // issue


                // move b
                tmp = dp[a][b + 1][c].first + p_b * e + p_c * w;
                let updatebf = mx(dp[a][b][c].first, tmp);
                dp[a][b][c] = new pair(updatebf, mx(dp[a][b][c].second, 1));

                // move c
                tmp = dp[a][b][c + 1].first + p_c * e + p_a * w;
                let updatecf = mx(dp[a][b][c].first, tmp);
                dp[a][b][c] = new pair(updatecf,  mx(dp[a][b][c].second, 2));
            }
        }
    }

    // for (let i = 60; ~i; i--) {
    //     for (let j = 60 - i; ~j; j--) {
    //         for (let k = 60 - i - j - 1; ~k; k--) {
    //             dp[i][j][k] = new pair(-1, -1);
    //             let [pi, pj, pk] = [1 / 3, 1 / 3, 1 / 3];
    //             if (i + j + k != 0) {
    //                 pi = j / (i + j + k);
    //                 pj = k / (i + j + k);
    //                 pk = i / (i + j + k);
    //             }
    //             // pr(pi, pj, pk);

    //             // move i
    //             let tmp = (dp[i + 1][j][k].first || 0) + pi * e + pj * w;
    //             // pr(tmp)
    //             dp[i][j][k] = mx(dp[i][j][k], new pair(tmp, 0));
    //             pr(dp[i][j][k], dp[i][j][k].first, dp[i][j][k].second)

    //             // move j
    //             tmp = (dp[i][j + 1][k].first || 0) + pj * e + pk * w;
    //             dp[i][j][k] = mx(dp[i][j][k], new pair(tmp, 1));

    //             // move k
    //             tmp = (dp[i][j][k + 1].first || 0) + pk * e + pi * w;
    //             dp[i][j][k] = mx(dp[i][j][k], new pair(tmp, 2));
    //         }
    //     }
    // }

    let res = '';
    let i = j = k = 0;
    while (i + j + k < 60) {
        let m = dp[i][j][k].second;
        pr(dp[i][j][k])
        // pr(m);  // m is wrong always 2
        if (m == 0) {
            i++;
        } else if (m == 1) {
            j++;
        } else {
            k++;
        }
        let s = 'RSP';
        res += s[m];
    }
    return res;
};

function pair(f, s) {
    this.first = f;
    this.second = s;
}

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
        let we = input.slice(2);
        let x = input[1][0];
        for (let cas = 1; cas <= t; cas++) {
            let show = solve(x, we[cas - 1][0], we[cas - 1][1]);
            pr('Case #' + cas + ': ' + show);
        }
    });
};

main()