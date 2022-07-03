/**
 * 1.5 morning
 * https://codeforces.com/contest/1471/problem/A
 */

// wrong
const solve = (n, x, a) => {
    let sum = a.reduce((x, y) => x + y);
    let restT = 0;
    for (const item of a) {
        let tmp = item / x - Math.floor(item / x);
        restT += item % n;
    }
    let min = Math.round(sum / n);
    let max = Math.round(sum / n) + Math.floor(restT / n);
    console.log(min, max);
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
            let data = input.slice(i, i + 2);
            solve(data[0][0], data[0][1], data[1]);
            i += 2;
        }
    });
};

main()




// const solve = (n, x, a) => {
//     let min = max = a[0];
//     for (let i = 1; i < n; i+=2) {
//         let sum = a[i - 1] + a[i];
//         let tmp = sum / x - Math.floor(sum / x);
//         if (tmp >= 0.5) {
//             max += Math.round(sum / x);
//         } else {
//             let first = a[i - 1] / x - Math.floor(a[i - 1] / x);
//             let second = a[i] / x - Math.floor(a[i] / x);
//             if (first >= 0.5 || second >= 0.5) {
//                 max += Math.round(a[i - 1] / x);
//                 max += Math.round(a[i] / x);
//             }
//         }
//     }
//     for (let i = 1; i < n; i++) {
//         let sum = a[i - 1] + a[i];
//         let tmp = sum / x - Math.floor(sum / x);
//         if (tmp < 0.5) {
//             min += Math.round(sum / x);
//         } else {
//             let first = a[i - 1] / x - Math.floor(a[i - 1] / x);
//             let second = a[i] / x - Math.floor(a[i] / x);
//             if (first < 0.5 || second < 0.5) {
//                 min += Math.round(a[i - 1] / x);
//                 min += Math.round(a[i] / x);
//             }
//         }
//     }
//     console.log(min, max);
// };
