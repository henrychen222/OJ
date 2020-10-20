/**
 * 10.20 morning
 * https://codeforces.com/contest/1433/problem/A
 */

const solve = (x) => {
    let s = x + '';
    let n = s.length;
    let rest = 0;
    for (let i = 1; i <= n; i++) {
        rest += i;
    }
    return 10 * (s[0] - 1) + rest;
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
        let t = Number(input[0][0]);
        let i = 1;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0][0]));
            t--;
            i++;
        }
    });
};

main()