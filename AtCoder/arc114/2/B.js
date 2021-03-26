/**
 * 03/14/21 morning
 * https://atcoder.jp/contests/arc114/tasks/arc114_b
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

const solve = (len, a) => {
    let cnt = 0;
    let n = a.length;
    let N = 2 ** n;
    for (let i = 0; i < N; i++) {
        let data = [];
        let se = new Set();
        for (let j = 0; j < n; j++) {
            if (i & (1 << j)) {
                data.push([j + 1, a[j]]);
                se.add(j + 1);
            }
        }
        if (data.length == 0) continue;
        // pr(data);
        // if (c1ok(data, se, a) && c2ok(data)) cnt++;
        if (ok(data, se)) cnt++;
    }
    pr(cnt);
};

const ok = (d, se) => {
    let n = d.length;
    for (let i = 0; i < n; i++) {
        let a = d[i][0];
        let fa = d[i][1];
        if (!se.has(fa)) return false;
        for (let j = i + 1; j < n; j++) {
            let b = d[j][0];
            let fb = d[j][1];
            if (a == b) continue;
            if (fa == fb) return false;
        }
    }
    return true;
};

// const c1ok = (d, se) => {
//     // pr(se);
//     let n = d.length;
//     for (let i = 0; i < n; i++) {
//         let fa = d[i][1];
//         if (!se.has(fa)) return false;
//     }
//     return true;
// };

// const c2ok = (d) => {
//     let n = d.length;
//     for (let i = 0; i < n; i++) {
//         let a = d[i][0];
//         let fa = d[i][1];
//         for (let j = i + 1; j < n; j++) {
//             let b = d[j][0];
//             let fb = d[j][1];
//             if (a == b) continue;
//             if (fa == fb) return false;
//         }
//     }
//     return true;
// };

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
        solve(input[0][0], input[1]);
    });
};

main()