/**
 * 10.16 afternoon
 * https://codeforces.com/problemset/problem/1/A
 */

// Accepted --- 93ms https://codeforces.com/problemset/submission/1/95687604
const solve = (n, m, a) => {
    if (n <= a) {
        if (m <= a) {
            return 1;
        } else {
            return 1 * Math.floor(m / a);
        }
    } else {
        if (m <= a) {
            return 1 * Math.floor(n / a);
        } else {
            let ms, ns;
            if (m % a != 0) {
                ms = Math.ceil(m / a);
            } else {
                ms = m / a;
            }
            if (n % a != 0) {
                ns = Math.ceil(n / a);
            } else {
                ns = n / a;
            }
            return ms * ns;
            // return Math.floor(m / a) * Math.floor(n / a) + (1 * (m % a)) + (1 * (n % a)) - 1;
        }
    }
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        terminal: false
    });
    let input;
    rl.on('line', function (line) {
        input = line.split(" ").map(x => Number(x));
        console.log(solve(input[0], input[1], input[2]));
    });

};

main()

// console.log(solve(6, 6, 4)); // 4
// console.log(solve(2, 1, 1)); // 2
// console.log(solve(2, 2, 1)); // 4
