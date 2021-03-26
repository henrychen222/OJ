///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 78ms https://codeforces.com/contest/1499/submission/110390865
const solve = (s) => {
    let n = s.length;
    let idx;
    for (let i = 1; i < n; i++) {
        if (s[i - 1] == s[i] && s[i] == '1') {
            idx = i;
            break;
        }
    }
    for (let i = idx + 1; i < n; i++) {
        if (s[i - 1] == s[i] && s[i] == '0') {
            return pr('NO'); // check for "1100" existence, if exist, result is NO
        }
    }
    pr('YES');
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