/**
 * 10.13 morning
 * https://atcoder.jp/contests/abc162/tasks/abc162_d
 */

// Accepted --- 209ms
// https://atcoder.jp/contests/abc162/submissions/17388349
const solve = (data) => {
    let N = Number(data[0]);
    let S = data[1];
    let record = getRecord(S);
    let cnt = (record['R'] || 0) * (record['G'] || 0) * (record['B'] || 0);
    for (let i = 0; i < N; i++) {
        for (let j = i + 1; j < N; j++) {
            let koppo = 2 * j - i;
            if (S[i] != S[j] && (koppo < N) && (S[i] != S[koppo]) && (S[j] != S[koppo])) {
                cnt--;
            }
        }
    }
    return cnt;
};

const getRecord = (s) => {
    let map = {};
    for (const i of s) {
        if (map.hasOwnProperty(i)) {
            map[i]++;
        } else {
            map[i] = 1;
        }
    }
    return map;
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

main()

// const test = () => {
//     let data = ['4', 'RRGB'];
//     let data2 = ['39', 'RBRBGRBGGBBRRGBBRRRBGGBRBGBRBGBRBBBGBBB'];
//     let debug1 = ['10', 'RRRRRRRRRR'];
//     console.log(solve(data));
//     console.log(solve(data2));
//     console.log(solve(debug1));
// };

// test()
