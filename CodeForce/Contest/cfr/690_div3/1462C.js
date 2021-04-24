/**
 * 12.15 morning
 * https://codeforces.com/contest/1462/problem/C
 */

// Accepted
const solve = (n) => {
    if (n <= 9) {
        return n;
    } else if (n <= 17 && n >= 10) {
        return Number(n - 9 + '' + 9);
    } else if (n <= 24 && n >= 18) {
        return Number(n - 17 + '' + 8 + 9);
    } else if (n <= 30 && n >= 25) {
        return Number(n - 24 + '' + 7 + 8 + 9);
    } else if (n <= 35 && n >= 31) {
        return Number(n - 30 + '' + 6 + 7 + 8 + 9);
    } else if (n <= 39 && n >= 36) {
        return Number(n - 35 + '' + 5 + 6 + 7 + 8 + 9);
    } else if (n <= 42 && n >= 40) {
        return Number(n - 39 + '' + 4 + 5 + 6 + 7 + 8 + 9);
    } else if (n <= 44 && n >= 43) {
        return Number(n - 42 + '' + 3 + 4 + 5 + 6 + 7 + 8 + 9);
    } else if (n == 45) {
        return Number(n - 44 + '' + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);
    }
    return -1;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(Number(line));
    });
    rl.on('close', () => {
        let t = input[0];
        let i = 1;
        while (t > 0) {
            let data = input[i];
            console.log(solve(data));
            t--;
            i++;
        }
    });
};

main()