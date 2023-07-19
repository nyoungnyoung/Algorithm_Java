import java.util.*;
import java.io.*;

public class BOJ_18352_특정거리의도시찾기 {
    // 도시 개수 N, 도로 개수 M, 거리 K, 출발 도시 X
    static int N, M, K, X;
    // visited 배열, 그래프 표현할 인접리스트 graph
    static int visited[];
    static ArrayList<Integer>[] graph;
    // 최단거리가 K인 도시 리스트 result
    static ArrayList<Integer> result;
    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        // 그래프 초기화 & 입력받기
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            graph[S].add(E);
        }

        // 방문배열 초기화
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        // X도시에서 BFS 함수 실행
        BFS(X);

        // 방문배열 돌아보면서 값이 K인 애들 result에 추가해주기
        result = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                result.add(i);
            }
        }

        // result가 비어있으면 -1 출력
        if (result.isEmpty()) System.out.println("-1");
        // 아니면 result를 오름차순으로 정렬해서 출력해주기
        else {
            Collections.sort(result);
            for (int node: result) System.out.println(node);
        }


    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<Integer>();
        // 시작지점의 거리 0으로 바꿔주고 시작지점을 큐에 넣어주기
        visited[x] = 0;
        queue.add(x);
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 새로운 노드를 하나 큐에서 뽑아온다
            int node = queue.poll();
            // 해당노드와 연결된 노드 중
            for (int i: graph[node]) {
                // 방문한적 없는 노드이면(visited배열 값이 -1이면)
                if (visited[i] == -1) {
                    // 이전 노드의 거리 + 1 저장 & 큐에 넣어주기
                    visited[i] = visited[node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
