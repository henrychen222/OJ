/**
 * 12.11 morning  12.11 afternoon
 * https://codeforces.com/contest/1461/problem/C
 */

// TLE on test 10
const solve = (n, m, p, experiment) => {
    let dec = new Set();
    let maxIdx = new Set();
    let tMax = Math.max.apply(Math, p);
    for (let i = 0; i + 1 < n; i++) {
        let tmp = p[i + 1] - p[i];
        if (tmp < 0) dec.add(i);
        if (p[i] == tMax) maxIdx.add(i);
    }
    if (p[n - 1] == tMax) maxIdx.add(n - 1);
    if (isAscending(p)) {
        console.log(1);
        return;
    }
    experiment.sort((a, b) => b[0] - a[0]);
    // console.log(n, m, p, experiment);
    // console.log(diff, dec);
    let res = 0;
    let last = m - 1;
    top:
    for (const e of experiment) {
        let max = 0;
        for (let ma = 0; ma < e[0]; ma++) {
            if (maxIdx.has(ma)) {
                max = tMax;
                break;
            } else {
                max = Math.max(max, p[ma]);
            }
        }
        if (max > p[e[0]]) break;
        for (let i = e[0] - 1; i <= last; i++) {
            if (dec.has(i + 1)) continue top;
        }
        res += (1 - res) * e[1];
        last = e[0];
    }
    console.log(res);
};

// TLE on test 10
const solve2 = (n, m, p, experiment) => {
    let diff = [];
    for (let i = 0; i + 1 < n; i++) {
        diff.push(p[i + 1] - p[i]);
    }
    if (diff.every(x => x >= 0)) {
        console.log(1);
        return;
    }
    experiment.sort((a, b) => b[0] - a[0]);
    let res = 0;
    for (const e of experiment) {
        let tmp = p.slice(0, e[0]);
        let max = Math.max.apply(Math, tmp);
        if (max > p[e[0]] || diff.slice(e[0] - 1).some(x => x < 0)) break;
        res += (1 - res) * e[1];
    }
    console.log(res);
};

// WA on pretest 3 https://codeforces.com/contest/1461/submission/100950821
const solve1 = (n, m, p, experiment) => {
    if (isAscending(p)) {
        console.log(1);
        return;
    }
    experiment.sort((a, b) => b[0] - a[0]);
    let res = 0;
    for (const e of experiment) {
        let tmp = p.slice(0, e[0]);
        let max = Math.max.apply(Math, tmp);
        if (max > p[e[0]]) break;
        res += (1 - res) * e[1];
    }
    console.log(res);
};

const isAscending = (arr) => {
    return arr.every((x, i) => {
        return i === 0 || x >= arr[i - 1];
    });
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



const check = (b, res) => {
    let tmp = Math.abs((res - b)) / Math.max(1, Math.abs(b));
    return tmp <= 10 ** (-6);
};