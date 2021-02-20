///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

const solve = (n, da) => {
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => Number(x)));
        // input.push(line.split(" ").map(x => BigInt(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input.slice(1));
    });
};

main()