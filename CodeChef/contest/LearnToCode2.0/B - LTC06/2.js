/**
 * 02/25/21 morning
 * https://www.codechef.com/LTC22021/problems/LTC06
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// WA
// https://www.reddit.com/r/learnmath/comments/c7fex3/equation_for_sequence_234691319284263/
const solve = (n) => {
    let dp = [1, 2];
    for (let i = 2; i < n; i++) {
        dp[i] = dp[i - 1] * 3 >> 1;
    }
    pr(dp[n - 1]);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(Number(line));
    });
    rl.on('close', () => {
        let t = input[0];
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()



/**
 *  1 2 3 4 5 6  7  8   9
 *  1 2 3 4 6 9 13  19  28
 *  a(n) = floor(a(n-1)*3/2)
 */