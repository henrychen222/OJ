// 04/30/22 morning
package leetcode.biweekly.r77;

import java.util.Arrays;

class C {
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        char[][] visit = new char[n][m];
        // tr(visit, visit[0][0], visit[0][0] == 0);
        int cnt = 0;
        for (int[] wall : walls) visit[wall[0]][wall[1]] = 'W';
        for (int[] guard : guards) visit[guard[0]][guard[1]] = 'G';
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for (int j = y + 1; j < m; j++) { // right
                if (hit(visit[x][j])) break;
                visit[x][j] = 'R';
            }
            for (int j = y - 1; j >= 0; j--) { // left
                if (hit(visit[x][j])) break;
                visit[x][j] = 'R';
            }
            for (int i = x + 1; i < n; i++) { // down
                if (hit(visit[i][y])) break;
                visit[i][y] = 'R';
            }
            for (int i = x - 1; i >= 0; i--) { // up
                if (hit(visit[i][y])) break;
                visit[i][y] = 'R';
            }
        }
        // tr(visit);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    boolean hit(char cur) {
        if (cur == 'W') return true;
        if (cur == 'G') return true;
        return false;
    }

    public void run() {
        int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}},
                walls = {{0, 1}, {2, 2}, {1, 4}};
        tr(countUnguarded(m, n, guards, walls));
    }

    public static void main(String[] args) {
        new C().run();
    }

    void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}