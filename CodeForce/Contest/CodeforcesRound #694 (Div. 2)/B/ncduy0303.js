// 1.17 evening

// Accepted --- 982ms https://codeforces.com/contest/1471/submission/104634720
const solve = (n, x, a) => {
    a = a.map(x => [x, 1]);
    // console.log(a);
    let res = 0;
    let flag = true;
    for (let i = 0; i < a.length; i++) {
        let tmp = a[i];
        res += tmp[0] * tmp[1];
        if (tmp[0] % x) flag = false;
        if (flag) a.push([parseInt(tmp[0] / x), tmp[1] * x]);
    }
    // console.log(a);
    console.log(res);
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
            // let data = input.slice(i, i + 2);
            // solve(data[0][0], data[0][1], data[1]);
            solve(input[i][0], input[i][1], input[i + 1]);
            i += 2;
        }
    });
};

main()


// Accepted --- 810ms https://codeforces.com/contest/1471/submission/104635256
// const solve = (n, x, a) => {
//     let res = 0;
//     let flag = true;
//     for (let i = 0; i < a.length; i++) {
//         let tmp = a[i];
//         res += tmp[0] * tmp[1];
//         if (tmp[0] % x) flag = false;
//         if (flag) a.push([parseInt(tmp[0] / x), tmp[1] * x]);
//     }
//     console.log(res);
// };

// const main = () => {
//     const readline = require('readline');
//     const rl = readline.createInterface({
//         input: process.stdin,
//         output: process.stdout
//     });
//     let input = [];
//     rl.on('line', (line) => {
//         input.push(line.split(" ").map(x => [Number(x), 1]));
//     });
//     rl.on('close', () => {
//         let t = input[0][0][0];
//         let i = 1;
//         while (t--) {
//             let data = input.slice(i, i + 2);
//             solve(data[0][0][0], data[0][1][0], data[1]);
//             i += 2;
//         }
//     });
// };

// main()