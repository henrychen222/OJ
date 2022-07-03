/**
 * 1.4 morning
 * https://codeforces.com/contest/1472/problem/C
 */

// TLE
// const solve = (n, a) => {
//     // console.log(n, a);
//     let max = 0;
//     for (let i = 0; i < n; i++) {
//         let idx = i + 1;
//         let sum = 0;
//         // console.log("begin", idx, sum)
//         while (idx <= n) {
//             sum += a[idx - 1];
//             idx += a[idx - 1];
//             // console.log(idx, sum)
//         }
//         max = Math.max(max, sum);
//     }
//     console.log(max);
// };

// Accepted
const solve = (n, a) => {
    let map = new Map();
    let max = 0;
    for (let i = n - 1; ~i; i--) {
        let idx = i + 1;
        let sum = 0;
        while (idx <= n) {
            if (map.has(idx)) {
                sum += map.get(idx);
                break;
            }
            sum += a[idx - 1];
            idx += a[idx - 1];
        }
        max = Math.max(max, sum);
        map.set(i + 1, sum);
    }
    console.log(max);
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
            solve(data[0][0], data[1]);
            i += 2;
        }
    });
};

main()