// 12.20 evening

// Accepted --- https://codeforces.com/contest/1465/submission/101927984
let MAX = 100005;
let con = 0;
let par = Array(MAX).fill(0);
const parent = (n) => {
    if (par[n] == n) return n;
    return par[n] = parent(par[n]);
};

const join = (a, b) => {
    a = parent(a);
    b = parent(b);
    if (a == b) {
        con++;
        return;
    }
    par[a] = b;
};

const solve = (n, m, a) => {
    con = 0;
    for (let i = 0; i <= n; i++) {
        par[i] = i;
    }
    let req = 0;
    for (let i = 0; i < m; i++) {
        let x = a[i][0];
        let y = a[i][1];
        if (x == y) continue;
        join(x, y);
        req++;
    }
    console.log(req + con);
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
            solve(n, m, input.slice(i + 1, i + m + 1));
            i += m + 1;
        }
    });
};

main()