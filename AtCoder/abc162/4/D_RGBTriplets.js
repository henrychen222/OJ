/**
 * 10.13 morning
 * https://atcoder.jp/contests/abc162/tasks/abc162_c
 */

// // don't 
// const solve3 = (data) => {
//     let N = Number(data[0]);
//     let S = data[1];
//     let cnt = 0;
//     let R = [];
//     let G = [];
//     let B = [];
//     for (let i = 0; i < N; i++) {
//         if (S[i] == 'R') {
//             R.push(i);
//         } else if (S[i] == 'G') {
//             G.push(i);
//         } else {
//             B.push(i);
//         }
//     }
//     console.log(R, G, B);
//     for (const i of R) {
//         for (const j of G) {
//             if (i < j) {
//                 for (const k of B) {
//                     if (j < k) {
//                         if ((j - i) != (k - j)) cnt++;
//                     }
//                 }
//             }
//         }
//     }
//     console.log(cnt, cnt * 3);
// };

// Time limit 2206ms
const solve2 = (data) => {
    let N = Number(data[0]);
    let S = data[1];
    let cnt = 0;
    for (let i = 0; i < N; i++) {
        for (let j = i + 1; j < N; j++) {
            if (S[i] != S[j]) {
                for (let k = j + 1; k < N; k++) {
                    if (S[i] != S[k]) {
                        if (S[j] != S[k]) {
                            if ((j - i) != (k - j)) {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
    }
    return cnt;
};

// Time limit 2206ms
const solve = (data) => {
    let N = Number(data[0]);
    let S = data[1];
    let cnt = 0;
    for (let i = 0; i < N; i++) {
        for (let j = i + 1; j < N; j++) {
            if (S[i] == S[j]) continue;
            for (let k = j + 1; k < N; k++) {
                if (S[i] == S[k] || S[j] == S[k]) continue;
                if ((j - i) == (k - j)) continue;
                cnt++;
            }
        }
    }
    return cnt;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let data = [];
    rl.on('line', (line) => {
        data.push(line);
    });

    rl.on('close', () => {
        console.log(solve(data));
    });
};

// main()

const test = () => {
    let data = ['4', 'RRGB'];
    let data2 = ['39', 'RBRBGRBGGBBRRGBBRRRBGGBRBGBRBGBRBBBGBBB'];
    console.log(solve(data));
    console.log(solve(data2));
};

test()
