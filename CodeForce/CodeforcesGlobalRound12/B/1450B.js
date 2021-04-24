/**
 * 12.6 morning  12.7 evening
 * https://codeforces.com/contest/1450/problem/B
 */

// Accepted --- 124ms https://codeforces.com/contest/1450/submission/100665558
const solve = (n, k, data) => {
    let tmp = [];
    for (let i = 0; i < n; i++) {
        let len = tmp.length;
        for (let j = 0; j < n; j++) {
            if (j == i) continue;
            if (!ok(data[i], data[j], k)) {
                tmp.push(0);
                break;
            }
        }
        if (tmp.length == len) tmp.push(1);  // judge ok wrong during contest
    }
    return tmp.indexOf(1) != -1 ? 1 : -1;
};

const ok = (a, b, k) => {
    let distance = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    if (distance > k) {
        return false;
    }
    return true;
};

// wrong answer
// const solve = (n, k, data) => {
//     // console.log(n, k, data);
//     if (k == 0) return 1;
//     let tmp = new Array(n).fill(1);
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < n; j++) {
//             if (j == i) continue;
//             if (!ok(data[i], data[j], k)) {
//                 tmp[i] = 0;
//                 break;
//             }
//         }
//     }
//     // console.log(tmp);
//     return tmp.indexOf(1) != -1 ? 1 : -1;
// };

// const ok = (a, b, k) => {
//     let distance = (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2;
//     if (distance <= k ** 2) {
//         // console.log(a, b, distance, k ** 2)
//         return true;
//     }
//     return false;
// };

// const ok = (a, b, k) => {
//     let distance = (BigInt(a[0]) - BigInt(b[0])) ** 2n + (BigInt(a[1]) - BigInt(b[1])) ** 2n;
//     if (distance <= BigInt(k) ** 2n) {
//         return true;
//     }
//     return false;
// };

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
        while (t > 0) {
            let n = input[i][0];
            let k = input[i][1];
            let data = input.slice(i + 1, i + n + 1);
            console.log(solve(n, k, data));
            t--;
            i += n + 1;
        }
    });
};

main()