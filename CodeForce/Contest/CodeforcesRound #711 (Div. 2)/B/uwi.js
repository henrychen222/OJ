// 04/12/21 afternoon

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- https://codeforces.com/contest/1498/submission/112870331
const solve = (n, w, a) => {
    a.sort((x, y) => x - y);
    let uc = uniqcount(a);
    // pr(a);
    // pr(uc);
    let h = 0;
    while (1) {
        let end = 1;
        for (const e of uc) {
            if (e[1] != 0) end = 0;
        }
        if (end) break;
        h++;
        let rem = w;
        for (let i = uc.length - 1; ~i; i--) {
            let w = uc[i][0];
            let use = mi(rem / w >> 0, uc[i][1]);
            rem -= use * w;
            uc[i][1] -= use;
        }
        // pr(h, uc);
    }
    pr(h);
};

const uniqcount = (a) => {
    let n = a.length;
    let p = 0;
    let b = Array(n).fill(null);
    for (let i = 0; i < n; i++) {
        if (i == 0 || a[i] != a[i - 1]) b[p++] = [a[i], 0];
        b[p - 1][1]++;
    }
    return b.slice(0, p);
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
            solve(input[i][0], input[i][1], input[i + 1]);
            i += 2;
        }
    });
};

main()