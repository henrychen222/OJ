// 02/21/21 morning

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// WA
const solve = (a, b, c) => {
    // pr(a, b, c, powL(b, c))
    let k, res;
    if (powL(b, c) > 10n) {
        k = powmod(b, c, 4n) + 4n;
    } else {
        k = powL(b, c);
    }
    // pr("1111")
    let power = b ** c;
    pr(power);
    power > 10n ? k = powmod(b, c, 4n) + 4n : k = power;
    res = powmod(a, k, 10n);
    pr(Number(res));
};

const powL = (a, b) => {
    return a ** b; // BigInt will Frozen when too large
};

const powmod = (a, b, mod) => {
    pr("2222")
    let r = 1n;
    while (b > 0n) {
        if (b % 2n == 1n) r = r * a % mod;
        // if (b & 1n) r = r * a % mod;
        b >>= 1n;
        a = a * a % mod;
    }
    return r;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => BigInt(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input[0][1], input[0][2]);
    });
};

// main()
// pr(2n ** 1000000n)
// pr((6535897n)** 9323846n)
