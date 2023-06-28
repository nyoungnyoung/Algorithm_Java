import java.io.*;
import java.util.*;

public class BOJ_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        String[] str = br.readLine().split(" ");
        // A 배열의 값 입력 받기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> stack = new Stack<>();
        // 스택이 비어있을 때 인덱스 0번 push
        stack.push(0);
        for (int i = 1; i < N; i++) {
            // 스택이 비어있지 않고, 스택에서 peek한 인덱스값에 해당하는 배열의 값이 A[i]보다 큰 경우
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                // result[i]에 오큰수 저장해주기
                result[stack.pop()] = A[i];
            }
            // 스택에 다음 인덱스 값 push해주기
            stack.push(i);
        }
        // 스택에 값이 남아있으면 해당 인덱스에는 -1 저장해주기
        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }
        // 출력 위해 BufferedWriter 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // result 배열에 저장된 값 bw
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
