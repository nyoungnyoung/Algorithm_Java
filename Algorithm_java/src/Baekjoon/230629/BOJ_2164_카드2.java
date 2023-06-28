import java.util.*;

public class BOJ_2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        // 큐에 값 저장
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        // 큐에 카드가 한장 남을 때 까지 반복
        while (queue.size() > 1) {
            // 제일 위의 카드 한장 버리기
            queue.poll();
            // 제일 위에 있는 카드를 가장 아래쪽으로 이동해주기
            queue.add(queue.poll());
        }
        // 가장 마지막에 남아있는 카드번호 출력
        System.out.println(queue.poll());
    }
}

