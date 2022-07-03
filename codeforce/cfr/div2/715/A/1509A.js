/**
 * 04/16/21 morning
 * https://codeforces.com/contest/1509/problem/A
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Pretests passed
const solve = (n, a) => {
    let odd = [];
    let even = [];
    for (const e of a) {
        e & 1 ? odd.push(e) : even.push(e);
    }
    // pr(odd, even)
    let res = odd.concat(even);
    pr(res.join(" "))
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
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()