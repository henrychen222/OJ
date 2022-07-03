/**
 * 03/21/21 noon
 * https://www.codechef.com/COOK127C/problems/PAWRI
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// TLE 0.51sec
const solve = (s) => {
    pr(s.split("party").join("pawri"));
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
        let t = Number(input[0]);  // be careful this t
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()