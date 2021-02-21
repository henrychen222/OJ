/**
 * 02/21/21 morning
 * https://atcoder.jp/contests/arc113/tasks/arc113_a
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

const solve = (a, b, c) => {
    // let tmp = [];
    // for (let i = 2n; i < 200; i++) {
    //     tmp.push((a ** i).toString().indexOf('1'))
    //     pr(a ** i);
    // }
    // pr(tmp);
    let x = a ** (b ** c) + '';
    pr(x.indexOf('1') + 1);
};

// WA
// const solve = (a, b, c) => {
//     let x = Math.pow(a, (Math.pow(b, c))) + '';
//     pr(x.indexOf('1') + 1);
// };

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
        solve(input[0][0], input[0][1], input[0][2]);
    });
};

main()
