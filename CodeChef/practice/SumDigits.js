/**
 * 02/20/21 evening
 * https://www.codechef.com/problems/FLOW006
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 0.06sec
const solve = (s) => {
    // pr(s);
    let res = s.split("").map(Number).reduce((x, y) => x + y);
    pr(res)
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
        let t = input[0];
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()