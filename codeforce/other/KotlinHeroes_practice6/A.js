/**
 * 03/02/21 night
 * https://codeforces.com/contest/1489/problem/A
 * 
 * only kotlin is allowed, fuck
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

const solve = (n, a) => {
    let se = new Set();
    for (let i = n - 1; ~i; i--) {
        se.add(a[i]);
    }
    let res = [...se];
    let nr = res.length;
    pr(nr);
    pr(res.reverse().join(" "));
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
        solve(input[0][0], input[1]);
    });
};

main()