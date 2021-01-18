/**
 * 1.9 morning
 * https://atcoder.jp/contests/arc111/tasks/arc111_b
 */

// WA
const solve = (n, a) => {
    let map = new Map();
    for (const e of a) {
        if (e[0] == e[1]) {
            map.set(e[0], (map.get(e[0]) + 1) || 1);
        } else {
            map.set(e[0], (map.get(e[0]) + 1) || 1);
            map.set(e[1], (map.get(e[1]) + 1) || 1);
        }
    }
    // let res = Array(n).fill(0);
    let set = new Set();
    for (let i = 0; i < n; i++) {
        if (a[i][0] == a[i][1]) {
            // res[i] = a[i][0];
            set.add(a[i][0]);
        } else {
            if (set.has(a[i][0])) {
                if (set.has(a[i][1])) {
                    continue;
                } else {
                    // res[i] = a[i][1];
                    set.add(a[i][1]);
                }
            } else {
                if (set.has(a[i][1])) {
                    // res[i] = a[i][0];
                    set.add(a[i][0]);
                } else {
                    let freq0 = map.get(a[i][0]);
                    let freq1 = map.get(a[i][1]);
                    if (freq0 < freq1) {
                        // res[i] = a[i][0];
                        set.add(a[i][0]);
                    } else if (freq0 == freq1) { // problem don't know here, seems like is DP not greedy
                        set.add(a[i][1]);
                    } else {
                        // res[i] = a[i][1];
                        set.add(a[i][1]);
                    }
                }
            }
        }
        // console.log(set, res);
    }
    console.log(set.size);
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
        solve(input[0][0], input.slice(1));
    });
};

main()