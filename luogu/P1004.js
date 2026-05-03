/**
 * 11/02/23 night
 * https://www.luogu.com.cn/problem/P1004
 */
const pr = console.log;

const { MinPriorityQueue } = require('@datastructures-js/priority-queue')
function edge(from, to, cost, cap) {
    this.from = from;
    this.to = to;
    this.cost = cost;
    this.cap = cap;
}

function MCMF(n) {
    const initializeGraph = (n) => { let g = []; for (let i = 0; i < n; i++) { g.push([]); } return g; };
    let g = initializeGraph(n), h = Array(n).fill(0), dis = Array(n).fill(0), prev_v = Array(n).fill(0), prev_e = Array(n).fill(0);
    return { addEdge, minCostFlow }
    function addEdge(from, to, cost, cap) {
        g[from].push(new edge(g[to].length, to, cost, cap));
        g[to].push(new edge(g[from].length - 1, from, -cost, 0));
    }
    function minCostFlow(from, to, flow) {
        let res = 0;
        while (flow > 0) {
            let pq = new MinPriorityQueue({
                compare: (x, y) => {
                    if (x[0] != y[0]) return x[0] - y[0];
                    return x[1] - y[1];
                }
            });
            dis.fill(Number.MAX_SAFE_INTEGER);
            dis[from] = 0;
            pq.enqueue([0, from]);
            while (pq.size()) {
                let [curDis, cur] = pq.dequeue();
                if (dis[cur] < curDis) continue;
                for (let i = 0; i < g[cur].length; i++) {
                    let child = g[cur][i];
                    if (child.cap > 0 && dis[child.to] > dis[cur] + child.cost + h[cur] - h[child.to]) {
                        dis[child.to] = dis[cur] + child.cost + h[cur] - h[child.to];
                        prev_v[child.to] = cur;
                        prev_e[child.to] = i;
                        pq.enqueue([dis[child.to], child.to]);
                    }
                }
            }
            if (dis[to] == Number.MAX_SAFE_INTEGER) return -1;
            for (let i = 0; i < n; i++) h[i] += dis[i];
            let d = flow;
            for (let i = to; i != from; i = prev_v[i]) {
                d = Math.min(d, g[prev_v[i]][prev_e[i]].cap);
            }
            flow -= d;
            res += d * h[to];
            for (let i = to; i != from; i = prev_v[i]) {
                let edge = g[prev_v[i]][prev_e[i]];
                edge.cap -= d;
                g[i][edge.from].cap += d;
            }
        }
        return res;
    }
}

const flowIn = (n, m, x, y) => m * x + y + 1;
const flowOut = (n, m, x, y) => n * m + flowIn(n, m, x, y);

const solve = (g) => {
    let n = g.length, m = g[0].length, tot = n * m, from = 2 * tot, to = from + 1, pair = tot * (tot - 1) / 2, mcmf = new MCMF(pair);
    pr(g, tot, pair, from);
    mcmf.addEdge(0, 1, 0, 2);
    mcmf.addEdge(from, to, 0, 2);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            let inNode = i * m + j, outNode = n * m + inNode;
            mcmf.addEdge(inNode, outNode, 0, 1);
            mcmf.addEdge(inNode, outNode, -g[i][j], 1);
            if (i != n - 1) mcmf.addEdge(inNode, flowIn(n, m, i + 1, j), 0, 2);
            if (j != m - 1) mcmf.addEdge(inNode, flowIn(n, m, i, j + 1), 0, 2);
        }
    }
    pr("-------------")
    let res = -mcmf.minCostFlow(from, to, tot);
    pr(res)
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
        let n = ni(), g = [...Array(n)].map(() => Array(n).fill(0));
        for (let i = 0; i < n; i++) {
            let [x, y, v] = nai();
            g[x - 1][y - 1] = v;
        }
        solve(g);
    });
};

main()