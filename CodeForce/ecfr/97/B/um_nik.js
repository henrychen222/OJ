// 10.27 afternoon

// Accepted --- 77ms https://codeforces.com/contest/1437/submission/96941277
const solve = (s) => {
    let n = s.length;
    let res = 0;
    for (let i = 0; i + 1 < n; i++) {
        if (s[i] == s[i + 1]) {
            res++;
        }
    }
    return (res + 1) >> 1;
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
        let i = 2;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0]));
            t--;
            i += 2;
        }
    });
};

main()