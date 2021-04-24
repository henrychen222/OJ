/**
 * 1.4 morning
 * https://codeforces.com/contest/1472/problem/A
 */

// Accepted
const solve = (w, h, n) => {
    let cnt = 0;
    while (w % 2 == 0 || h % 2 == 0) {
        if (2 ** cnt >= n) return console.log('YES');
        if (w % 2 == 0) {
            w /= 2;
            cnt++;
        }
        if (h % 2 == 0) {
            h /= 2;
            cnt++;
        }
    }
    // console.log(2 ** cnt, n);
    if (2 ** cnt >= n) return console.log('YES');
    console.log('NO');
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
            let data = input[i];
            solve(data[0], data[1], data[2]);
            i++;
        }
    });
};

main()