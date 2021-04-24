/**
 * 10.16 afternoon
 * https://codeforces.com/problemset/problem/4/A
 */

// Accepted 156ms --- https://codeforces.com/problemset/submission/4/95680379
const solve = (w) => {
    if (w == 2) return false;
    if (w % 2 != 0) return false;
    return true;
};

// Clean way to write  
const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        let res = solve(Number(line)) ? 'YES' : 'NO';
        console.log(res);
    });
};

main()