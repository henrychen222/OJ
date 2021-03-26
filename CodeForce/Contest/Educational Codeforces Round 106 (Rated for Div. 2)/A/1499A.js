/**
 * 03/18/21 morning
 * https://codeforces.com/contest/1499/problem/0
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const abs = Math.abs;
///////////////////////////////////////////////////////////////////////////////////

// const solve = (n, k1, k2, w, b) => {
//     // pr(n, k1, k2, w, b)
//     let a = [];
//     for (let i = 0; i < 2; i++) {
//         let tmp = [];
//         for (let j = 0; j < n; j++) {
//             if (i == 0) {
//                 j < k1 ? tmp.push('w') : tmp.push('b');
//             } else {
//                 j < k2 ? tmp.push('w') : tmp.push('b');
//             }
//         }
//         a.push(tmp);
//     }
//     pr(a);
//     let cntw = cntb = 0
//     for (let i = 0; i < 2; i++) {
//         for (let j = 0; j < n; j++) {
//             if (a[i][j] == 'w') {
//                 if (i - 1 >= 0) {
//                     if (a[i - 1][j] == 'w') {
//                         cntw++;
//                         continue;
//                     }
//                 }
//                 if (i + 1 < 2) {
//                     if (a[i + 1][j] == 'w') {
//                         cntw++;
//                         continue;
//                     }
//                 }
//                 if (j - 1 >= 0) {
//                     if (a[i][j - 1] == 'w') {
//                         cntw++;
//                         continue;
//                     }
//                 }
//                 if (j + 1 < n) {
//                     if (a[i][j + 1] == 'w') {
//                         cntw++;
//                         continue;
//                     }
//                 }
//             } else {
//                 if (i - 1 >= 0) {
//                     if (a[i - 1][j] == 'b') {
//                         cntb++;
//                         continue;
//                     }
//                 }
//                 if (i + 1 < 2) {
//                     if (a[i + 1][j] == 'b') {
//                         cntb++;
//                         continue;
//                     }
//                 }
//                 if (j - 1 >= 0) {
//                     if (a[i][j - 1] == 'b') {
//                         cntb++;
//                         continue;
//                     }
//                 }
//                 if (j + 1 < n) {
//                     if (a[i][j + 1] == 'b') {
//                         cntb++;
//                         continue;
//                     }
//                 }
//             }
//         }
//     }
//     // pr(w, cntw, b, cntb);
//     if (w <= cntw && b <= cntb) return pr('YES');
//     pr('NO');
// };

// Accepted
const solve = (n, k1, k2, w, b) => {
    let cntw = mi(k1, k2) + (abs(k1 - k2) >> 1);
    let cntb = mi(n - k1, n - k2) + (abs((n - k1) - (n - k2)) >> 1);
    // pr(cntw, cntb);
    if (w <= cntw && b <= cntb) return pr('YES');
    pr('NO');
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
            solve(input[i][0], input[i][1], input[i][2], input[i + 1][0], input[i + 1][1]);
            i += 2;
        }
    });
};

main()