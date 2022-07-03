/**
 * 1.2 morning
 * https://atcoder.jp/contests/abc187/tasks/abc187_c
 * 
 * don't understand the question at first:  不能有s和!s共存
 */

// wrong https://atcoder.jp/contests/abc187/submissions/19147490
// const solve1 = (n, s) => {
//     for (let i = 1; i < n; i++) {
//         if (ok(s[i - 1], s[i])) {
//             return console.log(s[i - 1]);
//         }
//     }
//     console.log('satisfiable');
// };

// wrong https://atcoder.jp/contests/abc187/submissions/19159675
// const solve2 = (n, s) => {
//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < n; j++) {
//             if (i == j) continue;
//             if (ok(s[i], s[j])) return console.log(s[i]);
//         }
//     }
//     console.log('satisfiable');
// };

// TLE https://atcoder.jp/contests/abc187/submissions/19180610
const solve = (n, arr) => {
    let A = new Set();
    let B = new Set();
    for (const s of arr) {
        if (s[0] == '!') {
            A.add(s);
        } else {
            B.add(s);
        }
    }
    for (const x of B) {
        for (const y of A) {
            if (ok(x, y)) return console.log(x);
        }
    }
    console.log('satisfiable');
};

const ok = (s1, s2) => {
    if (s2.slice(1) == s1 && s2[0] == '!') return true;
    if (s1.slice(1) == s2 && s1[0] == '!') return true;
    return false;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line);
    });
    rl.on('close', () => {
        solve(Number(input[0]), input.slice(1));
    });
};

main()