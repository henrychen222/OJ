/**
 * 03/17/21 morning
 * https://codeforces.com/contest/1497/problem/A
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
///////////////////////////////////////////////////////////////////////////////////

// Pretests passed
const solve = (n, a) => {
    // pr(n, a)
    let m = new Map();
    for (const e of a) {
        m.set(e, m.get(e) + 1 || 1);
    }
    m = sortMapByKey(m);
    let res = Array.from(m.keys());
    for (const [k, v] of m) {
        if (v == 1) continue;
        for (let i = 1; i <= v - 1; i++) {
            res.push(k);
        }
    }
    pr(res.join(" "));
};

const sortMapByKey = (map) => {
    return new Map([...map].sort((a, b) => a[0] - b[0]));
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
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()