import java.io.*;
import java.util.*;

public class BOJ_1940_주몽의명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 A 정렬해주기
        Arrays.sort(A);
        // 갑옷 갯수 cnt
        int cnt = 0;
        // 배열의 양 끝을 포인터로 지정
        int i = 0;
        int j = N - 1;
        // 포인터가 만날 때 까지 반복해서 재료 배열을 돌아보기
        while (i < j) {
            if (A[i] + A[j] < M) {
                // 두 재료의 합이 M보다 작으면 작은 번호를 +
                i++;
            } else if (A[i] + A[j] > M) {
                // 두 재료의 합이 M보다 크면 큰 번호를 -
                j--;
            } else {
                // 두 재료의 합이 M과 같으면 cnt + 1, 작은번호 +, 큰번호 -
                cnt += 1;
                i++;
                j--;
            }
        }
        System.out.println(cnt);
    }
}
