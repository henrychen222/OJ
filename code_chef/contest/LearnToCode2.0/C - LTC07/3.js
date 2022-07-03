

/**
 * 02/25/21 morning
 * https://www.codechef.com/LTC22021/problems/LTC07
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// why TLE but java AC
const solve = (s) => {
    let m = new Map([['0', 3], ['1', 3], ['2', 3], ['3', 3], ['4', 3], ['5', 3], ['6', 2], ['7', 2], ['8', 2], ['9', 2]]);
    let res = 1;
    for (const c of s) {
        res *= m.get(c);
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



/**
 * 0: a, k, u
 * 1: b, l, v
 * 2: c, m, w
 * 3: d, n, x
 * 4: e, o, y
 * 5: f, p, z
 * 6: g, q
 * 7: h, r
 * 8: i, s
 * 9: j, t
 */