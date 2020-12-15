/**
 * 12.15 morning
 * https://codeforces.com/contest/1462/problem/E1
 */

// TLE
const solve = (n, arr) => {
    let cnt = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            for (let k = j + 1; k < n; k++) {
                let min = Math.min(arr[i], arr[j], arr[k]);
                let max = Math.max(arr[i], arr[j], arr[k]);
                if (max - min <= 2) cnt++;
            }
        }
    }
    console.log(cnt);
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
        while (t > 0) {
            let data = input.slice(i, i + 2);
            solve(data[0][0], data[1]);
            t--;
            i += 2;
        }
    });
};

main()