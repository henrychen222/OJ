/**
 * 1.2 morning
 * https://atcoder.jp/contests/abc187/tasks/abc187_d
 */

// Accepted --- https://atcoder.jp/contests/abc187/submissions/19181126  1.2 night
const solve = (n, a) => {
    let sumA = 0;
    for (const e of a) {
        sumA += e[0];
    }
    a.sort((x, y) => (y[0] * 2 + y[1]) - (x[0] * 2 + x[1])); // fuck, sort regulation consider wrong
    let va = sumA;
    let vb = 0;
    let cnt = 0;
    for (const e of a) {
        if (vb > va) break;
        let t = e[0] + e[1];
        vb += t;
        va -= e[0];
        cnt++;
    }
    console.log(cnt);
};

// wrong https://atcoder.jp/contests/abc187/submissions/19158167
const solve4 = (n, a) => {
    let sumA = 0;
    for (const e of a) {
        sumA += e[0];
    }
    a.sort((x, y) => {
        if (y[0] + y[1] == x[0] + x[1]) return y[0] - x[0];
        return (y[0] + y[1]) - (x[0] + x[1]);
    });
    let va = sumA;
    let vb = 0;
    let cnt = 0;
    for (const e of a) {
        if (vb > va) break;
        let t = e[0] + e[1];
        vb += t;
        va -= e[0];
        cnt++;
    }
    console.log(cnt);
};

// Wrong https://atcoder.jp/contests/abc187/submissions/19157297
const solve3  = (n, a) => {
    // console.log(n, a);
    let sumA = 0;
    for (const e of a) {
        sumA += e[0];
    }
    a.sort((x, y) => {
        if (x[0] == y[0]) return (y[0] + y[1]) - (x[0] + x[1]);
        return y[0] - x[0];
    });
    // console.log(a);
    let va = sumA;
    let vb = 0;
    let cnt = 0;
    for (const e of a) {
        if (vb > va) break;
        let t = e[0] + e[1];
        vb += t;
        va -= e[0];
        cnt++;
    }
    console.log(cnt);
};

// wrong https://atcoder.jp/contests/abc187/submissions/19155172
const solve2 = (n, a) => {
    let sumA = 0;
    for (const e of a) {
        sumA += e[0];
    }
    a.sort((x, y) => y[0] - x[0]);
    let va = sumA;
    let vb = 0;
    let cnt = 0;
    for (const e of a) {
        if (vb > va) break;
        let t = e[0] + e[1];
        vb += t;
        va -= e[0];
        cnt++;
    }
    console.log(cnt);
};

// wrong https://atcoder.jp/contests/abc187/submissions/19152203
const solve1 = (n, a) => {
    let sumA = sumB = 0;
    for (const e of a) {
        sumA += e[0];
        sumB += e[1];
    }
    a.sort((a, b) => (b[0] + b[1]) - (a[0] + a[1]));
    let va = sumA;
    let vb = 0;
    let cnt = 0;
    for (const e of a) {
        if (vb > va) break;
        let t = e[0] + e[1];
        vb += t;
        va -= e[0];
        cnt++;
    }
    console.log(cnt);
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
        solve(input[0][0], input.slice(1));
    });
};

main()