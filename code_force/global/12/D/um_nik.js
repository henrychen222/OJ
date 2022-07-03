// 12.7 evening

// Accepted --- 218ms https://codeforces.com/contest/1450/submission/100669931
const solve = (n, a) => {
    let cnt = new Array(n + 1).fill(0);
    let res = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        cnt[a[i]]++;
    }
    let l = 0;
    let r = n - 1;
    for (let x = 1; x < n; x++) {
        if (cnt[x] == 0) break;
        res[n - x] = 1;
        if ((a[l] != x && a[r] != x) || cnt[x] != 1) break;
        (a[l] == x) ? l++ : r--;
    }
    res[0] = 1;
    for (let x = 1; x <= n; x++) {
        res[0] &= (cnt[x] == 1);
    }
    console.log(res.join(""));
}

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
            solve(input[2 * i - 1][0], input[2 * i]);
            i++;
        }
    });
};

main()