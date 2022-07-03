/**
 * 04/10/21 morning
 * https://codeforces.com/contest/1512/problem/0
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (n, a) => {
    let m = new Map();
    for (const e of a) m.set(e, m.get(e) + 1 || 1);
    for (let i = 0; i < n; i++) {
        if (m.get(a[i]) == 1) return pr(i + 1);
    }
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