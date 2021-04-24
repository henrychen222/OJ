/**
 * 11.21 morning
 * https://codeforces.com/contest/1451/problem/A
 */

// don't know
const solve = (n) => {
    console.log(dfs(n));
};

// const dfs = (n) => {
//     if (n == 1) {
//         return 0;
//     } else {
//         let d;
//         for (let i = n; i >= 1; i--) {
//             if (n % i == 0) {
//                 d = i;
//                 break;
//             }
//         }
//         if (d != undefined) {
//             return 1 + Math.min(dfs(n - 1), dfs(n / d));
//         } else {
//             return 1 + Math.min(dfs(n - 1));
//         }
//     }
// };

const dfs = (n) => {
    if (n == 1) {
        return 0;
    } else if (n % 2 == 0) {
        return 1 + Math.min(dfs(n / 2));
    } else {
        return 1 + Math.min(dfs(n / 3), dfs(n - 1));
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
        let t = input[0];
        let i = 1;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0][0]));
            t--;
            i++;
        }
    });
};

main()