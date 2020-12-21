/**
 * 12.20 morning
 * https://codeforces.com/contest/1465/problem/A
 */

// Pretests passed
const solve = (n, s) => {
    let cnt = 0;
    for (let i = n - 1; ; i--) {
        if (s[i] != ')') break;
        cnt++;
    }
    let res = cnt > (n - cnt) ? 'Yes' : 'No'
    console.log(res);
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
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            solve(input[i], input[i + 1]);
            i += 2;
        }
    });
};

main()