/**
 * 10.27 morning
 * https://codeforces.com/contest/1437/problem/B
 * 
 * reference:
 * https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
 * https://www.geeksforgeeks.org/minimum-number-of-replacements-to-make-the-binary-string-alternating-set-2/
 */

// Time limit exceeded on test 4  https://codeforces.com/contest/1437/submission/96941085
const solve = (s) => {
    let n = s.length;
    let res = 0;
    let pos1 = [];
    for (let i = 0; i < n; i++) {
        if (i % 2 == 0 && s[i] == '1') {
            pos1.push(i);
            res++;
        }
        if (i % 2 == 1 && s[i] == '0') {
            pos1.push(i);
            res++;
        }
    }
    let pos2 = [];
    for (let i = 0; i < n; i++) {
        if (pos1.indexOf(i) == -1) pos2.push(i);
    }
    // console.log(res, pos1, n - res, pos2);
    // console.log(remove(res, pos1), remove(n - res, pos2));
    return Math.min(remove(res, pos1), remove(n - res, pos2));
};

const remove = (res, pos) => {
    let n = pos.length;
    for (let i = 0; i + 1 < n; i++) {
        if (pos[i + 1] - pos[i] == 1) {
            res--;
        }
    }
    return res;
};


//////////////////////////////////////////////////////////
// Wrong Answer 
// const solve = (s) => {
//     return Math.min(operate(s, '0'), operate(s, '1'));
// };

// const flip = (ch) => {
//     return (ch == '0') ? '1' : '0';
// };

// const operate = (s, expected) => {
//     let flipCnt = 0;
//     let set = new Set();
//     for (let i = 0; i < s.length; i++) {
//         if (s[i] != expected) {
//             if (!set.has(i - 1) && !set.has(i + 1)) {
//                 flipCnt++;
//                 set.add(i);
//             }
//         }
//         expected = flip(expected);
//     }
//     return flipCnt;
// };

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
        // let t = Number(input[0][0]);  wrong here in contest
        let t = Number(input[0]);
        let i = 2;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0]));
            t--;
            i += 2;
        }
    });
};

main()