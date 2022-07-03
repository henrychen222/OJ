/**
 * 12.11 afternoon
 * https://codeforces.com/contest/1461/problem/C
 * 
 * heyshb use the same logic
 */

// Accepted --- 265ms https://codeforces.com/contest/1461/submission/100975142
const solve = (n, m, p, e) => {
    let last = n + 1;
    for (let i = 1; i <= n; i++) {
        if (p[i - 1] != i) last = i;
    }
    let res = gop = 1;
    if (last == n + 1) gop = 0;
    for (let i = 1; i <= m; i++) {
        if (last <= e[i - 1][0]) {
            gop *= (1 - e[i - 1][1]);
        }
    }
    console.log(res - gop);
};

// Accepted --- 249ms https://codeforces.com/contest/1461/submission/100975222
const solve_modify = (n, m, p, e) => {
    let last = n + 1;
    for (let i = 0; i < n; i++) {
        if (p[i] != i + 1) last = i + 1;
    }
    let res = gop = 1;
    if (last == n + 1) gop = 0;
    for (let i = 0; i < m; i++) {
        if (last <= e[i][0]) {
            gop *= (1 - e[i][1]);
        }
    }
    console.log(res - gop);
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
        let t = input[0][0];
        let i = 1;
        while (t--) {
            let n = input[i][0];
            let m = input[i][1];
            let p = input[i + 1];
            let experiment = input.slice(i + 2, i + m + 2);
            solve(n, m, p, experiment);
            i += m + 2;
        }
    });
};

main()