/**
 * 03/25/21 morning
 * https://codeforces.com/contest/1506/problem/A
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// const solve = (n, m, x) => {
//     let curRowStart = x % n;
//     let rows;
//     if (curRowStart > 0) {
//         rows = (curRowStart - 1) * m;
//         let move = (x - curRowStart) / n;
//         pr(rows + move + 1);
//     } else if (curRowStart == 0) {
//         pr(x);
//     }
// };

// Accepted
const solve = (n, m, x) => {
    let curRowStart = x % n;
    let rows;
    if (curRowStart > 0) {
        rows = (curRowStart - 1) * m;
        let move = (x - curRowStart) / n;
        pr(rows + move + 1);
    } else if (curRowStart == 0) {
        curRowStart += n;
        rows = (curRowStart - 1) * m;
        let move = (x - curRowStart) / n;
        pr(rows + move + 1);
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
            solve(input[i][0], input[i][1], input[i][2]);
            i++;
        }
    });
};

main()