// 04/12/21 afternoon

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- https://codeforces.com/contest/1512/submission/112867547
const solve = (a, b, s) => {
    let cnt = [a, b];
    let n = s.length;
    let A = s.split("");
    let found = false;
    for (let i = 0; i < n >> 1; i++) {
        let j = n - 1 - i;
        if (A[i] != '?' && A[j] != '?' && A[i] != A[j]) {
            found = true;
            break;
        }
        if (A[i] != '?' && A[j] == '?') A[j] = A[i];
        if (A[i] == '?' && A[j] != '?') A[i] = A[j];
    }
    if (found) return pr(-1);
    for (let i = 0; i < n; ++i) {
        let k = A[i] - '0';
        cnt[k]--;
    }
    for (let i = 0; i < n >> 1; i++) {
        if (A[i] != '?') continue;
        for (let k = 0; k < 2; k++) {
            if (cnt[k] >= 2) {
                cnt[k] -= 2;
                A[i] = A[n - 1 - i] = k;
                break;
            }
        }
    }
    if (n % 2 && A[n >> 1] == '?') {
        for (let k = 0; k < 2; k++) {
            if (cnt[k] >= 1) {
                cnt[k]--;
                A[n >> 1] = k;
            }
        }
    }
    if (cnt[0] == 0 && cnt[1] == 0) {
        pr(A.join(""));
    } else {
        pr(-1);
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
        input.push(line);
    });
    rl.on('close', () => {
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            let tmp = input[i].split(" ").map(Number);
            solve(tmp[0], tmp[1], input[i + 1]);
            i += 2;
        }
    });
};

main()