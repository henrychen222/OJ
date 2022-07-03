/**
 * 11.24 morning
 * https://codeforces.com/contest/1454/problem/A
 */

// Accepted --- https://codeforces.com/contest/1454/submission/99468024
const solve = (p) => {
    let res = [];
    for (let i = 1; i <= p; i++) {
        res.unshift(i);
    }
    if (p % 2 == 1) {
        let mid = p >> 1;
        [res[mid], res[mid + 1]] = [res[mid + 1], res[mid]];
    }
    console.log(res.join(" "));
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
            solve(data[0][0]);
            t--;
            i++;
        }
    });
};

main()