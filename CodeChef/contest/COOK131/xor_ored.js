///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;

// 07/28/21 afternoon
// test for node.js vs Java
// Accepted --- https://www.codechef.com/viewsolution/49219746 0.09sec
// https://www.codechef.com/viewsolution/49164662 0.20sec
const solve = (n, a) => {
    let min = Number.MAX_SAFE_INTEGER, max = 0;
    for (const e of a) {
        min = Math.min(min, e);
        max = Math.max(max, e);
    }
    let res1 = cal(a, min);
    let res2 = cal(a, max);
    if (res1 < res2) {
        pr(min, res1);
    } else {
        pr(max, res2);
    }
};

const cal = (a, x) => {
    let res = 0;
    for (const e of a) {
        res |= (e ^ x);
    }
    return res;
}

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
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()