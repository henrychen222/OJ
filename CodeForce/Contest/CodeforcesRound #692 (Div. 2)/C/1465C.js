/**
 * 12.20 morning
 * https://codeforces.com/contest/1465/problem/C
 */

// don't know
const solve = (n, m, a) => {
    console.log(n, m, a);
    let tmp1 = [...a].sort((a, b) => b[0] - a[0]);
    let tmp2 = [...a].sort((a, b) => b[1] - a[1]);
    let maxRow = tmp1[0][0];
    let maxCol = tmp2[0][1];
    console.log(maxRow, maxCol);
    for (const e of a) {
        let d1 = [e[0], e[0]];
        let d2 = [e[1], e[1]];
    }
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
            let n = input[i][0];
            let m = input[i][1];
            solve(n, m, input.slice(i + 1, i + m + 1));
            i += m + 1;
        }
    });
};

main()