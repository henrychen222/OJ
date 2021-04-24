///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// WA
const solve = (s) => {
    let n = s.length;
    let zero = new Set();
    let one = new Set();
    for (let i = 0; i < n; i++) {
        if (s[i] == '0') {
            // pr(i, zero, one)
            if (zero.has(i - 1) && one.size > 0) {
                return pr('NO');
            }
            zero.add(i);
        } else {
            one.add(i);
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