/**
 * 11.28 evening
 * https://codeforces.com/contest/1457/problem/0
 */

// TLE
// const solve = (n, m, r, c) => {
//     let max = 0;
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < m; j++) {
//             let tmp = Math.abs(i - r + 1) + Math.abs(j - c + 1);
//             max = Math.max(max, tmp);
//         }
//     }
//     console.log(max);
// };

// Pretest passed https://codeforces.com/contest/1457/submission/99857530
const solve = (n, m, r, c) => {
    let topLeft = Math.abs(0 - r + 1) + Math.abs(0 - c + 1);
    let topRight = Math.abs(0 - r + 1) + Math.abs(m - 1 - c + 1);
    let bottomLeft = Math.abs(n - 1 - r + 1) + Math.abs(0 - c + 1);
    let bottomRight = Math.abs(n - 1 - r + 1) + Math.abs(m - 1 - c + 1);
    console.log(Math.max(topLeft, topRight, bottomLeft, bottomRight));
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
        let t = Number(input[0][0]);
        let i = 1;
        while (t > 0) {
            solve(input[i][0], input[i][1], input[i][2], input[i][3]);
            t--;
            i++;
        }
    });
};

main()

// const sortSet = (set) => {
//     return new Set([...(new Set(set))].sort((a, b) => a - b));
// };