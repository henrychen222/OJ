/**
 * 07/04/22 morning
 * https://www.acwing.com/problem/content/136/
 */

const pr = console.log;

// Accepted --- https://www.acwing.com/problem/content/submission/code_detail/15175067/
// reference: https://www.acwing.com/solution/content/887/
const solve = (n, a) => {
    let max = Array(n + 1).fill(0), min = Array(n + 1).fill(0), cnt = 0, res = 0, monotonicity = true, h = 1 << 30;
    a = a.map((x, i) => [x, i + 1]);
    a.sort((x, y) => {
        if (x[0] == y[0]) return x[1] - y[1];
        return y[0] - x[0];
    })
    a.unshift([0, 0]);
    // pr(a);
    for (let i = 1; i <= n; i++) {
        if (a[i][0] != a[i - 1][0] || i == 1) {
            // pr(a[i-1][0], a[i][0])
            max[cnt] = a[i - 1][1];
            min[++cnt] = a[i][1];
        }
    }
    max[cnt] = a[n][1];
    // pr("cnt", cnt, a[n][1])
    // pr("min", min);
    // pr("max", max);
    for (let i = 1; i <= cnt; i++) {
        if (!monotonicity) {
            if (h > max[i]) {
                h = min[i];
            } else {
                h = max[i];
                monotonicity = true;
            }
        } else {
            if (h < min[i]) {
                h = max[i];
            } else {
                h = min[i];
                monotonicity = false;
                res++;
            }
        }
    }
    pr(res);
};

/////////////////////////////////////////////////////////////////////////////////////
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

function TreeSet(elements) {
    let ts = [], se = new Set(), bisect = new Bisect();
    initialize();
    return { add, first, last, poll, pollLast, floor, ceiling, lower, higher, remove, contains, size, clear, show };
    function initialize() {
        if (elements) {
            for (const e of elements) {
                if (!se.has(e)) {
                    bisect.insort_right(ts, e);
                    se.add(e);
                }
            }
        }
    }
    function add(e) {
        if (!se.has(e)) {
            bisect.insort_right(ts, e);
            se.add(e);
        }
    }
    function first() {
        return ts[0];
    }
    function last() {
        return ts[ts.length - 1];
    }
    function poll() {
        let res = ts[0];
        ts.splice(0, 1);
        se.delete(res);
        return res;
    }
    function pollLast() {
        let res = ts.pop();
        se.delete(res);
        return res;
    }
    function ceiling(e) { // >= lower_bound
        let idx = bisect.bisect_right(ts, e);
        let res = ts[idx - 1] == e ? e : ts[bisect.bisect_right(ts, e)];
        return res == undefined ? null : res;
    }
    function higher(e) { // > upper_bound
        let idx = bisect.bisect_right(ts, e);
        let res = ts[idx] > e ? ts[idx] : ts[bisect.bisect_right(ts, e) + 1];
        return res == undefined ? null : res;
    }
    function floor(e) { // <= 
        let idx = bisect.bisect_left(ts, e);
        let res = ts[idx] == e ? e : ts[bisect.bisect_left(ts, e) - 1];
        return res == undefined ? null : res;
    }
    function lower(e) { // <
        let idx = bisect.bisect_left(ts, e);
        let res = ts[idx] < e ? ts[idx] : ts[bisect.bisect_left(ts, e) - 1];
        return res == undefined ? null : res;
    }
    function remove(e) {
        let idx = bisect.bisect_left(ts, e);
        if (ts[idx] == e) ts.splice(idx, 1);
        se.delete(e);
    }
    function contains(e) {
        return se.has(e);
    }
    function size() {
        return ts.length;
    }
    function clear() {
        ts = [];
        se.clear();
    }
    function show() {
        return ts;
    }
}

// WA https://www.acwing.com/problem/content/submission/code_detail/15165124/
const solve1 = (n, a) => {
    let ts = new TreeSet(), res = 1;
    for (const x of a) {
        // pr(x, ts.show())
        if (ts.size() == 0) {
            ts.add(x);
        } else {
            if (x <= ts.first() || x >= ts.last()) {
                ts.add(x);
            } else {
                res++;
                ts.clear();
            }
        }
    }
    pr(res);
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
        let n = ni(), a = [];
        for (let i = 0; i < n; i++) a.push(ni())
        solve(n, a);
    });
};

main()