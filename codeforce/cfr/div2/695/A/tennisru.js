// 1.17 evening

// Accepted https://codeforces.com/contest/1467/submission/104628714
const solve = (n) => {
    let a = [];
    if (n === 1) return console.log('9');
    if (n === 2) return console.log('98');
    if (n === 3) return console.log('989');
    a.push('989')
    for (let i = 3; i < n; i++) {
        a.push(Math.abs(3 - i) % 10);
    }
    console.log(a.join(""));
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
            solve(input[i][0]);
            i++;
        }
    });
};

main()