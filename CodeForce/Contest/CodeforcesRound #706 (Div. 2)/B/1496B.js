/**
 * 03/10/21 morning + evening
 * https://codeforces.com/contest/1496/problem/B
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const ro = Math.round;
///////////////////////////////////////////////////////////////////////////////////

// TLE
// const solve = (n, k, a) => {
//     // pr(n, k, a)
//     while (k--) {
//         a.sort((x, y) => x - y);
//         let max = a[a.length - 1];
//         let add = max + 1;
//         for (let i = 0; i < n; i++) {
//             if (i != a[i]) {
//                 add = ro((i + max) / 2);
//                 break;
//             }
//         }
//         a.push(add);
//         n++;
//     }
//     // pr(a, n);
//     pr([...new Set(a)].length);
// };

// memory out
// const solve = (n, k, a) => {
//     let max = Math.max.apply(Math, a);
//     let mex = max + 1;
//     for (let i = 0; i < n; i++) {
//         if (i != a[i]) {
//             mex = i;
//             break;
//         }
//     }
//     for (; k--; n++) {
//         let add = ro((mex + max) / 2);
//         // pr(add, max, mex);
//         a.push(add);
//         if (add > max) max = add;
//         if (add <= mex) {
//             mex = max + 1;
//             for (let i = 0; i < n; i++) {
//                 if (i != a[i]) {
//                     mex = i;
//                     break;
//                 }
//             }
//         }
//     }
//     pr([...new Set(a)].length);
// };

// TLE
// const solve = (n, k, a) => {
//     let se = new Set(a);
//     let res = [...se].length;
//     let max = Math.max.apply(Math, a);
//     let mex = max + 1;
//     for (let i = 0; i < n; i++) {
//         if (i != a[i]) {
//             mex = i;
//             break;
//         }
//     }
//     for (; k--; n++) {
//         let add = ro((mex + max) / 2);
//         // pr(add, max, mex);
//         if (!se.has(add)) res++;
//         if (add > max) max = add;
//         if (add <= mex) {
//             mex = max + 1;
//         }
//     }
//     pr(res);
// };


// Accepted --- https://codeforces.com/contest/1496/submission/109670103
const solve = (n, k, a) => {
    if (k == 0) return pr(n);
    a.sort((x, y) => x - y);
    let max = a[n - 1];
    let mex = n;
    for (let i = 0; i < n; i++) {
        if (i != a[i]) {
            mex = i;
            break;
        }
    }
    if (mex > max) return pr(n + k);
    let add = mex + max + 1 >> 1;
    for (let i = 0; i < n; i++) {
        if (add == a[i]) {
            return pr(n);
        }
    }
    pr(n + 1);
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
            solve(input[i][0], input[i][1], input[i + 1]);
            i += 2;
        }
    });
};

main()