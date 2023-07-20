import java.util.*;

public class BOJ_1697_숨바꼭질 {
    public static void main(String[] args) {
        // N, K 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        BFS(N, K);
    }

    // BFS함수 만들어주기
    private static void BFS(int n, int k) {
        // 큐, 방문배열 선언
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[100001];

        // 시작지점 큐에 넣기
        queue.offer(n);

        // 큐가 빌 때 까지
        while (!queue.isEmpty()) {
            // 노드 하나 큐에서 빼오기
            int node = queue.poll();
            // 노드가 k값이랑 같으면 node에 적힌 값 리턴
            if (node == k) {
                System.out.println(visited[node]);
                return;
            };
            // 방문가능한 노드 찾기위해 델타 선언
            int[] delta = {node - 1, node + 1, node * 2};
            // 노드에서 방문할수 있는 다음 노드들 중
            for (int next : delta) {
                // 범위를 벗어나지 않고, 방문한적 없으면
                if (next >= 0 && next < 100001 && visited[next] == 0) {
                    // 현재보다 + 1해서 방문체크해주고 큐에 넣기
                    visited[next] = visited[node] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
