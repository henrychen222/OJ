/**
 * 12.4 morning
 * https://codeforces.com/contest/1453/problem/A
 */

// Pretests passed https://codeforces.com/contest/1453/submission/100363064
const solve = (n, m, bottom, left) => {
    // console.log(n, m, bottom, left);
    let cnt = 0;
    for (const i of bottom) {
        if (left.indexOf(i) != -1) {
            cnt++;
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
            let data = input.slice(i, i + 3);
            solve(data[0][0], data[0][1], data[1], data[2]);
            t--;
            i += 3;
        }
    });
};

main()