/**
 * 1.8 morning
 * https://codeforces.com/contest/1467/problem/A
 */

// WA
// const solve = (n) => {
//     let a = Array(n).fill(0);
//     for (let i = 0; i < n; i++) {
//         a[i] = 9 - i % 10;
//     }
//     console.log(a.join(""));
// };

// WA
const solve = (n) => {
    let a = [9];
    while (n > 1) {
        let l = a[a.length - 1];
        if (l == 0) {
            a.push(9);
        } else {
            a.push(l - 1);
        }
        n--;
    }
    console.log(a.join(""));
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
            solve(input[i][0]);
            i++;
        }
    });
};

main()