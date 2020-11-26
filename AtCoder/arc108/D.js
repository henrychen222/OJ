/**
 * 11.21 morning
 * https://atcoder.jp/contests/arc108/tasks/arc108_d
 * 
 * reference
 * https://atcoder.jp/contests/arc108/submissions?f.User=cuiaoxiang
 * https://atcoder.jp/contests/arc108/submissions?f.User=uwi
 * https://atcoder.jp/contests/arc108/submissions?f.User=Heltion
 * https://atcoder.jp/contests/arc108/submissions?f.User=hank55663
 */

// don't know
// const solve = (N, caa, cab, cba, cbb) => {
//     let s = 'AB';
//     console.log(N, caa, cab, cba, cbb);
//     let n = s.length;
//     for (let i = 0; i + 1 < n; i++) {
//         if (s[i] == 'A') {
//             if (s[i + 1] == 'A') {
//             } else {
//             }
//         } else {
//         }
//     }
// };

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
        console.log(input);
        solve(Number(input[0]), input[1], input[2], input[3], input[4]);
    });
};

main()