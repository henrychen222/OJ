/**
 * 04/19/21 morning
 * https://codeforces.com/contest/1514/problem/A
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

// Pretests passed
const solve = (n, a) => {
    // pr(n,a);
    for (const e of a) {
        let q = sq(e);
        if (q != q >> 0) return pr('YES');
    }
    pr('NO')
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