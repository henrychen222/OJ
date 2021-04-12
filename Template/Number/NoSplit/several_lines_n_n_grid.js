///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

const solve = (n, g) => {
    pr(n, g)
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
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            let n = Number(input[i]);
            let tmp = input.slice(i + 1, i + n + 1);
            tmp = tmp.map(s => s.split(""));
            solve(n, tmp);
            i += n + 1;
        }
    });
};

main()