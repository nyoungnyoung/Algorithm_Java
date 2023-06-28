import java.util.*;

public class BOJ_1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 스택 만들어주기
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        // 출력 값 저장해 줄 StringBuffer 선언
        StringBuffer bf = new StringBuffer();

        // 배열 돌면서 스택에 넣었다뺐다 해보기
        for (int i = 0; i < N; i++) {
            int now = A[i];
            // now가 현재 자연수보다 크거나 같다면
            if (now >= num) {
                // now가 num과 같아질때까지
                while (now >= num) {
                    // stack에 num을 넣어주고 값 +1, bf에 + 저장
                    stack.push(num++);
                    bf.append("+\n");
                }
                // now가 num과 같아지면 마지막 수 pop
                stack.pop();
                bf.append("-\n");
            } else {
                // 스택에서 숫자 하나 뽑아와서 now랑 비교
                int n = stack.pop();
                // n이 now보다 크면 오름차순으로 정렬할 수 없음!
                if (n > now) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    // n이 now와 같으면
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
