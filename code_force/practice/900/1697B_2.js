// 07/02/22 night
// Accepted --- https://codeforces.com/problemset/submission/1697/162632968 1699ms

const pr = console.log;

const preSum = (a) => { let pre = [0]; for (let i = 0; i < a.length; i++) { pre.push(pre[i] + a[i]); } return pre; };
const subArraySum = (a, l, r) => a[r + 1] - a[l];

const solve = (n, q, a, query) => {
    a.sort((x, y) => y - x);
    let pre = preSum(a);
    for (const [x, y] of query) {
        let r = x - 1, l = Math.max(0, x - y);
        let sum = subArraySum(pre, l, r);
        pr(sum);
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
        solve(input[0][0], input[0][1], input[1], input.slice(2));
    });
};

main()