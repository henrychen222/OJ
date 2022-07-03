/**
 * 02/19/21
 * https://atcoder.jp/contests/abc190/submissions?f.User=uwi
 * https://atcoder.jp/contests/abc190/submissions/19793167
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 1185ms https://atcoder.jp/contests/abc190/submissions/20270717
let upper, n;
const MAX = Number.MAX_SAFE_INTEGER;
const solve = (N, m, ab, k, c) => {
    // pr(N, m, ab, k, c);
    n = N;
    ab = ab.map(x => [x[0] - 1, x[1] - 1]);
    c = c.map(x => x - 1);
    // pr(n, m, ab, k, c);
    upper = Array(n).fill(-1);
    for (const e of ab) {
        union(e[0], e[1]);
    }
    for (const v of c) {
        if (!equiv(c[0], v)) return pr(-1);
    }
    let G = initializeGraph();
    // pr(G);
    for (const e of ab) {
        G[e[0]].push(e[1]);
        G[e[1]].push(e[0]);
    }
    // pr(G);
    let dists = [];
    for (const v of c) {
        dists.push(dijkstra(G, v));
    }
    // pr(dists);
    let dp = initialize2DArrayNew(1 << k, k);
    // pr(dp);
    for (let i = 0; i < 1 << k; i++) {
        for (let j = 0; j < k; j++) {
            if (i == 1 << j) {
                dp[i][j] = 1;
            } else if (i >> j & 1) {
                for (let t = 0; t < k; t++) {
                    if ((i >> t & 1) && j != t) {
                        dp[i][j] = mi(dp[i][j], dp[i ^ 1 << j][t] + dists[t][c[j]]);
                    }
                }
            }
        }
    }
    // pr(dp);
    pr(mi.apply(Math, dp[(1 << k) - 1]));
};

const initializeGraph = () => {
    // let G = Array(n).fill([]); // wrong, have issue
    let G = [];
    for (let i = 0; i < n; i++) {
        G.push([]);
    }
    return G;
};

const union = (x, y) => {
    x = find(x);
    y = find(y);
    if (x != y) {
        if (upper[y] < upper[x]) [x, y] = [y, x];
        upper[x] += upper[y];
        upper[y] = x;
    }
    return x == y;
};

const find = (x) => {
    if (upper[x] < 0) {
        return x;
    } else {
        upper[x] = find(upper[x]);
        return upper[x];
    }
};

const equiv = (x, y) => {
    return find(x) == find(y);
};

const dijkstra = (G, src) => { // read: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
    let q = [src];
    let dist = Array(n).fill(MAX);
    dist[src] = 0;
    for (let i = 0; i < q.length; i++) {
        let cur = q[i];
        for (const e of G[cur]) {
            if (dist[e] > dist[cur] + 1) {
                dist[e] = dist[cur] + 1;
                q.push(e);
            }
        }
    }
    return dist;
};

const initialize2DArrayNew = (m, n) => {
    let data = [];
    for (let i = 0; i < m; i++) {
        let tmp = new Array(n).fill(MAX);
        data.push(tmp);
    }
    return data;
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
        let n = input[0][0];
        let m = input[0][1];
        solve(n, m, input.slice(1, 1 + m), input[1 + m][0], input[m + 2]);
    });
};

main()


// // let G = [[], [], [], []];
// let G = [];
// for (let i = 0; i < 4; i++) {
//     G.push([]);
// }
// // let G = Array(4).fill([]);
// let es = [[0, 3], [1, 3], [2, 3]];
// for (const e of es) {
//     G[e[0]].push(e[1]);
//     G[e[1]].push(e[0]);
// }
// console.log(G); // [[3], [3], [3], [0, 1, 2]]