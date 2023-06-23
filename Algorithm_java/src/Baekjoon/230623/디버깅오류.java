import java.util.Scanner;

public class 디버깅오류 {
    public static void main(String[] args) {
        // TODO 배열에서 주어진 범위의 합을 구하는 프로그램
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        long answer = 0;
        // 빈 숫자 배열 선언
        int A[] = new int[100001];
        int S[] = new int[100001];
        for (int i = 1; i < 100000; i++) {
            A[i] = (int) (Math.random() * Integer.MAX_VALUE);
            S[i] = S[i - 1] + A[i];
        }
        for (int t = 1; t < testcase; t++) {
            int query = sc.nextInt();
            answer = 0;
            for (int i = 0; i < query; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                answer += S[end] - S[start - 1];
                System.out.println(t + " " + answer);
            }
        }
    }
}