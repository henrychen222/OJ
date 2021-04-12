/**
 * 04/10/21 morning   afternoon continue
 * https://codeforces.com/contest/1512/problem/C
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

const solve = (a, b, s) => {
    let n = s.length;
    let A = s.split("");
    let cnt = cal(A);
    let zero = cnt[0];
    let one = cnt[1];
    let qus = cnt[2];
    // pr(zero, one, qus, A.join(""));
    if (zero + qus < a || one + qus < b) return pr(-1);
    if (qus == 0 && !ok(s)) return pr(-1);
    for (let i = 0; i < n; i++) { // reset left and right to be Palindrome match
        let j = n - i - 1;
        if (A[i] != '?') {
            if (A[i] == '0') {
                A[j] = '0';
            } else {
                A[j] = '1';
            }
        }
    }
    // pr(zero, one, qus, A.join(""));
    for (let i = 0; i < n; i++) { // replace process, issue
        let j = n - i - 1;
        if (i > j) break;
        if (A[i] == '?') {
            let zd = a - zero;
            let od = b - one;
            if (zd >= od) {
                if (i == j) {
                    A[i] = '0';
                    zero++;
                    continue;
                }
                A[i] = '0';
                A[j] = '0';
                zero += 2;
            } else {
                if (i == j) {
                    A[i] = '1';
                    one++;
                    continue;
                }
                A[i] = '1';
                A[j] = '1';
                one += 2;
            }
        }
        // pr(A.join(""), zero, one);
    }
    cnt = cal(A);
    zero = cnt[0];
    one = cnt[1];
    qus = cnt[2];
    // pr(zero, one, qus, A.join(""));
    if (zero != a || one != b) return pr(-1);
    pr(A.join(""))
};

const cal = (A) => {
    let zero = one = qus = 0;
    for (const c of A) {
        if (c == '0') {
            zero++;
        } else if (c == '1') {
            one++;
        } else {
            qus++;
        }
    }
    return [zero, one, qus];
};

const ok = (s) => {
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