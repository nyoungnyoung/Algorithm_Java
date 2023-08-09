import java.util.*;
import java.io.*;

public class BOJ_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // price 배열 입력받기
        int[][] price = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp배열 생성
        int[][] dp = new int[N][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = price[0][i];
        }

        // dp 배열 채워넣기
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];
        }

        // dp배열의 마지막 줄에서 min값 출력
        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
    }
}
