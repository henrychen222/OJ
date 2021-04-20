// 04/16/21 afternoon

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 124ms
const solve = (n, s) => {
    let t = m = cnt = 0;
    for (let i = 0; i < n; i++) {
        if (s[i] == 'T') {
            t++;
            if (cnt < 0) cnt++;
        } else {
            m++;
            cnt--;
        }
        if (m > t) return pr("NO");
        // pr(t, m, cnt);
    }
    // pr(t, m, cnt);
    if (cnt != 0 || m * 2 != t) return pr("NO");
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
            solve(input[i], input[i + 1]);
            i += 2;
        }
    });
};

main()