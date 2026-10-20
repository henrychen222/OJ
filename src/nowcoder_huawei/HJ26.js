/**
 * 08/18/26 afternoon
 * https://www.nowcoder.com/practice/5190a1db6f4f4ddb92fd9c365c944584
 */
const pr = console.log;

const isLowerCase = (c) => /[a-z]/.test(c);
const isUpperCase = (c) => /[A-Z]/.test(c);
const isDigit = (c) => /[0-9]/.test(c);
const ord = (c) => c.charCodeAt();

// Accepted
const solve = (s) => {
    s = s.split("");
    let d = [], ia = [];
    for (let i = 0; i < s.length; i++) {
        if (isLowerCase(s[i]) || isUpperCase(s[i])) {
            d.push([s[i], i]);
            ia.push(i);
        }
    }
    // pr(d)
    d.sort((x, y) => {
        let [cx, ix] = x, [cy, iy] = y;
        if (cx.toLowerCase() == cy.toLowerCase()) {
            return ix - iy; // 同一字母的大小写同时存在时，按照输入顺序排列；
            return ord(cx.toLowerCase()) - ord(cy.toLowerCase()); // 按照字母表中的顺序排序（不区分大小写）
        }
    })
    // pr(d);
    ia.sort((x, y) => x - y)
    for (let i = 0; i < d.length; i++) {
        s[ia[i]] = d[i][0];
    }
    pr(s.join(""))
};

const ll = BigInt;
const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nl = () => ll(readLine());
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(ll);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let s = readLine();
        solve(s);
    });
};

main()