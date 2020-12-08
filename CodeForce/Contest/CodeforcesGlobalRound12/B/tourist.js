// 12.7 evening

// Accepted --- 109ms https://codeforces.com/contest/1450/submission/100665218
const solve = (n, k, data) => {
    for (let i = 0; i < n; i++) {
        let flag = true;
        for (let j = 0; j < n; j++) {
            if (j == i) continue;
            if (!ok(data[i], data[j], k)) {
                flag = false;
                break;
            }
        }
        if (flag) return 1;  // one point success, success
    }
    return -1;
};

const ok = (a, b, k) => {
    let distance = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    if (distance > k) {
        return false;
    }
    return true;
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
        while (t > 0) {
            let n = input[i][0];
            let k = input[i][1];
            let data = input.slice(i + 1, i + n + 1);
            console.log(solve(n, k, data));
            t--;
            i += n + 1;
        }
    });
};

main()