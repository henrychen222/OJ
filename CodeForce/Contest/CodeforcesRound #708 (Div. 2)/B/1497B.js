/**
 * 03/17/21 morning
 * https://codeforces.com/contest/1497/problem/B
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// TLE on pretest 2
const solve = (n, m, a) => {
    // pr(n, m, a)
    let ma = new Map();
    for (const e of a) {
        ma.set(e, ma.get(e) + 1 || 1);
    }
    // pr(ma, u)
    let d = [];
    for (let [k,] of ma) {
        for (let [k2,] of ma) {
            // pr(k, k2, ma);
            let v = ma.get(k);
            let v2 = ma.get(k2);
            let sum = k + k2;
            if (k != k2) {
                if (v >= 1 && v2 >= 1) {
                    if (sum % m == 0) {
                        // pr(k, k2)
                        d.push(new Set([k, k2]))
                        ma.set(k, v - 1);
                        ma.set(k2, v2 - 1);
                    }
                }
            } else {
                if (v >= 2) {
                    if (sum % m == 0) {
                        d.push(new Set([k, k]))
                        ma.set(k, v - 2);
                    }
                }
            }
        }
    }
    // pr(d, ma);
    for (const [k,] of ma) {
        let v = ma.get(k);
        if (v == 0) continue;
        for (let se of d) {
            for (const e of se) {
                let sum = e + k;
                if (sum % m == 0) {
                    se.add(k);
                    ma.set(k, v - 1);
                }
            }
        }
    }
    let rest = 0;
    for (const [, v] of ma) {
        if (v > 0) rest += v;
    }
    // pr(d, ma,rest);
    pr(d.length + rest);
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
        while (t--) {
            solve(input[i][0], input[i][1], input[i + 1]);
            i += 2;
        }
    });
};

main()

// a.sort((x, y) => x - y);
// for (let i = 0; i < n; i++) {
//     let tmp = [a[i]];
//     for (let j = i+1; j < n; j++) {
//         let sum = a[j - 1] + a[j];
//         if (sum % m == 0) {
//            tmp.push(a[j]);
//         } else {
//             break;
//         }
//     }
//     pr(tmp);
//     res += tmp.length;
// }