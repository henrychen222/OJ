// 12.20 afternoon  12.20 evening fixed

// TLE --- https://codeforces.com/contest/1465/submission/101921757
// Accepted --- https://codeforces.com/contest/1465/submission/101926928
const solve = (s) => {
    let num = BigInt(s);
    while (true) {
        if (ok(num)) {
            return console.log(num + '');
        }
        num++;
    }
};

const ok = (a) => {
    let b = a;
    while (b) {
        let rem = b % 10n;
        // b /= 10n;
        // if (rem != 0 && a % rem != 0) return false;
        if (rem != 0 && a % rem != 0) return false;  // change to this Accepted, think from this https://codeforces.com/contest/1465/submission/101923584
        b /= 10n;
    }
    return true;
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


// Accepted --- 1840ms https://codeforces.com/contest/1465/submission/101926806
// const solve = (num) => {
//     while (true) {
//         if (ok(num)) {
//             return console.log(num + '');
//         }
//         num++;
//     }
// };

// const ok = (a) => {
//     let b = a;
//     while (b) {
//         let rem = b % 10n;
//         if (rem != 0 && a % rem != 0) return false;
//         b /= 10n;
//     }
//     return true;
// };

// const main = () => {
//     const readline = require('readline');
//     const rl = readline.createInterface({
//         input: process.stdin,
//         output: process.stdout
//     });
//     let input = [];
//     rl.on('line', (line) => {
//         input.push(line);
//     });
//     rl.on('close', () => {
//         let t = Number(input[0]);
//         let i = 1;
//         while (t--) {
//             solve(BigInt(input[i]));
//             i++;
//         }
//     });
// };

// main()