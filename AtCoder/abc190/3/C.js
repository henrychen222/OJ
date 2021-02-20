/**
 * 1.30 morning
 * https://atcoder.jp/contests/abc190/tasks/abc190_c
 */

// WA
const solve = (n, m, ab, k, cd) => {
    // console.log(n, m, ab, k, cd);
    let ball = Array(n).fill(false);
    let ma = new Map();
    for (const e of ab) {
        ma.set(e[0], ma.get(e[0]) + 1 || 1);
        ma.set(e[1], ma.get(e[1]) + 1 || 1);
    }
    // console.log(ma, ball);
    let selected = new Set();
    for (const e of cd) {
        let c = e[0];
        let d = e[1];
        let fc = ma.get(c);
        let fd = ma.get(d);
        if (ball[c - 1]) {
            if (ball[d - 1]) {
                continue;
            } else {
                ball[d - 1] = true;
                selected.add(d);
            }
        } else {
            if (ball[d - 1]) {
                ball[c - 1] = true;
                selected.add(c);
            } else {
                if (fc > fd) {
                    ball[c - 1] = true;
                    selected.add(c);
                } else if (fc < fd) {
                    ball[d - 1] = true;
                    selected.add(d);
                } else {
                    ball[c - 1] = true;
                    selected.add(c);
                }
            }
        }
    }
    console.log(ball, selected);
    let cnt = 0;
    for (const e of ab) {
       if (ball[e[0] - 1] && ball[e[1] - 1]) cnt++;
    }
    console.log(cnt);
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
        let n = input[0][0];
        let m = input[0][1];
        solve(n, m, input.slice(1, 1 + m), input[1 + m][0], input.slice(2 + m));
    });
};

main()