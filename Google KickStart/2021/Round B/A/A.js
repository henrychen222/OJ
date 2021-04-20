/**
 * 04/18/21 evening
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a882
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

// const solve = (n, s) => {
//     pr(n,s);
//     let res = [];
//     for (let i = 0; i < n; i++) {
//        let end = n - 1;
//        for (let j = i + 1; j < n; j++) {
//            if (s[j - 1].charCodeAt() >= s[j].charCodeAt()) {
//                 end = j - 1;
//                 break;
//            }
//        }
//        pr(s.slice(i, end + 1));
//        let len = end - i + 1;
//        res.push(len);
//     }
//     pr(res);
// };

// Accepted
const solve = (n, s) => {
    let res = [];
    for (let i = n - 1; ~i; i--) {
        let start = 0;
        for (let j = i; ~j; j--) {
            if (j - 1 >= 0) {
                if (s[j - 1].charCodeAt() >= s[j].charCodeAt()) {
                    start = j;
                    break;
                }
            }
        }
        // pr(s[i], s.slice(start, i + 1));
        let len = i - start + 1;
        res.push(len);
    }
    // pr(res);
    return res.reverse().join(" ");
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
        for (let cas = 1; cas <= t; cas++) {
            let show = solve(input[i], input[i + 1]);
            pr('Case #' + cas + ': ' + show);
            i += 2;
        }
    });
};

main()
