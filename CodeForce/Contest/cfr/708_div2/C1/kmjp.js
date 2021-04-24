// 03/25/21 night

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 233ms https://codeforces.com/contest/1497/submission/111105253
const solve = (n, k) => {
    let res = [];
    for (let i = 0; i < k - 3; i++) {
        res.push(1);
        n--;
    }
    if (n % 2 == 1) {
        res.push(1);
        res.push(n >> 1);
        res.push(n >> 1);
    } else if (n % 4 == 2) {
        res.push(2);
        res.push(n - 2 >> 1);
        res.push(n - 2 >> 1);
    } else {
        res.push(n / 4 >> 0);
        res.push(n / 4 >> 0);
        res.push(n >> 1);
    }
    pr(res.join(" "))
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
