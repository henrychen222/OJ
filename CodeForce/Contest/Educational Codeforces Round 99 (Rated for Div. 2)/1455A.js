/**
 * 11.30 morning
 * https://codeforces.com/contest/1455/problem/A
 */

// Accepted
const solve = (n) => {
    console.log(n.length);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line);
    });
    rl.on('close', () => {
        let t = Number(input[0]);
        let i = 1;
        while (t > 0) {
            solve(input[i]);
            t--;
            i++;
        }
    });
};

main()