/**
 * 06/30/21 evening
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */

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
            let mid = lo + hi >> 1;
            x < a[mid] ? hi = mid : lo = mid + 1;
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
            let mid = lo + hi >> 1;
            a[mid] < x ? lo = mid + 1 : hi = mid;
        }
        return lo;
    }
}

// Accepted https://www.hackerrank.com/challenges/climbing-the-leaderboard/submissions/code/221422098
function climbingLeaderboard(ranked, player) {
    let se = new Set(ranked);
    let u = [...se];
    u.sort((x, y) => x - y);
    // pr(u);
    let n = u.length;
    let res = [];
    let bi = new Bisect();
    for (const p of player) {
        let idx = bi.bisect_left(u, p);
        // pr(p, idx)
        let rank = (u[idx] == p ? n - idx : n - idx + 1)
        res.push(rank);
    }
    return res;
}

// TLE https://www.hackerrank.com/challenges/climbing-the-leaderboard/submissions/code/221421071
function climbingLeaderboard1(ranked, player) {
    let se = new Set(ranked);
    let u = [...se];
    let n = u.length;
    let res = [];
    for (const p of player) {
        let rank = n + 1;
        for (let i = 0; i < n; i++) {
            if (u[i] <= p) {
                rank = i + 1;
                break;
            }
        }
        res.push(rank);
    }
    return res;
}

const pr = console.log;
const main = () => {
  let ranked = [100,90, 90, 80, 75, 60], player = [50, 65, 77, 90, 102];
  pr(climbingLeaderboard(ranked, player))
};

main()
