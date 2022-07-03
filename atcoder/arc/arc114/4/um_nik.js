/**
 * 03/14/21 evening
 * https://atcoder.jp/contests/arc114/submissions?f.User=Um_nik
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const abs = Math.abs;
const MAX = Number.MAX_SAFE_INTEGER;
const N = 5001;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 493ms https://atcoder.jp/contests/arc114/submissions/20953898
const solve = (n, k, a, b) => {
    // pr(n, k, a, b);
    a = sortPart(a, n);
    // pr(a, b);
    for (let i = 0; i < n; i++) b[k++] = a[i];
    // b = b.concat(a); // Also Accepted --- 489ms https://atcoder.jp/contests/arc114/submissions/20954003
    // k += n;
    // pr(a, b);
    b = sortPart(b, k);
    let m = 0;
    // pr(a, b);
    for (let i = 0; i < k; i++) {
        m > 0 && b[m - 1] == b[i] ? m-- : b[m++] = b[i];
    }
    if (m > n) return pr(-1);
    let dp = initialize2DArrayNew(N, N);
    dp[0][0] = 0;
    for (let i = 0; i <= n; i++) {
        for (let j = 0; j <= m; j++) {
            if (dp[i][j] == MAX) continue;
            if (i + 2 <= n) dp[i + 2][j] = mi(dp[i + 2][j], dp[i][j] + abs(a[i + 1] - a[i]));
            if (i < n && j < m) dp[i + 1][j + 1] = mi(dp[i + 1][j + 1], dp[i][j] + abs(a[i] - b[j]));
        }
    }
    pr(dp[n][m]);
}

const sortPart = (a, cnt) => {
    let l = a.slice(0, cnt);
    // l.sort();            // fucking issue here: sort() is wrong, default comparator is not increaing. 
    l.sort((x, y) => x - y);
    let r = a.slice(cnt);
    // pr("l and r: ", l, r)
    return l.concat(r);
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
        solve(input[0][0], input[0][1], input[1], input[2]);
    });
};

main()