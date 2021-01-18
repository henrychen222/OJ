/**
 * 12.30 morning
 * https://codeforces.com/contest/1466/problem/C
 * 
 * https://www.techiedelight.com/find-minimum-number-deletions-convert-string-into-palindrome/
 */

const solve = (s) => {
    let n = s.length - 1;
    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            let sub = s.slice(i, j + 1);
            res = Math.max(res, panlidromeModify(sub, i, j))
        }
    }
    console.log(res)
};

const panlidromeModify = (s, i, j) => {
    let cnt = 0;
    while (i < j) {
        if (s[i++] == s[j--]) cnt++;
    }
    return cnt;
}

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