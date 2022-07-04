/**
 * 07/02/22 night
 */

const pr = console.log;

const solve = (n, k, a) => {
    
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
            let [n, k] = nai(), a = nai();
            solve(n, k, a);
        }
    });
};

main()