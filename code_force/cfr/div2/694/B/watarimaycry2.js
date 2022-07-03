// 1.17 evening

// TLE
const solve = (n, x, a) => {
    // console.log(n, x, a)
    dq = a.map(x => [x, 1]);
    // console.log(dq);
    let flag = true;
    let sum = 0;
    while (dq.length > 0) {
        let tmp = dq.shift();
        sum += tmp[0] * tmp[1];
        if (tmp[0] % x == 0 && flag) {
            dq.push([Math.floor(tmp[0] / x), tmp[1] * x]);
        } else {
            flag = false;
        }
    }
    console.log(sum);
};

// TLE
// const solve = (n, x, a) => {
//     dq = a.map(x => [x, 1n]);
//     let flag = true;
//     let sum = 0n;
//     while (dq.length > 0n) {
//         let tmp = dq.shift();
//         sum += tmp[0] * tmp[1];
//         if (tmp[0] % x == 0n && flag) {
//             dq.push([tmp[0] / x, tmp[1] * x]);
//         } else {
//             flag = false;
//         }
//     }
//     console.log(sum.toString());
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
        // input.push(line.split(" ").map(x => BigInt(x)));
    });
    rl.on('close', () => {
        let t = input[0][0];
        let i = 1;
        while (t--) {
            let data = input.slice(i, i + 2);
            solve(data[0][0], data[0][1], data[1]);
            i += 2;
        }
    });
};

main()