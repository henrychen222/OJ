/**
 * 12.4 morning
 * https://codeforces.com/contest/1453/problem/B
 */

// don't know
const solve = (n, arr) => {
    // console.log(n, arr);
    let tmp1 = [...arr];
    let tmp2 = [...arr];
    tmp1[1] = tmp1[0];
    tmp2[0] = tmp2[1];
    console.log(tmp1, tmp2);
    let res1 = res2 = 0;
    for (let i = 2, j = 0; i < n; i++, j++) {
        res1 += Math.abs(Math.abs(tmp1[i] - tmp1[0]) - j);
        res2 += Math.abs(Math.abs(tmp2[i] - tmp2[0]) - j);
    }
    console.log(Math.min(res1, res2), res1, res2);
};

// https://www.geeksforgeeks.org/minimum-increment-decrement-to-make-array-elements-equal/
// const solve = (n, A) => {
//     let cost = 0; 
//     A.sort((a,b) => a- b);
//     let K = A[n >> 1]; 
//     for (let i = 0; i < n; ++i) 
//         cost += Math.abs(A[i] - K); 
//     if (n % 2 == 0) { 
//         let tempCost = 0;
//         K = A[(n >> 1) - 1]; 
//         for (let i = 0; i < n; ++i) 
//             tempCost += Math.abs(A[i] - K); 
//         cost = Math.min(cost, tempCost); 
//     } 
//     console.log(cost); 
// };

// https://stackoverflow.com/questions/48083622/minimum-number-of-increment-other-operations-to-make-all-array-elements-equal
// const solve = (n, A) => {
//     let sum = A.reduce((a, b) => a +b);
//     let min = Math.min.apply(Math, A);
//     console.log(sum - n * min); 
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
            let data = input.slice(i, i + 2);
            solve(data[0][0], data[1]);
            t--;
            i += 2;
        }
    });
};

main()