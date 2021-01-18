/**
 * 12.30 morning
 * https://codeforces.com/contest/1466/problem/0
 */

const solve = (n, a) => {
    let set = new Set();
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            let diff = a[j] - a[i];
            set.add(diff);
        }
    }
    console.log(set.size);
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