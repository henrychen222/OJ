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

// const solve = (n, a) => {
//     // pr(n, a, calDiff(a))
//     if (isArithmetic(a)) return n;
//     let res = 0;
//     for (let i = 0; i < n; i++) {
//         for (let j = i; j < n; j++) {
//             let len = j - i + 1;
//             let sub = a.slice(i, j + 1);
//             let tmp = calDiff(sub);
//             let coll = tmp[0];
//             let m = tmp[1];
//             let finalDiff = m.keys().next().value;
//             pr(sub, coll, finalDiff);
//             let se = new Set(coll);
//             if (len <= 2) {
//                 res = mx(res, len);
//             } else {
//                 if (se.size <= 3) {
//                     res = mx(res, len);
//                 }
//             }
//         }
//     }
//     return res;
// };

// Sample pass, TLE
const solve = (n, a) => {
    // pr(n, a, calDiff(a))
    // if (isArithmetic(a)) return n;
    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            let len = j - i + 1;
            if (len <= 3) {
                res = mx(res, len);
            } else {
                let sub = a.slice(i, j + 1);
                let tmp = calDiff(sub);
                let coll = tmp[0];
                let m = tmp[1];
                let finalDiff = m.keys().next().value;
                let compare = Array(len).fill(finalDiff);
                // pr(sub, coll, finalDiff, compare);
                if (comp(coll, compare) <= 2) {
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
    let m = new Map();
    for (let i = 1; i < n; i++) {
        let diff = a[i] - a[i - 1];
        coll.push(diff);
        m.set(diff, m.get(diff) + 1 || 1);
    }
    m = sortMapByValue(m);
    return [coll, m];
};

const sortMapByValue = (map) => {
    return new Map([...map].sort((a, b) => b[1] - a[1]));
};

const isArithmetic = (a) => {
    let n = a.length;
    for (let i = 1; i < n - 1; i++) {
        let ld = a[i] - a[i - 1];
        let rd = a[i + 1] - a[i];
        if (ld != rd) return 0;
    }
    return 1;
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