/**
 * 02/21/21 morning
 * https://atcoder.jp/contests/arc113/tasks/arc113_c
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// WA
// const solve1 = (s) => {
//     let n = s.length;
//     let a = s.split("");

//     let record = [s];
//     while (true) {
//         for (let i = 1; i < n - 1; i++) {
//             if (a[i - 1] == a[i] && a[i] != a[i + 1]) {
//                 a[i + 1] = a[i - 1];
//                 break;
//             }
//         }
//         let tmp = a.join("");
//         if (tmp == record[record.length - 1]) break;
//         record.push(tmp);
//     }
//     pr(record.length - 1);
// };

// TLE  AC: 15
// const solve2 = (s) => {
//     let n = s.length;
//     let repeat = [];
//     for (let i = 1; i < n - 1; i++) {
//         if (s[i - 1] == s[i] && s[i] != s[i + 1]) {
//             repeat.push(i - 1);
//         }
//     }
//     // pr(repeat);
//     let nr = repeat.length;
//     let res = 0;
//     for (let i = nr - 1; ~i; i--) {
//         // pr(s);
//         let cnt = 0;
//         for (let j = repeat[i]; j < n; j++) {
//             if (s[repeat[i]] == s[j]) continue;
//             cnt++;
//         }
//         res += cnt;
//         let invasion = '';
//         for (let k = 1; k <= n - repeat[i] - 1; k++) {
//             invasion += s[repeat[i]];
//         }
//         // pr(invasion);
//         s = s.slice(0, repeat[i] + 2) + invasion;
//     }
//     pr(res);
// };


// TLE AC: 16/25  algorithm is correct   fuck 2207ms > 2000ms
const solve = (s) => {
    let n = s.length;
    let repeat = [];
    let a = s.split("");
    for (let i = 1; i < n - 1; i++) {
        if (a[i - 1] == a[i] && a[i] != a[i + 1]) {
            repeat.push(i - 1);
        }
    }
    let nr = repeat.length;
    let res = 0;
    for (let i = nr - 1; ~i; i--) {
        let cnt = 0;
        for (let j = repeat[i]; j < n; j++) {
            if (a[repeat[i]] == a[j]) continue;
            cnt++;
        }
        res += cnt;
        for (let k = repeat[i] + 2; k < n; k++) {
            a[k] = a[repeat[i]];
        }
    }
    pr(res);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(line);
    });
};

main()