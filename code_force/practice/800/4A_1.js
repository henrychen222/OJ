/**
 * 10.16 afternoon
 * https://codeforces.com/problemset/problem/4/A
 */

// Accepted 154ms --- https://codeforces.com/problemset/submission/4/95680106
const solve = (w) => {
    if (w == 2) return false;
    if (w % 2 != 0) return false;
    return true;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let input;
    rl.on('line', (line) => {
        input = Number(line);
    });

    rl.on('close', () => {
        let res = solve(input) ? 'YES' : 'NO';
        console.log(res);
    });
};

main()