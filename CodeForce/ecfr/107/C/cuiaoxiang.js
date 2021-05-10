// 04/12/21 afternoon  

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 280ms https://codeforces.com/contest/1511/submission/115825081
const N = 60;
const solve = (n, q, a, t) => {
    // let pos = Array(n).fill(-1);
    let pos = Array(N).fill(-1); // 05/09/21 evening fix bug of N
    for (let i = 0; i < n; i++) {
        if (pos[a[i]] < 0) pos[a[i]] = i;
    }
    let res = '';
    for (let k = 0; k < q; k++) {
        res += pos[t[k]] + 1;
        res += ' '
        // pr(pos, pos[t[k]], t[k])
        for (let i = 1; i < 60; i++) {
            if (pos[i] >= 0 && pos[i] < pos[t[k]]) {
                pos[i]++;
            }
        }
        pos[t[k]] = 0;
    }
    pr(res)
};

// Accepted --- 265ms https://codeforces.com/contest/1511/submission/115825195
const solve1 = (n, q, a, t) => {
    // let pos = Array(n).fill(-1);
    let pos = Array(N).fill(-1); // 05/09/21 evening fix bug of N
    for (let i = 0; i < n; i++) {
        if (pos[a[i]] < 0) pos[a[i]] = i;
    }
    let res = [];
    for (let k = 0; k < q; k++) {
        res.push(pos[t[k]] + 1);
        for (let i = 1; i < 60; i++) {
            if (pos[i] >= 0 && pos[i] < pos[t[k]]) {
                pos[i]++;
            }
        }
        pos[t[k]] = 0;
    }
    pr(res.join(" "))
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
        solve(input[0][0], input[0][1], input[1], input[2])
    });
};

main()