import java.util.*;

public class BOJ_11399_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        int S[] = new int[N];   // 합배열
        // A배열 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 삽입정렬하기
        for (int i = 1; i < N; i++) {
            int insert_i = i;       // 삽입할 인덱스
            int insert_v = A[i];    // 삽입할 값
            // 첫번째 값부터 i의 왼쪽 값까지 삽입 가능
            for (int j = i - 1; j >= 0; j--) {
                // A[j]가 현재 선택된 값(A[i])보다 작으면 그 위치 오른쪽에 삽입해주기
                if (A[j] < A[i]) {
                    insert_i = j + 1;
                    break;
                }
                // j가 첫번째값까지 온다면 삽입할 위치는 첫번째 인덱스!
                if (j == 0) {
                    insert_i = 0;
                }
            }
            // i부터 삽입할 위치까지의 값을 오른쪽으로 한칸씩 밀어주기
            for (int j = i; j > insert_i; j--) {
                A[j] = A[j - 1];
            }
            // 삽입 위치에 값 넣어주기
            A[insert_i] = insert_v;
        }
        // 정렬 끝나면 합배열 만들어주기
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }
        // 합배열의 숫자들 전부 더해주기
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += S[i];
        }
        System.out.println(result);
    }
}
