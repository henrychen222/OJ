/**
 * 02/25/21 morning
 * https://www.codechef.com/LTC22021/problems/LTC04
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

const solve = (c, s1, s2) => {
    if (c == 'A') {
        pr(`${s1}${s2.slice(0, 1).toUpperCase()}${s2.slice(1)}`)
    } else if (c == 'B') {
        pr(`${s1}_${s2}`)
    } else if (c == 'C') {
        pr(`${s1.toUpperCase()}_${s2.toUpperCase()}`);
    } else if (c == 'D') {
        pr(`${s1.slice(0, 1).toUpperCase()}${s1.slice(1)}-${s2.slice(0, 1).toUpperCase()}${s2.slice(1)}`);
    } else {
        let res = '';
        for (const c of s1) {
            if (res.length == 0) {
                res += c;
                continue;
            }
            let tmp = res[res.length - 1];
            if (isLowerCaseLetter(tmp)) {
                res += c.toUpperCase();
            } else {
                res += c;
            }
        }
        res += '|';
        for (const c of s2) {
            let tmp = res[res.length - 1];
            if (isLowerCaseLetter(tmp)) {
                res += c.toUpperCase();
            } else {
                res += c;
            }
        }
        pr(res);
    }
};

const isLowerCaseLetter = (c) => {
    return c.charCodeAt() >= 97 && c.charCodeAt() <= 122;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" "));
    });
    rl.on('close', () => {
        let t = Number(input[0][0]);
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i][1], input[i][2]);
            i++;
        }
    });
};

main()