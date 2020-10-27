/**
 * 10.24 morning
 * https://atcoder.jp/contests/arc106/tasks/arc106_a
 */
const solve = (N) => {
    let Amax = Math.ceil(Math.log10(N) / Math.log10(3));
    let Bmax = Math.ceil(Math.log10(N) / Math.log10(5));
    for (let a = 0; a <= Amax; a++) {
        for (let b = 0; b <= Bmax; b++) {
            if (3 ** a + 5 ** b == N) {
                return [a, b];
            }
        }
    }
    return -1;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        let res = solve(Number(line));
        if (res.length == 2) {
            console.log(res[0], res[1]);
        } else {
            console.log(res);
        }
    });
};

main()