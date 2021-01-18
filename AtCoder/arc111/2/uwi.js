// 1.17 evening
class DJSet {
    constructor(n) {
        this.upper = Array(n).fill(-1);
        this.cycle = Array(n).fill(false);
    }

    find(x) {
        return this.upper[x] < 0 ? x : (this.upper[x] = this.find(this.upper[x]));
    }

    equiv(x, y) {
        return this.find(x) == this.find(y);
    }

    union(x, y) {
        x = this.find(x);
        y = this.find(y);
        if (x != y) {
            if (this.upper[y] < this.upper[x]) {
                let d = x;
                x = y;
                y = d;
            }
            this.upper[x] += this.upper[y];
            this.upper[y] = x;
            this.cycle[x] |= this.cycle[y];
        } else {
            this.cycle[x] = true;
        }
        return x == y;
    }

    count() {
        let cnt = 0;
        for (const u of this.upper) {
            if (u < 0) cnt++;
        }
        return cnt;
    }
}

// Accepted https://atcoder.jp/contests/arc111/submissions/19502445
const MAX = 400001;
const solve = (n, a) => {
    let ds = new DJSet(MAX);
    for (const e of a) {
        ds.union(e[0], e[1]);
    }
    let res = 0;
    for (let i = 0; i < MAX; i++) {
        if (ds.upper[i] < 0) {
            if (ds.cycle[i]) {
                res += -ds.upper[i];
            } else {
                res += -ds.upper[i] - 1;
            }
        }
    }
    console.log(res);
};

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
        solve(input[0][0], input.slice(1));
    });
};

main()