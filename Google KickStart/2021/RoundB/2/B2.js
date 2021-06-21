/**
 * 04/18/21 evening
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a3a5
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

// Sample pass, TLE
const solve = (n, a) => {
    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            let len = j - i + 1;
            if (len <= 3) {
                res = mx(res, len);
            } else {
                let sub = a.slice(i, j + 1);
                let coll = calDiff(sub);
                let fd = sub[1] - sub[0]
                let sd = sub[2] - sub[1];
                let compare1 = Array(len).fill(fd);
                let compare2 = Array(len).fill(sd);
                if (comp(coll, compare1) <= 2 || comp(coll, compare2) <= 2) {
                    res = mx(res, len);
                }
            }
        }
    }
    return res;
};

const comp = (a, b) => {
    let n = a.length;
    let cnt = 0;
    for (let i = 0; i < n; i++) {
        if (a[i] != b[i]) cnt++;
    }
    return cnt;
};

const calDiff = (a) => {
    let n = a.length;
    let coll = [];
    for (let i = 1; i < n; i++) {
        let diff = a[i] - a[i - 1];
        coll.push(diff);
    }
    return coll;
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