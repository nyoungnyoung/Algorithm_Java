import java.util.*;
import java.io.*;

public class BOJ_1926_그림 {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그림 입력받기
        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j= 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 수행하기
        int cnt = 0, max_a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    cnt += 1;
                    max_a = Math.max(max_a, bfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max_a);
    }

    private static int bfs(int i, int j) {
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        // 큐가 빌 때까지 탐색 수행
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            // 델타 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                // nx, ny가 범위 내에 있고
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    // 방문한적없는 1일 때
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        area += 1;
                    }
                }
            }
        }
        return area;
    }
}
