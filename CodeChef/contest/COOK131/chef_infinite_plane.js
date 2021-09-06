///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;

// 07/28/21 afternoon
// test for node.js vs Java
// TLE https://www.codechef.com/viewsolution/49219835
// https://www.codechef.com/viewsolution/49188962
const solve = (n, a) => {
    // pr(n, a)
    let cnt = Array(100005).fill(0);
    for (const e of a) cnt[e]++;
    let res = 0;
    for (let i = 0; i < 100005; i++) {
        if (cnt[i] == 0) continue;
        let maxDivide = i - 1;
        if (maxDivide >= cnt[i]) {
            res += cnt[i];
        } else {
            res += maxDivide;
        }
    }
    pr(res);
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
        pr(input)
        while (t--) {
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()