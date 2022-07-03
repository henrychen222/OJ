// 07/02/22 night
// TLE --- https://codeforces.com/problemset/submission/1697/162630604
// Accepted --- https://codeforces.com/problemset/submission/1697/162632250 1899ms
// Accepted --- https://codeforces.com/problemset/submission/1697/162634898  1716ms

const pr = console.log;

const preSum = (a) => { let pre = [0]; for (let i = 0; i < a.length; i++) { pre.push(pre[i] + a[i]); } return pre; };
const subArraySum = (a, l, r) => a[r + 1] - a[l];

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nall = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let [n, q] = nai(), a = nai();
        a.sort((x, y) => y - x);
        let pre = preSum(a);
        // pr(n, q, a)
        for (let i = 0; i < q; i++) {
            let [x, y] = nai();
            let r = x - 1, l = Math.max(0, x - y);
            // pr(l, r, a.slice(l, r + 1), a.slice(0, x), pre)
            let sum = subArraySum(pre, l, r);
            pr(sum);
        }
    });
};

main();