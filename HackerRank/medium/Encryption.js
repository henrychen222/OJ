/**
 * 05/06/21 evening
 * https://www.hackerrank.com/challenges/encryption/problem
 */


// Accepted --- https://www.hackerrank.com/challenges/encryption/submissions/code/212139688
const sq = Math.sqrt;
const ce = Math.ceil;
const encryption = (s) => {
    s = s.split(" ").join("");
    let sn = s.length;
    let max = ce(sq(sn));
    // pr(s, max)
    let d = [];
    while (s.length) {
        let tmp = s.slice(0, max);
        let len = tmp.length
        if (len < max) tmp += ' '.repeat(max - len);
        d.push(tmp);
        s = s.slice(max);
        // pr(tmp, s);
    }
    // pr(d);
    let n = d.length;
    let m = d[0].length;
    // pr(n, m)
    let res = [];
    for (let i = 0; i < m; i++) {
        let tmp = '';
        for (let j = 0; j < n; j++) {
            let c = d[j][i];
            // pr(c, j, i);
            if (c == ' ') continue;
            tmp += c;
        }
        res.push(tmp);
    }
    return res.join(" ");
};

const pr = console.log;
const main = () => {
    let example = 'if man was meant to stay on the ground god would have given us roots';
    let s = 'haveaniceday';
    let s2 = 'feedthedog';
    pr(encryption(example)); // imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
    pr(encryption(s));
    pr(encryption(s2));
};

main()