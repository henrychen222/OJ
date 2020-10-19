/**
 * 10.18 morning
 * https://codeforces.com/contest/1421/problem/A
 */

// const solve = (a, b) => {
//     let res = Number.MAX_VALUE;
//     let min = Math.min(a, b);
//     let max = Math.max(a, b);
//     for (let x = min; x <= max; x++) {
//         let tmp = (a ^ x) + (b ^ x);
//         res = Math.min(res, tmp);
//     }
//     return res;
// };

// Pretests passed
// reference: https://www.geeksforgeeks.org/choose-x-such-that-a-xor-x-b-xor-x-is-minimized/
const solve = (a, b) => {
    let x = selectX(a, b)
    return (a ^ x) + (b ^ x);
};

const selectX = (A, B) => {
    let j = 0;
    let x = 0;
    while (A || B) {
        if ((A & 1) && (B & 1)) {
            x += (1 << j);
        }
        A >>= 1;
        B >>= 1;
        j += 1;
    }
    return x;
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
            let data = input.slice(i, i + 1);
            console.log(solve(data[0][0], data[0][1]));
            t--;
            i++;
        }
    });
};

main()

// console.log(solve(28, 14));
// console.log(solve(4925, 2912));
// console.log(solve(2, 3));
// console.log(solve(7, 8));
// console.log(solve(3, 9));
// console.log(solve(3, 35));
// console.log(solve(1, 1000000000));