/**
 * 11.21 morning
 * https://atcoder.jp/contests/arc108/tasks/arc108_a
 */

// Accepted --- https://atcoder.jp/contests/arc108/submissions/18270573 80ms
// reference: https://math.stackexchange.com/questions/171407/finding-two-numbers-given-their-sum-and-their-product
const solve = (S, P) => {
    let m = (S + ((S ** 2 - 4 * P) ** (1 / 2))) / 2;
    let n = (S - ((S ** 2 - 4 * P) ** (1 / 2))) / 2;
    // console.log(m, n);
    if (ok(m) && ok(n)) {
        console.log("Yes");
    } else {
        console.log("No");
    }
};

const ok = (n) => {
    if (n < 1) return false;
    let s = n + '';
    if (s.indexOf('.') != -1) return false;
    return true;
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
        solve(input[0][0], input[0][1]);
    });
};

main()