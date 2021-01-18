// 1.17 afternoon + evening (fix bug)

// Accepted https://atcoder.jp/contests/arc111/submissions/19502596
let MOD;
const solve = (N, M) => {
    MOD = M * M;
    // console.log(N, M, MOD);
    let res = pow(10n, N);
    // console.log(res);
    res /= M;
    console.log(Number(res));
};

const multi = (x, y) => {
    return (x * y) % MOD;
};

const pow = (a, n) => {
    if (n == 0n) return 1n;
    if (n & 1n) return multi(a, pow(a, n - 1n));
    return pow(multi(a, a), n / 2n);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => BigInt(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input[0][1]);
    });
};

main()