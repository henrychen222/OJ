/**
 * 10/13/22 afternoon
 * https://www.luogu.com.cn/problem/P1303
 */

const pr = console.log;

// Accepted
const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nl = () => BigInt(readLine());
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let a = nl(), b = nl();
        pr((a * b).toString());
    });
};

main()