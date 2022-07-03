/**
 * 02/20/21 evening
 * https://www.codechef.com/problems/FLOW001
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 0.06 sec
const solve = (x, y) => {
    pr(x + y);
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
            solve(input[i][0], input[i][1]);
            i++;
        }
    });
};

main()