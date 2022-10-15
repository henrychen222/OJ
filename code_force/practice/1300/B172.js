/**
 * 10/13/22 afternoon
 * https://codeforces.com/problemset/problem/172/B
 */

const pr = console.log;

// Accepted
const solve = (a, b, m, r0) => {
    let ma = new Map(), dp = [r0];
    // for (let i = 0; i < 10; i++) {
    while (1) {
        let next = (dp[dp.length - 1] * a + b) % m;
        // pr(ma, dp)
        if (ma.has(next)) {
            let pre = ma.get(next);
            pr(dp.length - pre + 1);
            return;
        }
        dp.push(next);
        ma.set(next, dp.length);
    }
};

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let [a, b, m, r0] = nai();
        solve(a, b, m, r0);
    });
};

main()