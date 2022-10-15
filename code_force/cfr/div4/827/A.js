/**
 * 10/13/22 morning
 * https://codeforces.com/contest/1742/problem/A
 */

const pr = console.log;

// Accepted
const solve = (a) => {
    if (a[0] + a[1] == a[2] || a[0] + a[2] == a[1] || a[1] + a[2] == a[0]) {
        pr("YES");
    } else {
        pr("NO");
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
        let t = ni();
        while (t--) {
            let a = nai();
            solve(a);
        }
    });
};

main()