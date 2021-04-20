// 04/19/21 afternoon

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (n, a) => {
    let diff = [];
    for (let i = 0; i < n - 1; i++) diff.push(a[i + 1] - a[i]);
    return mx(operate(diff), operate(diff.reverse())); // reverse() for decreasing order
};

const operate = (diff) => {
    let n = diff.length;
    let res = 0;
    for (let i = 0, j = 0; i < n; i = j) { // sliding window, [i, j]
        while (j < n && diff[i] == diff[j]) j++;
        res = mx(res, j - i + 1);
        if (j < n) {
            res = mx(res, j - i + 2);
        }
        if (j < n - 1 && diff[j] + diff[j + 1] == 2 * diff[i]) {
            let end = j + 2;
            while (end < n && diff[end] == diff[i]) end++;
            res = mx(res, end - i + 1);
        }
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
        input.push(line.split(" ").map(x => Number(x)));
    });
    rl.on('close', () => {
        let t = input[0][0];
        let i = 1;
        for (let cas = 1; cas <= t; cas++) {
            let show = solve(input[i][0], input[i + 1]);
            pr('Case #' + cas + ': ' + show);
            i += 2;
        }
    });
};

main()