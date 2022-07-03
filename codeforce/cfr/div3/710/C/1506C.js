/**
 * 03/25/21 morning
 * https://codeforces.com/contest/1506/problem/C
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mx = Math.max;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 46ms https://codeforces.com/contest/1506/submission/111068343
const solve = (a, b) => {
    let res = LongestCommonSubstringLen(a, b);
    pr(a.length + b.length - res * 2);
};

// Accepted --- 61ms https://codeforces.com/contest/1506/submission/111067942
const solve2 = (a, b) => {
    let res = LongestCommonSubstring(a, b).length;
    pr(a.length + b.length - res * 2);
};

const LongestCommonSubstringLen = (A, B) => {
    let m = A.length;
    let n = B.length;
    let maxLen = 0;
    let dp = initialize2DArrayNew(m + 1, n + 1);
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (A[i - 1] == B[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                }
            }
        }
    }
    return maxLen;
};

// referenen: https://www.techiedelight.com/longest-common-substring-problem/
const LongestCommonSubstring = (A, B) => { // doesn't matter which short or long
    let m = A.length;
    let n = B.length;
    let maxLen = 0;
    let endIdx = m;
    let dp = initialize2DArrayNew(m + 1, n + 1); // lCS suffix
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (A[i - 1] == B[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    endIdx = i;
                }
            }
        }
    }
    return A.slice(endIdx - maxLen, endIdx);
};

const initialize2DArrayNew = (m, n) => {
    let data = [];
    for (let i = 0; i < m; i++) {
        let tmp = new Array(n).fill(0);
        data.push(tmp);
    }
    return data;
};

// WA this only find the length longest substring in short
// Needs to find longest common substring length
const solve1 = (a, b) => {
    let an = a.length;
    let bn = b.length;
    an <= bn ? go(a, b) : go(b, a);
};

const go = (short, long) => {
    let sn = short.length;
    let ln = long.length;
    if (sn == ln && short == long) return pr(0);
    if (long.indexOf(short) != -1) return pr(sn);
    let res = 0;
    for (let i = 0; i < sn; i++) {
        for (let j = i; j < sn; j++) {
            let len = j - i + 1;
            let sub = short.slice(i, j + 1);
            pr(sub);
            if (long.indexOf(sub) != -1) {
                res = mx(res, len);
            }
        }
    }
    pr(sn + ln - res * 2);
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
            solve(input[i], input[i + 1]);
            i += 2;
        }
    });
};

main()