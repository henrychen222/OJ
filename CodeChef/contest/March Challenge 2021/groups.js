/**
 * 03/04/21 night
 * https://www.codechef.com/MARCH21C/problems/GROUPS
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// TLE
// const solve = (s) => {
//     let n = s.length;
//     let res = 0;
//     outer:
//     for (let i = 0; i < n;) {
//         if (s[i] == '1') {
//             res++;
//             for (let j = i + 1; j < n; j++) {
//                 if (s[j] == '0') {
//                     i = j;
//                     continue outer;
//                 }
//             }
//         }
//         i++;
//     }
//     pr(res);
// };


// TLE
// const solve = (s) => {
//     let a = s.split("0");
//     pr(a.filter(x => x == '1').length);
// };


// TLE
const solve = (s) => {
    let n = s.length;
    let res = 0;
    for (let i = 0; i < n; i++) {
        if (i == 0) {
            if (s[i] == '1') {
                if (s[i + 1] != '1') res++;
            }
        } else if (i == n - 1) {
            if (s[i] == '1') {
                if (s[i - 1] != '1') res++;
            }
        } else {
            if (s[i] == '1') {
                if (s[i - 1] != '1' && s[i + 1] != '1') res++;
            }
        }
    }
    pr(res);
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
            solve(input[i]);
            i++;
        }
    });
};

main()