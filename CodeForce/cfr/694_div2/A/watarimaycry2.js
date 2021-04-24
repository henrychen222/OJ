// 1.17 evening

// Accepted --- 93ms https://codeforces.com/contest/1471/submission/104630308
const solve1 = (n, x, a) => {
    let max = 0;
    let sum = a.reduce((x, y) => x + y);
    for (const item of a) {
        max += Math.ceil(item / x);
    }
    let min = Math.ceil(sum / x);
    console.log(min, max);
};

// Accepted --- 108ms https://codeforces.com/contest/1471/submission/104630377
const solve2 = (n, x, a) => {
    let max = sum = 0;
    for (const item of a) {
        sum += item;
        max += Math.ceil(item / x);
    }
    let min = Math.ceil(sum / x);
    console.log(min, max);
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
            let data = input.slice(i, i + 2);
            solve(data[0][0], data[0][1], data[1]);
            i += 2;
        }
    });
};

main()
