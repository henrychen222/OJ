// 09/06/21 night

const pr = console.log;

// Accepted --- https://codeforces.com/problemset/submission/1466/128099220 217ms
const solve = (n, a) => {
    // pr(n, a);
    let res = 1; pre = a[0];
    for (let i = 1; i < n; i++) {
        if (a[i] < pre) continue;
        if (a[i] == pre) a[i]++;
        res++;
        pre = a[i];
    }
    pr(res)
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
            solve(data[0][0], data[1]);
            i += 2;
        }
    });
};

main()
