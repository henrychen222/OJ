// 03/25/21 night

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 202ms
const solve = (n, k) => {
    if (n & 1) {
        pr(`${n - 1 >> 1} ${n - 1 >> 1} ${1}`)
    } else if (n & 2) {
        pr(`${n - 2 >> 1} ${n - 2 >> 1} ${2}`)
    } else {
        pr(`${n >> 1} ${n >> 2} ${n >> 2}`)
    }
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
    });
    rl.on('close', () => {
        let t = input[0][0];
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i][1]);
            i++;
        }
    });
};

main()