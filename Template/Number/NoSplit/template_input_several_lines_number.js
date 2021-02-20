///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

const solve = (num) => {
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(Number(line));
    });
    rl.on('close', () => {
        let t = input[0];
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()