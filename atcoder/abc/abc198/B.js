/**
 * 04/11/21 morning
 * https://atcoder.jp/contests/abc198/tasks/abc198_b
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (s) => {
    if (isPalindrome(s)) return pr('Yes');
    let n = s.length;
    let cnt = 0;
    for (let i = n - 1; ~i; i--) {
        if (s[i] == '0') {
            cnt++;
        } else {
            break;
        }
    }
    let res = '0'.repeat(cnt) + s;
    pr(isPalindrome(res) ? 'Yes' : 'No');
};

const isPalindrome = (s) => {
    let n = s.length;
    let i = 0;
    let j = n - 1;
    while (i < j) {
        if (s[i++] != s[j--]) return false;
    }
    return true;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(line);
    });
};

main()