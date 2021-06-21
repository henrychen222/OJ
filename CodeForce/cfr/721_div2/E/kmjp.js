///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const mxbi = (...args) => args.reduce((m, e) => e > m ? e : m);
const mibi = (...args) => args.reduce((m, e) => e < m ? e : m);
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
const initialize2DArrayNew = (m, n) => { let data = []; for (let i = 0; i < m; i++) { let tmp = new Array(n).fill(0); data.push(tmp); } return data; };
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const stin = (a) => a.sort((x, y) => x - y);
const stde = (a) => a.sort((x, y) => y - x);
const counter = (a_or_s) => { let map = new Map(); for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1); return map; };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 05/20/21 night
 * https://codeforces.com/contest/1527/problem/E
 */

function SegmentTreeRSQ(n) {
    let tree = Array(2 * n).fill(0n);
    let ma = Array(2 * n).fill(0n);
    return { query, update }

    function query(l, r, tl = 0, tr = n, vi = 1) {
        if (l >= tr || r <= tl) return 0n;
        if (l <= tl && r >= tr) return ma[vi];
        return tree[vi] + mxbi(query(l, r, tl, tl + tr >> 1, vi * 2), query(l, r, tl + tr >> 1, tr, vi * 2 + 1));
    }

    function update(l, r, v, tl = 0, tr = n, vi = 1) {
        if (tl >= tr) return;
        if (l <= tl && r >= tr) {
            tree[vi] += BigInt(v);
            ma[vi] += BigInt(v);
        } else if (l < tr && r > tl) {
            update(l, r, v, tl, tl + tr >> 1, vi * 2);
            update(l, r, v, tl + tr >> 1, tr, vi * 2 + 1);
            ma[vi] = tree[vi] + mxbi(ma[vi * 2], ma[vi * 2 + 1]);
        }
    }
}

// issue
const solve = (n, k, a) => {
    // pr(n, k, a);
    let pre = Array(35001).fill(Number.M);
    let p = Array(35001).fill(0);
    pr(p);
    let dp = initialize2DArrayNew(k + 1, n + 1);
    for (let i = 0; i < n; i++) {
        p[i] = pre[a[i]];
        pre[a[i]] = i;
    }
    pr(p, dp);
    dp[0][0] = 0n;
    for (let i = 0; i < n; i++) {
        dp[0][i + 1] = 1n << 60n;
    }
    for (let i = 1; i <= k; i++) {
        let st = new SegmentTreeRSQ(1 << 16);
        for (let j = 0; j < n; j++) st.update(j, j + 1, dp[i - 1][j]);
        for (let j = 0; j < n; j++) {
            if (p[j] >= 0) st.update(0, p[j] + 1, j - p[j]);
            dp[i][j + 1] = st.query(0, j + 1);
        }
    }
    pr(dp);
    pr(dp[k][n]);
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
        solve(input[0][0], input[0][1], input[1]);
    });
};

main()

// pr(1 << 60, 1n<<60n);

// function query(x, y, l = 0, r = n, k = 1) {
//     if (r <= x || y <= l) return 0n;
//     if (x <= l && r <= y) return ma[k];
//     return val[k] + mxbi(query(x, y, l, (l + r) >> 1, k * 2), query(x, y, (l + r) >> 1, r, k * 2 + 1));
// }

// function update(x, y, v, l = 0, r = n, k = 1) {
//     if (l >= r) return;
//     if (x <= l && r <= y) {
//         val[k] += BigInt(v);
//         ma[k] += BigInt(v);
//     }
//     else if (l < y && x < r) {
//         update(x, y, v, l, (l + r) >> 1, k * 2);
//         update(x, y, v, (l + r) >> 1, r, k * 2 + 1);
//         ma[k] = val[k] + mxbi(ma[k * 2], ma[k * 2 + 1]);
//     }
// }