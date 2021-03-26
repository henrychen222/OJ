// 03/25/21 night

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 202ms https://codeforces.com/contest/1497/submission/111106432
const solve = (n, k) => {
    let m = n;
    while (m % 2 == 0) m >>= 1;
    if (m > 1) {
        pr(`${(n / m >> 0) * (m >> 1)} ${(n / m >> 0) * (m >> 1)} ${n / m >> 0}`)
    } else {
        pr(`${n >> 2} ${n >> 2} ${n >> 1}`)
    }
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
            solve(input[i][0], input[i][1]);
            i++;
        }
    });
};

main()


// pr(94 / 4 >> 0, 94 >> 1 >> 1, 94 >> 2)