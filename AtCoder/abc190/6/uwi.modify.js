// 02/09/21 night

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 1279ms https://atcoder.jp/contests/abc190/submissions/20271794
const solve = (n, a) => {
    let base = 0;
    let ft = new Fenwick(n + 3);
    for (let i = n - 1; ~i; i--) {
        base += ft.query(a[i]);
        ft.update(a[i], 1);
    }
    pr(base);
    for (let i = 0; i < n - 1; i++) {
        base -= a[i];
        base += n - 1 - a[i];
        pr(base);
    }
};

class Fenwick {
    constructor(n) {
        this.n = n;
        this.tree = new Array(n).fill(0);
    }

    query(i) { // sum
        let sum = 0;
        i++;
        while (i > 0) {
            sum += this.tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    update(i, v) { // add
        i++;
        while (i < this.n) {
            this.tree[i] += v;
            i += (i & -i);
        }
    }
}

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => Number(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input[1]);
    });
};

main()