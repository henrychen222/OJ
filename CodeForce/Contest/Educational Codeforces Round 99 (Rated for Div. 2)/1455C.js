/**
 * 11.30 morning
 * https://codeforces.com/contest/1455/problem/C 
 */

// wrong
// const solve = (x, y) => {
//     if (x >= y) {
//         console.log(x - 1 + " " + y);
//     } else {
//         console.log(x - 1 + " " + (y - x + 1));  // should be y - x + x
//     }
// };

// Accepted  fuck very close
const solve = (x, y) => {
    console.log(x - 1 + " " + y);
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
        while (t > 0) {
            solve(input[i][0], input[i][1]);
            t--;
            i++;
        }
    });
};

main()