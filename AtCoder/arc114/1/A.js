/**
 * 03/14/21 morning
 * https://atcoder.jp/contests/arc114/tasks/arc114_a
 * 
 * https://www.geeksforgeeks.org/check-two-numbers-co-prime-not/
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// TLE
const solve = (n, a) => {
    let m = new Map();
    for (let i = 1; ; i++) {
        let flag = 1;
        for (const x of a) {
            let t = i + ' ' + x;
            let g;
            if (m.has(t)) {
                g = m.get(t);
            } else {
                g = gcd(i, x);
                m.set(t, g);
            }
            if (g == 1) {
                flag = 0;
                break;
            }
        }
        if (flag) return pr(i);
    }
};

const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);

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