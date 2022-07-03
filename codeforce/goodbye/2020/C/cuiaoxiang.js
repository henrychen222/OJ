// 09/06/21 night

const pr = console.log;

// Accepted --- https://codeforces.com/problemset/submission/1466/128099875 608ms
const solve = (s) => {
    let n = s.length, res = 0;
    let a = s.split("");
    for (let i = 0; i < n; i++) {
        if ((i - 1 >= 0 && a[i] == a[i - 1]) || (i - 2 >= 0 && a[i] == a[i - 2])) {
            res++;
            a[i] = '?';
        }
    }
    // pr(a.join(""))
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
        input.push(line);
    });
    rl.on('close', () => {
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()