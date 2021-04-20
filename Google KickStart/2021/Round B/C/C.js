///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
///////////////////////////////////////////////////////////////////////////////////

// Pass 1, 2 TLE
const solve = (num) => {
    // pr(num);
    let re = [];
    let last;
    for (let x = num; x > 1; x--) {
        if (re.length > 0) {
            last = re[re.length - 1];
        }
        if (isPrime(x)) {
            if (x * last <= num) return x * last;
            re.push(x);
        }
    }
};

const isPrime = (num) => {
    for (let i = 2; i < num; i++)
        if (num % i === 0) return false;
    return num > 1;
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
        for (let cas = 1; cas <= t; cas++) {
            let show = solve(input[i]);
            pr('Case #' + cas + ': ' + show);
            i++;
        }
    });
};

main()