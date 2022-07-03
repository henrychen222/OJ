// 1.17 afternoon

// wrong
const solve = (N, M) => {
    let res = pow(10, N, M * M);
    console.log(Math.floor(res / M));
};

const pow = (a, n, mod) => {
    let res = 1;
    let x = 63 - numberOfLeadingZeros(n);
    for (; x >= 0; x--) {
        res = res * res % mod;
        if (n << 63 - x < 0) res = res * a % mod;
    }
    return res;
};

const numberOfLeadingZeros = (i) => {
    if (i == 0) return 64;
    let n = 1;
    let x = i >>> 32;
    if (x == 0) { n += 32; x = i; }
    if (x >>> 16 == 0) { n += 16; x <<= 16; }
    if (x >>> 24 == 0) { n += 8; x <<= 8; }
    if (x >>> 28 == 0) { n += 4; x <<= 4; }
    if (x >>> 30 == 0) { n += 2; x <<= 2; }
    n -= x >>> 31;
    return n;
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
        solve(input[0][0], input[0][1]);
    });
};

main()