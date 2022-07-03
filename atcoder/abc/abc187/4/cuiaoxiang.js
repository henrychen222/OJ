// 1.2 night

// Accepted https://atcoder.jp/contests/abc187/submissions/19180971
const solve = (n, a) => {
    let diff = 0;
    for (const e of a) {
        diff -= e[0];
    }
    a.sort((x, y) => (y[0] * 2 + y[1]) - (x[0] * 2 + x[1]));
    let res;
    for (let i = 0; i < n; i++) {
        diff += 2 * a[i][0] + a[i][1];
        if (diff > 0) {
            res = i + 1;
            break;
        }
    }
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
        input.push(line.split(" ").map(x => Number(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input.slice(1));
    });
};

main()