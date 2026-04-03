/**
 * 
 * 
 */
const pr = console.log;

const solve = () => {
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
        let n = ni(), a = nai();
        solve(n, a);
    });
};

main()