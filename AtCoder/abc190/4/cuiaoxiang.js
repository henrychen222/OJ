/**
 * 1.30 morning
 * https://atcoder.jp/contests/abc190/tasks/abc190_d
 * 
 * https://atcoder.jp/contests/abc190/submissions?f.User=cuiaoxiang
 */

// Accepted --- 225ms https://atcoder.jp/contests/abc190/submissions/19824918
// const solve = (N) => {
//     N *= 2;
//     let cnt = 0;
//     for (let k = 1; k * k <= N; k++) {
//         if (N % k == 0) {
//             let u = k;
//             let v = Math.floor(N / k);
//             if ((u + v) % 2 == 0) continue;
//             let y = Math.floor((u + v - 1) / 2);
//             let x = u - y;
//             if (y >= x) cnt++;
//             if (u != v) {
//                 [u, v] = [v, u];
//                 let y = Math.floor((u + v - 1) / 2);
//                 let x = u - y;
//                 if (y >= x) cnt++;
//             }
//         }
//     }
//     console.log(cnt);
// };

// Accepted --- 104ms https://atcoder.jp/contests/abc190/submissions/19824973  parseInt faster than Math.floor
const solve = (N) => {
    N *= 2;
    let cnt = 0;
    for (let k = 1; k * k <= N; k++) {
        if (N % k == 0) {
            let u = k;
            let v = parseInt(N / k);
            if ((u + v) % 2 == 0) continue;
            let y = parseInt((u + v - 1) / 2);
            let x = u - y;
            if (y >= x) cnt++;
            if (u != v) {
                [u, v] = [v, u];
                let y = parseInt((u + v - 1) / 2);
                let x = u - y;
                if (y >= x) cnt++;
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
    rl.on('line', (line) => {
        solve(Number(line));
    });
};

main()