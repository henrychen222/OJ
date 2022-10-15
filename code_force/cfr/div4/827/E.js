/**
 * 10/13/22 morning
 * https://codeforces.com/contest/1742/problem/E
 */

const pr = console.log;

function Bisect() {
    return { insort_right, insort_left, bisect_left, bisect_right }
    function insort_right(a, x, lo = 0, hi = null) {
        lo = bisect_right(a, x, lo, hi);
        a.splice(lo, 0, x);
    }
    function bisect_right(a, x, lo = 0, hi = null) { // > upper_bound
        if (lo < 0) throw new Error('lo must be non-negative');
        if (hi == null) hi = a.length;
        while (lo < hi) {
            let mid = parseInt((lo + hi) / 2);
            a[mid] > x ? hi = mid : lo = mid + 1;
        }
        return lo;
    }
    function insort_left(a, x, lo = 0, hi = null) {
        lo = bisect_left(a, x, lo, hi);
        a.splice(lo, 0, x);
    }
    function bisect_left(a, x, lo = 0, hi = null) { // >= lower_bound
        if (lo < 0) throw new Error('lo must be non-negative');
        if (hi == null) hi = a.length;
        while (lo < hi) {
            let mid = parseInt((lo + hi) / 2);
            a[mid] < x ? lo = mid + 1 : hi = mid;
        }
        return lo;
    }
}

// Accepted 3 min more
const solve = (n, q, a, k) => {
    // pr(n, q, a, k)
    let s = [], sum = 0, bi = new Bisect(), res = [];
    for (const x of a) {
        sum += x;
        s.push(sum);
    }
    let min = [a[0]], cur = a[0];
    for (let i = 1; i < n; i++) {
        cur = Math.max(cur, a[i]);
        min.push(cur);
    }
    // pr(min);
    for (let h of k) {
        let i = bi.bisect_right(min, h) - 1;
        // pr('h', h, 'i', i);
        let v = s[i] || 0;
        res.push(v);
    }
    pr(res.join(" "))
};

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let t = ni();
        while (t--) {
            let [n, q] = nai(), a = nai(), k = nai();
            solve(n, q, a, k);
        }
    });
};

main()