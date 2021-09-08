// 09/06/21 night

const pr = console.log;

// RE on Test 3 https://codeforces.com/problemset/submission/1433/128090113
const solve1 = (n, a) => {
    let max = Math.max.apply(Math, a); // bug: when array length is too long  Maximum call stack size exceeded
    for (let i = 0; i < n; i++) {
        if (a[i] == max) {
            let ok = false;
            if (i + 1 < n && a[i] > a[i + 1]) ok = true;
            if (i - 1 >= 0 && a[i] > a[i - 1]) ok = true;
            if (ok) return pr(i + 1);
        }
    }
    pr(-1);
};

// Accepted https://codeforces.com/problemset/submission/1433/128090010 326ms
const solve = (n, a) => {
    let max = 0;
    for (const x of a) max = Math.max(max, x);
    for (let i = 0; i < n; i++) {
        if (a[i] == max) {
            let ok = false;
            if (i + 1 < n && max > a[i + 1]) ok = true;
            if (i - 1 >= 0 && max > a[i - 1]) ok = true;
            if (ok) return pr(i + 1);
        }
    }
    pr(-1);
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
            solve(input[i][0], input[i + 1]);
            i += 2;
        }
    });
};

main()


// let A = Array(125657).fill(1000000000);  // MAX  125657  125658  Maximum call stack size exceeded
// pr(Math.max.apply(Math, A));
// pr(Math.max(...A));