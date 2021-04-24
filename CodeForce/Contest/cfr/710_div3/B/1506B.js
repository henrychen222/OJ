/**
 * 03/25/21 morning
 * https://codeforces.com/contest/1506/problem/B
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 61ms https://codeforces.com/contest/1506/submission/111075227
const solve = (n, k, s) => {
    let star = [];
    for (let i = 0; i < n; i++) {
        if (s[i] == '*') star.push(i);
    }
    let len = star.length;
    let res = 1;
    for (let i = 0; i != len - 1;) {
        let j;
        for (j = i + 1; j < len; j++) {
            if (star[j] - star[i] > k) break;
            // pr(i, j);
        }
        res++;
        j--;
        i = j;
    }
    pr(res);
};

// don't know
const solve1 = (n, k, s) => {
    // pr(n, k, s);
    let star = [];
    for (let i = 0; i < n; i++) {
        if (s[i] == '*') star.push(i);
    }
    // pr(star)
    let len = star.length;
    if (len <= 2) return pr(len);
    let check = new Set(star);
    let max = star[len - 1];
    let res = 0;
    for (let i = 0; i < len; i++) {
        let used = new Set();
        for (let next = star[i]; next <= max; next += k) { // close here
            if (check.has(next) && !used.has(star[next])) {
                used.add(next);
                res = Math.max(res, used.size);
            }
        }
    }
    pr(len - res);
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