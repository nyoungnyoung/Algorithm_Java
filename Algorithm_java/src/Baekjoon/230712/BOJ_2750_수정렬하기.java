import java.io.*;
import java.util.*;

public class BOJ_2750_수정렬하기 {
    // 버블정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        // 배열 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 끝나는 지점 설정
        for (int i = 0; i < N- 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                // A[j]보다 A[j+1]이 더 크면 두 수를 바꿔줘야함
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }
}
