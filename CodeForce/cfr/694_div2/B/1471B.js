/**
 * 1.5 morning
 * https://codeforces.com/contest/1471/problem/B
 */

// TLE
const solve = (n, x, a) => {
    for (let i = 0; i < a.length;) {
        // console.log(a, a[i]);
        if (a[i] % x == 0) {
            // for (let t = 1; t <= x; t++) { // MLE
            //     a.push(a[i] / x);
            // }
            a = a.concat(Array(x).fill(a[i] / x));
            i++;
        } else {
            break;
        }
    }
    let res = a.reduce((x, y) => x + y);
    console.log(res);
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
            solve(data[0][0], data[0][1], data[1]);
            i += 2;
        }
    });
};

main()