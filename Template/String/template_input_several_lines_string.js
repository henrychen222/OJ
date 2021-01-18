// 10/27/20 morning
const solve = (s) => {
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line);
    });
    rl.on('close', () => {
        let t = Number(input[0]);  // be careful this t
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()