/**
 * 03/06/21 morning
 * https://atcoder.jp/contests/abc194/tasks/abc194_c
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// TLE
// const solve = (n, a) => {
//     let res = 0;
//     for (let i = 0; i < n; i++) {
//         for (let j = i + 1; j < n; j++) {
//             res += (a[i] - a[j]) ** 2;
//         }
//     }
//     pr(res);
// };

// reference: https://atcoder.jp/contests/abc194/submissions/20696825
// Accepted --- 221ms https://atcoder.jp/contests/abc194/submissions/20732212
const solve = (n, a) => {
    let s1 = s2 = 0;
    for (const e of a) {
        s1 += e;
        s2 += e ** 2;
    }
    pr(s2 * n - s1 ** 2);
};

// Accepted --- 153ms https://atcoder.jp/contests/abc194/submissions/20732470
const solve2 = (n, a) => {
    let s1 = s2 = 0;
    for (const e of a) {
        s1 += e;
        s2 += e * e;
    }
    pr(s2 * n - s1 * s1);
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
        solve(input[0][0], input[1]);
    });
};

main()

/**
 * n -2: (a[n -2] - a[n - 1]) ^ 2
 * n - 3: (a[n - 3] - a[n - 2]) ^ 2 + (a[n - 3] - a[n - 1]) ^ 2
 * n - 4: (a[n - 4] - a[n - 3]) ^ 2 + (a[n - 4] - a[n - 2]) ^ 2 + (a[n - 4] - a[n - 1]) ^ 2
 */