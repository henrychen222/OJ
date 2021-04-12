/**
 * 04/01/21 morning
 * https://codeforces.com/contest/1505/problem/B
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
// const sq = Math.sqrt;
// const rd = Math.round;
// const ce = Math.round;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (num) => {
    pr(num % 9 == 0 ? 9 : num % 9);
};

// WA test 4
// const solve2 = (s) => {
//     let sum = 0;
//     for (const c of s) sum += Number(c)
//     pr(sum)
// };

// WA test 3
// const solve1 = (num) => {
//     pr(sqrt(num).toString());
// };

// const sqrt = (value) => {
//     if (value < 0n) {
//         throw 'square root of negative numbers is not supported'
//     }
//     if (value < 2n) {
//         return value;
//     }
//     function newtonIteration(n, x0) {
//         const x1 = ((n / x0) + x0) >> 1n;
//         if (x0 === x1 || x0 === (x1 - 1n)) {
//             return x0;
//         }
//         return newtonIteration(n, x1);
//     }
//     return newtonIteration(value, 1n);
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