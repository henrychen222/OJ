/**
 * 03/10/21 morning  + evening
 * https://codeforces.com/contest/1496/problem/0
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// WA
// const solve = (n, k, s) => {
//     // pr(n, k, s)
//     if (k == 0) return pr('YES');
//     for (let i = 0; i < n; i++) {
//         let left = s.slice(0, i);
//         let right = reverse2(s.slice(i + 1));
//         if (left == right) return pr('YES');
//     }
//     pr('NO');
// };

// WA
// const solve = (n, k, s) => {
//     if (k == 0) return pr('YES');
//     for (let i = 0; i < n; i++) {
//         let left = reverse2(s.slice(0, i));
//         let right = s.slice(i + 1);
//         if (left == right) return pr('YES');
//     }
//     pr('NO');
// };

// Accepted --- https://codeforces.com/contest/1496/submission/109668825  from author: grey
const solve1 = (n, k, s) => {
    if (k * 2 >= n) return pr('NO');
    let left = s.substr(0, k);
    let right = reverse2(s.substr(n - k, k));
    if (left == right) return pr('YES');
    pr('NO');
};

// Accepted --- 46ms https://codeforces.com/contest/1496/submission/109668825
const solve = (n, k, s) => {
    if (k * 2 >= n) return pr('NO');
    let left = s.slice(0, k);
    let right = reverse2(s.slice(n - k));
    if (left == right) return pr('YES');
    pr('NO');
};

const reverse2 = (s) => {
    let res = "";
    for (let i = s.length - 1; i >= 0; i--) {
        res += s[i];
    }
    return res;
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
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            let tmp = input[i].split(" ").map(Number);
            solve(tmp[0], tmp[1], input[i + 1]);
            i += 2;
        }
    });
};

main()