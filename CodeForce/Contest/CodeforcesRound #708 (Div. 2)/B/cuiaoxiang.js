// 03/25/21 night

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mx = Math.max;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 124ms https://codeforces.com/contest/1497/submission/111104071
const solve = (n, m, a) => {
    let cnt = Array(m).fill(0);
    for (const e of a) cnt[e % m]++;
    let res = 0;
    for (let i = 0; i <= m >> 1; i++) {
        let j = (m - i) % m;
        if (!cnt[i] && !cnt[j]) continue;
        if (i != j) {
            res += mx(1, cnt[i] >= cnt[j] ? cnt[i] - cnt[j] : cnt[j] - cnt[i]);
        } else {
            res++;
        }
    }
    pr(res)
};

// Accepted --- 124ms https://codeforces.com/contest/1497/submission/111103798
const solve2 = (n, m, a) => {
    let cnt = Array(m).fill(0);
    for (const e of a) cnt[e % m]++;
    let res = 0;
    for (let i = 0; i <= m >> 1; i++) {
        let j = (m - i) % m;
        if (!cnt[i] && !cnt[j]) continue;
        if (i != j) {
            res += mx(1, Math.abs(cnt[i] - cnt[j]));
        } else {
            res++;
        }
    }
    pr(res)
};

// Accepted --- 124ms https://codeforces.com/contest/1497/submission/111103579
const solve1 = (n, m, a) => {
    let cnt = Array(m).fill(0);
    for (const e of a) cnt[e % m]++;
    let res = 0;
    for (let i = 0; i <= m >> 1; i++) {
        let j = (m - i) % m;
        if (!cnt[i] && !cnt[j]) continue;
        if (i != j) {
            let x = cnt[i];
            let y = cnt[j];
            if (x < y) [x, y] = [y, x];
            res += mx(1, x - y)
        } else {
            res++;
        }
    }
    pr(res)
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