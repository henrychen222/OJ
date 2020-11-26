/**
 * 11.21 evening
 * https://codeforces.com/contest/1451/problem/A
 */

// Accepted --- https://codeforces.com/contest/1451/submission/99207525 93ms
const solve = (n) => {
    if (n == 1) return 0;
    if (n == 2) return 1;
    if (n == 3) return 2;
    if (n % 2 == 0) {
        return 2;
    } else {
        return 3;
    }
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
        let t = input[0];
        let i = 1;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0][0]));
            t--;
            i++;
        }
    });
};

main()