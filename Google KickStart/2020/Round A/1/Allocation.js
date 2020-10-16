/**
 * 10.15 evening
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56
 */

// wrong
// const solve = (data) => {
//     let N = data[0][0];
//     let B = data[0][1];
//     let A = data[1];
//     // console.log(data, N, B, A);
//     let sum = 0;
//     let cnt = 0;
//     A.sort((a, b) => a - b);
//     for (const a of A) {
//         if (sum == B) {
//             return cnt;
//         } else if (sum > B) {
//             return cnt - 1;
//         }
//         sum += a;
//         cnt++;
//     }
//     return cnt;
// };

// Accepted
// reference: https://www.keyanjie.net/google-kick-start-2020-round-A/
const solve = (data) => {
    let N = data[0][0];
    let B = data[0][1];
    let A = data[1];
    let sum = 0;
    let cnt = 0;
    A.sort((a, b) => a - b);
    for (const a of A) {
        sum += a;
        if (sum > B) {
            break;
        }
        cnt++;
    }
    return cnt;
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
        let t = Number(input[0][0]);
        for (let i = 1; t > 0; i += 2) {
            console.log('Case #' + ((i >> 1) + 1) + ': ' + solve(input.slice(i, i + 2)));
            t--;
        }
    });
};

main()

// const test = () => {
//     let data = [ [ 1, 100 ], [1] ]
//     console.log(solve(data));
// };

// test()
