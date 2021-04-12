/**
 * 04/01/21 morning
 * https://codeforces.com/contest/1505/problem/A
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (s) => {
    pr("NO");
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        if (line.length == 0) {
            rl.on('close', () => {});
        } else {
            solve(line);
        }
    });
};

main()
