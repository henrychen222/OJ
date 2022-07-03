/**
 * 11.30 morning
 * https://codeforces.com/contest/1455/problem/B
 */


 // wrong
// const solve = (x) => {
//     if (x == 1) {
//         console.log(1);
//         return;
//     }
//     if (x == 2) {
//         console.log(3);
//         return;
//     }
//     console.log(x - 1);
// };

// let res;
// const solve = (x) => {
//     res = 0;
//     dfs(0, x);
//     return res;
// };

// const dfs = (pos, x) => {
//     res++;
//     if (pos == x) return;
//     for (let k = 1; ; k++) {
//         dfs(pos + k, x);
//         dfs(pos - 1, x);
//     }
// };

// neal
// Accepted https://codeforces.com/contest/1455/submission/100058271
const solve = (x) => {
    let jump = 0;
    while (x > 0) {
        jump++;
        x -= jump;
    }
    if (x == -1) jump++;
    console.log(jump);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(Number(line));
    });
    rl.on('close', () => {
        let t = input[0];
        let i = 1;
        while (t > 0) {
            solve(input[i]);
            t--;
            i++;
        }
    });
};

main()

// console.log(1);
// console.log(2);
// console.log(3);
// console.log(4);
// console.log(5);