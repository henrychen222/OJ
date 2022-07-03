/**
 * 03/13/21 morning
 * https://atcoder.jp/contests/abc195/tasks/abc195_c
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- https://atcoder.jp/contests/abc195/submissions/20905908
// reference: https://atcoder.jp/contests/abc195/submissions?f.User=uwi
const solve = (n) => {
    let res = 0;
    for (let d = 1000; n - (d - 1) >= 0; d *= 1000) {
        res += n - (d - 1);
    }
    pr(res);
};

// const solve = (N) => {
//     // 1000, 10 * 6, 10 ** 9, 10 ** 12, 10 ** 15
//     let a = Array(15).fill(0);
//     let a = [9000, 90000, 900000, 9000000];
//     pr(a, a.length, (a[a.length - 1] + '').length);
//     let s = N + '';
//     let n = s.length;
//     let res = 0;
//     for (let i = 0; i < n; i++) {
//         if (s[i] == '0') continue;
//         let t = Number(s[i]) * 10 ** (n - i - 1);
//         // pr(t);
//     }
// };

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(Number(line));
    });
};

main()

// pr(Number.MAX_SAFE_INTEGER > 10 * 15)

// for (let i = 4; i <= 15; i++) {
//     let tmp = 10 ** (i + 1) - 10 ** i;
//     a[i] = tmp;
// }