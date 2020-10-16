// 10.13 evening
import java.util.*;

// Time Limit 2206ms, have to change class name to Main
class D_RGBTriplets {
    static int solve(int N, String S) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (S.charAt(i) == S.charAt(j)) continue;
                for (int k = j + 1; k < N; k++) {
                    if (S.charAt(i) == S.charAt(k) || S.charAt(j) == S.charAt(k)) continue;
                    if ((j - i) == (k - j)) continue;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String S = scanner.next();
        System.out.println(solve(N, S));
    }
}
