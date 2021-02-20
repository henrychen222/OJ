/**
 * 1.30 morning
 * https://atcoder.jp/contests/abc190/tasks/abc190_c
 * 
 * https://atcoder.jp/contests/abc190/submissions?f.User=uwi
 */

// Accepted --- 145ms https://atcoder.jp/contests/abc190/submissions/19823172
const solve = (n, m, ab, k, cd) => {
    let res = 0;
    for (let S = 0; S < (1 << k); S++) {
        let ball = Array(n + 1).fill(false);
        for (let i = 0; i < k; i++) {
            if (S >> i & 1) {
                ball[cd[i][1]] = true;
            } else {
                ball[cd[i][0]] = true;
            }
        }
        let cnt = 0;
        for (const e of ab) {
            if (ball[e[0]] && ball[e[1]]) cnt++;
        }
        res = Math.max(res, cnt);
    }
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
        let n = input[0][0];
        let m = input[0][1];
        solve(n, m, input.slice(1, 1 + m), input[1 + m][0], input.slice(2 + m));
    });
};

main()