/**
 * 10.13 morning
 * https://atcoder.jp/contests/abc162/tasks/abc162_c
 */

// Accepted --- 1748ms
// https://atcoder.jp/contests/abc162/submissions/17388778
const solve = (K) => {
    let res = 0;
    for (let i = 1; i <= K; i++) {
        for (let j = 1; j <= K; j++) {
            for (let k = 1; k <= K; k++) {
                res += gcd(i, j, k);
            }
        }
    }
    return res;
};

const gcd = (a, b, c) => {
    let min = Math.min(Math.min(a, b), c);
    for (let i = min; i > 0; i--) {
        if ((a % i == 0) && (b % i == 0) && (c % i == 0)) {
            return i;
        }
    }
    return 0;
};

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false
});

const main = () => {
    rl.on('line', function (line) {
        console.log(solve(line));
    })
};

main()

// let min = Math.min(Math.min(i, j), k);
// let max = Math.max(Math.max(i, j), k);
// let tmp = [min, -1, max];
// if (i != min && i != max) {
//     tmp[1] = i;
// }
// if (j != min && j != max) {
//     tmp[1] = j;
// }
// if (k != min && k != max) {
//     tmp[1] = k;
// }
// let s = JSON.stringify(tmp);
// if (map.has(s)) {
//     res.push(map.get(s));
// } else {
//     let sum = gcd(tmp[0], tmp[1], tmp[2]);
//     res.push(sum);
//     map.set(s, sum);
// }