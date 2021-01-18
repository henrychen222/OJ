/**
 * 1.4 morning
 * https://codeforces.com/contest/1472/problem/B
 */

// Accepted
const solve = (n, arr) => {
    if ([...new Set(arr)].length == 1) {
        if (n % 2 == 0) {
            return console.log('YES');
        } else {
            return console.log('NO');
        }
    }
    let sum = arr.reduce((a, b) => a + b);
    if (sum % 2 == 1) return console.log('NO');
    console.log('YES');
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
            solve(data[0][0], data[1]);
            i += 2;
        }
    });
};

main()