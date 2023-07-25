import java.util.*;

public class BOJ_11279_최대힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 최대힙 만들어주기
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            // x가 0이면 poll() 연산(힙이 비었을 경우 0출력)
            if (x == 0) {
                if (heap.isEmpty()) System.out.println(0);
                else System.out.println(heap.poll());
            } else if (x > 0) {
                heap.add(x);
            }
        }
    }
}
