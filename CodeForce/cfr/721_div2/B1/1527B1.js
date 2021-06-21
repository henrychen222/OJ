///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
const lge = Math.log;
const lg10 = Math.log10;
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);
const lcm = (a, b) => (a / gcd(a, b)) * b;
const amax = (a) => mx.apply(Math, a);
const amin = (a) => mi.apply(Math, a);
const sm = (a) => a.reduce(((x, y) => x + y), 0);
const aeq = (a, b) => JSON.stringify(a) == JSON.stringify(b);
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const stin = (a) => a.sort((x, y) => x - y);
const stde = (a) => a.sort((x, y) => y - x);
const counter = (a_or_s) => { let map = new Map(); for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1); return map; };
const isPalindrome = (s) => { let n = s.length; let i = 0; let j = n - 1; while (i < j) { if (s[i++] != s[j--]) return false; } return true; };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 05/20/21 morning
 * https://codeforces.com/contest/1527/problem/B1
 */

// TLE
const solve = (n, s) => {
    let se = new Set();
    for (let i = 0; i < n; i++) {
        if (s[i] == '0') se.add(i);
    }
    let a = s.split("");
    let Alice = Bob = 0;
    // replace '0' to '1' make s still palidrome in first priority
    let isP = true;
    let round = 1;
    let pre;
    // pr(a, se);
    // for (let i = 0; i <= 10; i++) {
    while (se.size) {
        if (isP == false && pre != 'rv') {
            // pr("reverse")
            a.reverse();
            pre = 'rv';
        } else {
            let did = false;
            for (const i of se) {
                if (i == n - 1 - i || a[n - 1 - i] == '1') {
                    a[i] = '1';
                    did = true; // still keep palidrome
                    // pr("111")
                    se.delete(i);
                    break;
                }
            }
            // pr(did)
            if (!did) {
                let first = se.values().next().value;
                // pr("2222", first, se)
                a[first] = '1';
                se.delete(first);
                isP = false;
            }
            round & 1 ? Alice++ : Bob++;
            pre = 'rp';
        }
        round++;
        // pr("next", a, se, isP, pre, Alice, Bob);
    }
    // pr(Alice, Bob);
    if (Alice > Bob) {
        pr("BOB");
    } else if (Alice < Bob) {
        pr("ALICE");
    } else {
        pr("DRAW")
    }
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


// let se = new Set([2, 3]);
// let it = se.values();
// pr(it.next().value)

// let a = [2, 3];
// a.reverse();
// pr(a);