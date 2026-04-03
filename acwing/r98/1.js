/**
 * 04/12/23 afternoon
 * https://www.acwing.com/problem/content/4951/
 */
const pr = console.log;

// Accepted
const solve = (n, a) => {
    let res = 1n;
    for (const x of a) res *= ll(x);
    pr(res);
};

const ll = BigInt;
const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nl = () => ll(readLine());
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(ll);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let n = ni(), a = nas();
        solve(n, a);
    });
};

main()