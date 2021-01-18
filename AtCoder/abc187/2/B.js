/**
 * 1.2 morning
 * https://atcoder.jp/contests/abc187/tasks/abc187_b
 */

// Accepted
const solve = (n, a) => {
    let cnt = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
           if (ok(a[i], a[j])) cnt++;
        }
    }
    console.log(cnt);
};

const ok = (pi, pj) => {
   let k = (pj[1] - pi[1]) / (pj[0] - pi[0])
   if (k >= -1 && k <= 1) return true;
   return false;
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