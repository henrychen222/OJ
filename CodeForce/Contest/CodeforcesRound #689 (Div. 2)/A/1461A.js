/**
 * 12.11 morning
 * https://codeforces.com/contest/1461/problem/A
 */

// Pretests passed https://codeforces.com/contest/1461/submission/100930993https://codeforces.com/contest/1461/submission/100930993
const solve = (n, k) => {
    let t = Math.floor(n / 3);
    let s = 'acb';
    s = s.repeat(t);
    if (n % 3 == 1) {
        s += 'a';
    } else if (n % 3 == 2) {
        s += 'ac';
    }
    console.log(s);
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
        while (t > 0) {
            let data = input.slice(i, i + 1);
            solve(data[0][0], data[0][1]);
            t--;
            i++;
        }
    });
};

main()