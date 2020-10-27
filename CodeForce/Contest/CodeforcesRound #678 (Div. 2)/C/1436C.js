/**
 * 10.24 morning
 * https://codeforces.com/contest/1436/problem/C
 */

// don't know
const solve = (n, x, pos) => {
    let data = [];
    for (let i = 1; i <= n; i++) {
        data.push(i);
    }
    console.log(data);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        let data = line.split(" ").map(x => Number(x));
        console.log(solve(data[0], data[1], data[2]))
    });
};

main()