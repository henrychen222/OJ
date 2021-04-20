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
    let valid = Array(n).fill(0);
    for (let i = 1; i < n - 1; i++) {
        if (a[i - 1] + a[i + 1] == a[i] * 2) valid[i] = 1;
    }
    // pr(valid);
    let dp_left = Array(n).fill(0);
    let dp_right = Array(n).fill(0);
    for (let i = 1; i < n; i++) {
        if (valid[i]) dp_left[i] = dp_left[i - 1] + 1;
    }
    for (let i = n - 2; ~i; i--) {
        if (valid[i]) dp_right[i] = dp_right[i + 1] + 1;
    }
    // pr(dp_left, dp_right);
    let res = 0;
    for (let i = 0; i < n; i++) {
        res = mx(res, dp_left[i] + 3);
    }
    for (let i = 1; i < n - 1; i++) {
        let sum = a[i - 1] + a[i + 1];
        if (!(sum & 1)) {
            let v = sum >> 1;
            res = mx(res, 3);
            if (i - 2 >= 0 && v + a[i - 2] == 2 * a[i - 1]) {
                res = mx(res, dp_left[i - 2] + 4);
            }
            if (i + 2 < n && v + a[i + 2] == 2 * a[i + 1]) {
                res = mx(res, dp_right[i + 2] + 4);
            }
            if (i - 2 >= 0 && v + a[i - 2] == 2 * a[i - 1] && v + a[i + 2] == 2 * a[i + 1]) {
                res = mx(res, dp_left[i - 2] + dp_right[i + 2] + 5);
            }
        }
        // pr(res);
    }
    // pr(dp_left, dp_right);
    res = mi(res, n);
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