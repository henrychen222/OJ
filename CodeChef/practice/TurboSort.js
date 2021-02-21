/**
 * 02/20/21 evening
 * https://www.codechef.com/problems/TSORT
 */

// TLE 3.06 sec, but Java 4.95 sec passed. Trash Question
const solve = (n, a) => {
    a.sort((a, b) => a - b);
    for (let i = 0; i < n; i++) {
        console.log(a[i]);
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
        input.push(Number(line));
    });
    rl.on('close', () => {
        let n = input.shift();
        solve(n, input);
    });
};

main()