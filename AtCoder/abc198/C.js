/**
 * 04/11/21 morning
 * https://atcoder.jp/contests/abc198/tasks/abc198_c
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const sq = Math.sqrt;
const ce = Math.ceil;
///////////////////////////////////////////////////////////////////////////////////

// Accepted  04/12/21 afternoon
// reference: https://atcoder.jp/contests/abc198/submissions?f.User=cuiaoxiang
const solve = (r, x, y) => {
    let dis = sq(x * x + y * y);
    if (dis < r) return pr(2); // lack this
    dis % r == 0 ? pr(dis / r) : pr((dis / r + 1) >> 0);
};

// WA
// const solve = (r, x, y) => {
//     let dis = sq(x * x + y * y);
//     let rest = dis - (dis >> 0);
//     dis >>= 0;
//     // pr(dis, rest);
//     if (dis % r == 0) return pr(dis / r);
//     let cnt = dis / r >> 0;
//     let rest2 = dis / r - cnt;
//     let frest = rest + rest2 + dis % r;
//     // pr(cnt, frest);
//     let max = sq(2) * r;
//     if (frest <= max) return pr(cnt + 1);
//     pr(cnt + 2);
// };

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
        solve(input[0][0], input[0][1], input[0][2]);
    });
};

main()