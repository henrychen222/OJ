/**
 * 02/19/21
 * https://atcoder.jp/contests/abc190/submissions?f.User=uwi
 * https://atcoder.jp/contests/abc190/submissions/19795280
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 1197ms https://atcoder.jp/contests/abc190/submissions/20271888
const solve = (n, a) => {
    // pr(n, a);
    let base = 0;
    let ft = Array(n + 3).fill(0);
    // pr(ft);
    for (let i = n - 1; ~i; i--) {
        base += query(ft, a[i]);
        update(ft, a[i], 1);
    }
    // pr(ft);
    pr(base);
    for (let i = 0; i < n - 1; i++) {
        base -= a[i];
        base += n - 1 - a[i];
        pr(base);
    }
};

const query = (ft, i) => {
    let sum = 0;
    i++;
    while (i > 0) {
        sum += ft[i];
        i -= i & -i;
    }
    return sum;
};

const update = (ft, i, v) => {
    if (v == 0 || i < 0) return;
    i++;
    while (i < ft.length) {
        ft[i] += v;
        i += i & -i;
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
        input.push(line.split(" ").map(x => Number(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input[1]);
    });
};

main()