/**
 * 11.28 morning  11.28 evening
 * https://atcoder.jp/contests/arc109/tasks/arc109_b
 */

// don't know
// const solve = (n) => {
//     console.log((n + 1n) >> 1n);
//     console.log(109109109109109109n - 109109108641970782n);
// };

// Accepted https://atcoder.jp/contests/arc109/submissions/18484787
const bigIntMin = (...args) => args.reduce((m, e) => e < m ? e : m);
const solve = (n) => {
    let low = 0n;
    let high = bigIntMin(BigInt(5e9), BigInt(n));
    while (low < high) {
        let mid = (low + high + 1n) >> 1n;
        if (mid * (mid + 1n) / 2n <= BigInt(n) + 1n) {
            low = mid;
        } else {
            high = mid - 1n;
        }
    }
    let res = BigInt(n) + 1n - low;
    console.log(res.toString());
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(BigInt(line));
    });
};

main()