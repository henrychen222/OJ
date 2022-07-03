/**
 * 07/06/21 evening 07/07/21 morning complete
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/queens-attack-2/submissions/code/222449982
const queensAttack = (n, k, r_q, c_q, obstacles) => {
    let block = new Set();
    let visit = new Set();
    let ob = [];
    for (const [i, j] of obstacles) ob.push([n - i, j - 1]);
    let [qr, qc] = [n - r_q, c_q - 1];
    for (const [i, j] of ob) block.add(i + " " + j);
    let res = 0;
    for (let i = qr; ~i; i--) {
        let ke = i + " " + qc;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (i != qr)) {
            res++;
            visit.add(ke);
        }
    }
    for (let i = qr; i < n; i++) {
        let ke = i + " " + qc;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (i != qr)) {
            res++;
            visit.add(ke);
        }
    }
    for (let j = qc; ~j; j--) {
        let ke = qr + " " + j;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (j != qc)) {
            res++;
            visit.add(ke);
        }
    }
    for (let j = qc; j < n; j++) {
        let ke = qr + " " + j;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (j != qc)) {
            res++;
            visit.add(ke);
        }
    }
    let [row, col] = [qr, qc];
    while (1) {
        if (row - 1 < 0 || col - 1 < 0) break;
        row--;
        col--;
        let ke = row + " " + col;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (row != qr || col != qc)) {
            res++;
            visit.add(ke);
        }
    }
    [row, col] = [qr, qc];
    while (1) {
        if (row + 1 >= n || col + 1 >= n) break;
        row++;
        col++;
        let ke = row + " " + col;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (row != qr || col != qc)) {
            res++;
            visit.add(ke);
        }
    }
    [row, col] = [qr, qc];
    while (1) {
        if (row - 1 < 0 || col + 1 >= n) break;
        row--;
        col++;
        let ke = row + " " + col;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (row != qr || col != qc)) {
            res++;
            visit.add(ke);
        }
    }
    [row, col] = [qr, qc];
    while (1) {
        if (row + 1 >= n || col - 1 < 0) break;
        row++;
        col--;
        let ke = row + " " + col;
        if (block.has(ke)) break;
        if (!visit.has(ke) && (row != qr || col != qc)) {
            res++;
            visit.add(ke);
        }
    }
    return res;
};

// WA memory out
// code from https://leetcode.com/problems/queens-that-can-attack-the-king/
const queensAttack1 = (n, k, r_q, c_q, obstacles) => {
    // pr(obstacles)
    let block = initialize2DArrayNew(n, n);
    let visit = initialize2DArrayNew(n, n);
    let ob = [];
    for (const [i, j] of obstacles) ob.push([n - i, j - 1]);
    // pr(ob)
    let [qr, qc] = [n - r_q, c_q - 1];
    // pr(qr, qc)
    for (const [i, j] of ob) block[i][j] = 1;
    let res = 0;
    for (let i = qr; ~i; i--) { // first top
        if (block[i][qc]) {
            break;
        }
        if (visit[i][qc] == 0 && (i != qr)) {
            res++;
            visit[i][qc] = 1;
        }
    }
    // pr(res);
    for (let i = qr; i < n; i++) { // first down
        if (block[i][qc]) {
            break;
        }
        if (visit[i][qc] == 0 && (i != qr)) {
            res++;
            visit[i][qc] = 1;
        }
    }
    for (let j = qc; ~j; j--) { // first left
        if (block[qr][j]) {
            break;
        }
        if (visit[qr][j] == 0 && (j != qc)) {
            res++;
            visit[qr][j] = 1;
        }
    }
    for (let j = qc; j < n; j++) { // first right
        if (block[qr][j]) {
            break;
        }
        if (visit[qr][j] == 0 && (j != qc)) {
            res++;
            visit[qr][j] = 1;
        }
    }
    let [row, col] = [qr, qc];
    while (1) { // first top left
        if (row - 1 < 0 || col - 1 < 0) break;
        row--;
        col--;
        if (block[row][col]) {
            break;
        }
        if (visit[row][col] == 0 && (row != qr || col != qc)) {
            res++;
            visit[row][col] = 1;
        }
    }
    [row, col] = [qr, qc];
    while (1) { // first down right
        if (row + 1 >= n || col + 1 >= n) break;
        row++;
        col++;
        if (block[row][col]) {
            break;
        }
        if (visit[row][col] == 0 && (row != qr || col != qc)) {
            res++;
            visit[row][col] = 1;
        }
    }
    [row, col] = [qr, qc];
    while (1) { // first top right
        if (row - 1 < 0 || col + 1 >= n) break;
        row--;
        col++;
        if (block[row][col]) {
            break;
        }
        if (visit[row][col] == 0 && (row != qr || col != qc)) {
            res++;
            visit[row][col] = 1;
        }
    }
    [row, col] = [qr, qc];
    while (1) { // first down left
        if (row + 1 >= n || col - 1 < 0) break;
        row++;
        col--
        if (block[row][col]) {
            break;
        }
        if (visit[row][col] == 0 && (row != qr || col != qc)) {
            res++;
            visit[row][col] = 1;
        }
    }
    return res;
};

const initialize2DArrayNew = (n, m) => {
    let data = [];
    for (let i = 0; i < n; i++) {
        let tmp = Array(m).fill(0);
        data.push(tmp);
    }
    return data;
};

const pr = console.log;
const main = () => {
    let n = 5, k = 3, r_q = 4, c_q = 3, obstacles = [[5, 5], [4, 2], [2, 3]];
    let n2 = 4, k2 = 0, r_q2 = 4, c_q2 = 4, obstacles2 = [];
    let n_debug1 = 100000, k_debug1 = 0, r_debug1 = 4187, c_debug1 = 5068, obstacles_debug1 = [];
    pr(queensAttack(n, k, r_q, c_q, obstacles))
    pr(queensAttack(n2, k2, r_q2, c_q2, obstacles2))
    pr(queensAttack(n_debug1, k_debug1, r_debug1, c_debug1, obstacles_debug1)) // 308369
};

main()
