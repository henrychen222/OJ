/**
 * 11.24 morning
 * https://codeforces.com/contest/1454/problem/D
 */

// Wrong  https://codeforces.com/contest/1454/submission/99489947
const solve = (num) => {
    let res = [];
    if (num % 2 == 0) {
        while ((num / 2) % 2 == 0) {
            res.push(2);
            num /= 2;
        }
    }
    res.push(num);
    k = res.length;
    console.log(k);
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
        input.push(Number(line));
    });
    rl.on('close', () => {
        let t = Number(input[0]);
        let i = 1;
        while (t > 0) {
            let data = input[i];
            solve(data);
            t--;
            i++;
        }
    });
};

main()