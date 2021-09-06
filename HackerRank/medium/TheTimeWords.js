/**
 * 07/06/21 evening
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/the-time-in-words/submissions/code/222349480
const timeInWords = (h, m) => {
    // pr(h, m)
    let readh = goh(h);
    let nexth = goh(h + 1);
    let readm = gom(m);
    if (m == 0) {
        return `${readh} o' clock`;
    } else if ((m >= 1 && m <= 14) || (m >= 16 && m <= 29)) {
        let mt = m == 1 ? 'minute' : 'minutes';
        return `${readm} ${mt} past ${readh}`;
    } else if (m == 15) {
        return `quarter past ${readh}`;
    } else if (m == 30) {
        return `half past ${readh}`;
    } else if ((m >= 31 && m <= 44) || (m >= 46 && m <= 59)) {
        let to = 60 - m;
        let mt = to == 1 ? 'minute' : 'minutes';
        let readto = gom(to);
        return `${readto} ${mt} to ${nexth}`;
    } else if (m == 45) {
        return `quarter to ${nexth}`;
    }
};

const a = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten', 'eleven', 'twelve'];
const goh = (h) => a[h - 1];

const b = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
const c = ['ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nighteen'];
const d = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
const gom = (m) => {
    let x = (m + '').split("").map(Number);
    if (x.length == 1) {
        return d[x[0]];
    }
    // pr(x);
    let res = '';
    if (x[0] == 0) {
        res += b[x[1]];
    } else if (x[0] == 1) {
        res += c[x[1]];
    } else if (x[0] == 2) {
        res += `twenty ${b[x[1]]}`;
    } else if (x[0] == 3) {
        res += `thirty ${b[x[1]]}`;
    } else if (x[0] == 4) {
        res += `fourty ${b[x[1]]}`;
    } else if (x[0] == 5) {
        res += `fifty ${b[x[1]]}`;
    }
    return res;
};

const pr = console.log;
const main = () => {
    let h = 5, m = 47;
    let h2 = 3, m2 = 00;
    let h3 = 7, m3 = 15;
    let h_test1 = 5, m_test1 = 59;
    let h_test2 = 5, m_test2 = 01;
    let h_test3 = 5, m_test3 = 10;
    let h_test4 = 5, m_test4 = 15;
    let h_test5 = 5, m_test5 = 30;
    let h_test6 = 5, m_test6 = 28;
    let h_test7 = 5, m_test7 = 40;
    pr(timeInWords(h, m))
    pr(timeInWords(h2, m2))
    pr(timeInWords(h3, m3))
    pr(timeInWords(h_test1, m_test1))
    pr(timeInWords(h_test2, m_test2))
    pr(timeInWords(h_test3, m_test3))
    pr(timeInWords(h_test4, m_test4))
    pr(timeInWords(h_test5, m_test5))
    pr(timeInWords(h_test6, m_test6))
    pr(timeInWords(h_test7, m_test7))
};

main()

// pr(gom(00));
// pr(gom(01));
// pr(gom(03));
// pr(gom(09));
// pr(gom(10));
// pr(gom(13));
// pr(gom(19));
// pr(gom(20));
// pr(gom(21));
// pr(gom(29));
// pr(gom(30));
// pr(gom(31));
// pr(gom(39));
// pr(gom(40));
// pr(gom(41));
// pr(gom(47));
// pr(gom(49));
// pr(gom(50));
// pr(gom(51));
// pr(gom(59));


// pr(goh(1))
// pr(goh(2))
// pr(goh(3))
// pr(goh(4))
// pr(goh(5))
// pr(goh(6))
// pr(goh(7))
// pr(goh(8))
// pr(goh(9))
// pr(goh(10))
// pr(goh(11))
// pr(goh(12))
