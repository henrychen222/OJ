/**
 * 12.6 morning  12.7 evening
 * https://codeforces.com/contest/1450/problem/A
 */

// Pretests passed https://codeforces.com/contest/1450/submission/100540183  wrong answer on test 5
const res = "bugyrt";
// const solve = (n, s) => {
//     let arr = s.split("");
//     arr.sort((a, b) => {
//         let tmp1 = res.indexOf(a);
//         let tmp2 = res.indexOf(b);
//         if (tmp1 != -1 && tmp2 != -1) {
//             return tmp1 - tmp2;
//         }
//     })
//     console.log(arr.join(""))
// };

// Accepted --- 93ms https://codeforces.com/contest/1450/submission/100666702
const solve = (n, s) => {
    let handle = [];
    let nonHandle = "";
    for (const c of s) {
        if (res.indexOf(c) == -1) {
            nonHandle += c;
        } else {
            handle.push(c);
        }
    }
    // console.log(handle, nonHandle);
    handle.sort((a, b) => {
        let tmp1 = res.indexOf(a);
        let tmp2 = res.indexOf(b);
        if (tmp1 != -1 && tmp2 != -1) {
            return tmp1 - tmp2;
        }
    })
    console.log(handle.join("") + nonHandle);
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
        while (t > 0) {
            let data = input.slice(i, i + 2);
            solve(Number(data[0]), data[1]);
            t--;
            i += 2;
        }
    });
};

main()