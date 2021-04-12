/**
 * 04/10/21 morning
 * https://codeforces.com/contest/1512/problem/B
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- https://codeforces.com/contest/1512/submission/112578017
// code is all correct, so dumb, make t wrong again
const solve = (n, a) => {
    // pr(n, a);
    let res = [];
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (a[i][j] == '*') {
                res.push([i, j]);
            }
        }
    }
    let f = res[0];
    let s = res[1];
    let fx = f[0];
    let fy = f[1];
    let sx = s[0];
    let sy = s[1];
    // pr(f, s);
    if (fx == sx) {
        if (fx == 0) {
            a[fx + 1][fy] = '*';
            a[sx + 1][sy] = '*';
        } else {
            a[fx - 1][fy] = '*';
            a[sx - 1][sy] = '*';
        }
    } else if (fy == sy) {
        if (fy == 0) {
            a[fx][fy + 1] = '*';
            a[sx][sy + 1] = '*';
        } else {
            a[fx][fy - 1] = '*';
            a[sx][sy - 1] = '*';
        }
    } else {
        a[fx][fy] = '*';
        a[fx][sy] = '*';
        a[sx][fy] = '*';
        a[sx][sy] = '*';
    }
    // pr(a);
    let ans = a.map(x => x.join(""));
    // pr(ans);
    for (const e of ans) pr(e);
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
        // let t = Number(input[0][0]); // stupid mistake again
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            let n = Number(input[i]);
            let tmp = input.slice(i + 1, i + n + 1);
            tmp = tmp.map(s => s.split(""));
            solve(n, tmp);
            i += n + 1;
        }
    });
};

main()