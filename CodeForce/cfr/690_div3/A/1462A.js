/**
 * 12.15 morning
 * https://codeforces.com/contest/1462/problem/A
 */

// Accepted
const solve = (n, arr) => {
    let res = [];
    while (arr.length != 0) {
        if (arr.length == 1) {
            res.push(arr[0]);
            arr.pop();
        } else {
            res.push(arr[0]);
            res.push(arr[arr.length - 1]);
            arr.shift();
            arr.pop();
        }
    }
    console.log(res.join(" "));
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