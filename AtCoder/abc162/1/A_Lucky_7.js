/**
 * 10.13 morning
 * https://atcoder.jp/contests/abc162/tasks/abc162_a
 */

// Accepted --- 68ms
// https://atcoder.jp/contests/abc162/submissions/17384910
const solve = (s) => {
    return s.indexOf('7') == -1 ? 'No' : 'Yes';
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        terminal: false
    });

    rl.on('line', function (line) {
        console.log(solve(line));
    })
};

main()