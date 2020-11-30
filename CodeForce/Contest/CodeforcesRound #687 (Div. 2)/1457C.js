/**
 * 11.28 evening
 * https://codeforces.com/contest/1457/problem/C
 */

// feel hard to understand the question
const solve = (n, p, k, s, x, y) => {
    console.log(n, p, k, s, x, y);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" "));
    });
    rl.on('close', () => {
        let t = Number(input[0][0]);
        let i = 1;
        while (t > 0) {
            let data = input.slice(i, i + 3);
            solve(Number(data[0][0]), Number(data[0][1]), Number(data[0][2]), data[1][0], Number(data[2][0]), Number(data[2][1]));
            t--;
            i += 3;
        }
    });
};

main()