/**
 * 12.17 morning
 * https://codeforces.com/contest/1463/problem/B
 */

// don't know
// const solve = (n, arr) => {
//     console.log(n, arr);
//     let sum = arr.reduce((a, b) => a + b);
//     let maxDiff = Math.floor(sum / 2 / n);
//     let res = [...arr];
//     for (let i = 0; i + 1 < n; i++) {
//     }
//     return res.join(" ");
// };


// Accepted https://codeforces.com/contest/1463/submission/101581557 uwi
const solve = (n, arr) => {
    let res = [];
    for (let i = 0; i < n; i++) {
        res.push(highestOneBit(arr[i]));
    }
    return res.join(" ");
};

const highestOneBit = (i) => {
    i |= (i >> 1);
    i |= (i >> 2);
    i |= (i >> 4);
    i |= (i >> 8);
    i |= (i >> 16);
    return i - (i >>> 1);
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
            console.log(solve(data[0][0], data[1]));
            i += 2;
        }
    });
};

main()