'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function (inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function () {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * 04/05/23 afternoon
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/
 */

const pr = console.log;

const sortstr = (s) => s.split("").sort().join("");

const ll = BigInt;
const combination = (m, n) => { return factorial(m, n) / factorial(n, n); };
const factorial = (m, n) => { let res = 1n; let cnt = 0; for (let i = ll(m); i > 0; i--) { if (cnt == n) break; res *= i; cnt++; } return res; };

// Accepted
function sherlockAndAnagrams(s) {
    let n = s.length, all = new Map(), res = 0n;
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            let sub = sortstr(s.slice(i, j + 1));
            all.set(sub, all.get(sub) + 1 || 1);
        }
    }
    // pr(all)
    for (const [s, occ] of all) {
        if (occ >= 2) res += combination(ll(occ), 2n);
    }
    return res.toString();
}

function main() {
    const q = parseInt(readLine().trim(), 10);
    for (let qItr = 0; qItr < q; qItr++) {
        const s = readLine();
        const result = sherlockAndAnagrams(s);
        pr(result);
    }
}
