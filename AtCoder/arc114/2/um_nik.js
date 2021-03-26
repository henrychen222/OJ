/**
 * 03/14/21 afternoon
 * https://atcoder.jp/contests/arc114/submissions?f.User=Um_nik
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 152ms https://atcoder.jp/contests/arc114/submissions/20952364
const MOD = 998244353;
const solve = (n, a) => {
    a = a.map(x => x - 1);
    let used = Array(n).fill(0);
    let res = 1;
    for (let i = 0; i < n; i++) {
        if (used[i]) continue;
        let x = i;
        while (used[x] == 0) {
            used[x] = 1;
            x = a[x];
        }
        if (used[x] == 1) res = add(res, res);
        x = i;
        while (used[x] == 1) {
            used[x] = 2;
            x = a[x];
        }
    }
    res = minus(res, 1);
    pr(res);
};

const add = (x, y) => {
    x += y;
    if (x >= MOD) return x - MOD;
    return x;
};

const minus = (x, y) => {
    x -= y;
    if (x < 0) return x + MOD;
    return x;
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