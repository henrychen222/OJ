/**
 * 04/16/21 morning
 * https://codeforces.com/contest/1509/problem/B
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// WA
const solve = (n, s) => {
    let t = [];
    let m = [];
    for (let i = 0; i < n; i++) {
        s[i] == 'T' ? t.push(i) : m.push(i);
    }
    pr("idx", t, m)
    let tn = t.length;
    let mn = m.length;
    if (2 * mn != tn) return pr("NO");
    let res = [];
    while (1) {
        if (t.length == 0 || m.length == 0) break;
        let t1 = t.shift();
        let t2 = t.pop();
        let m1 = m.shift();
        pr("TMT", [t1, m1, t2]);
        if (m1 < t1 || m1 > t2) return pr("NO");
        res.push([t1, m1, t2]);
    }
    pr(res);
    if (res.length * 3 != n) return pr("NO");
    pr("YES");
};

// don't know
const solve2 = (n, s) => {
    let t = [];
    let m = [];
    for (let i = 0; i < n; i++) {
        s[i] == 'T' ? t.push(i) : m.push(i);
    }
    pr("idx", t, m)
    let tn = t.length;
    let mn = m.length;
    if (2 * mn != tn) return pr("NO");
    let res = [];
    while (1) {
        if (t.length == 0 || m.length == 0) break;
        let min = t[0];
        let max = t[t.length - 1];
        let ts = new Set(t);
        let m1 = m.shift();
        let t1, t2;
        pr(ts, m1);
        for (let i = m1; i <= max; i++) {
            if (ts.has(i)) {
                t2 = i;
                break;
            }
        }
        for (let j = m1; j >= min; j--) {
            if (ts.has(j)) {
                t1 = j;
                break;
            }
        }
        ts.delete(t1);
        ts.delete(t2);
        t = [...ts];
        pr([t1, m1, t2]);
        if (t1 == undefined || t2 == undefined || m1 == undefined) return pr('NO')
        res.push([t1, m1, t2]);
    }
    pr(res);
    if (res.length * 3 != n) return pr("NO");
    pr("YES");
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
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            solve(input[i], input[i + 1]);
            i += 2;
        }
    });
};

main()