/**
 * 1.10 morning
 * https://atcoder.jp/contests/abc188/tasks/abc188_c
 */

// Accepted
const solve = (n, a) => {
    let origin = [...a];
    while (a.length > 2) {
        let tmp = [];
        for (let i = 0; i < a.length / 2; i++) {
            let p1 = a[2 * i];
            let p2 = a[2 * i + 1];
            // console.log(p1, p2);
            tmp.push(Math.max(p1, p2));
        }
        a = tmp;
    }
    // console.log(a);
    console.log(origin.indexOf(Math.min(a[0], a[1])) + 1);
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
        solve(input[0][0], input[1]);
    });
};

main()