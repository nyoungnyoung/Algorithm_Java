import java.util.*;

class Solution {
    // delta 선언(상/하/좌/우)
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
    
        // bfs 수행
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }
    
    // bfs 함수
    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;      // 첫 지점 방문처리
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});   // 첫 지점 큐에 넣어주기
        
        // 큐가 빌 때까지 반복해서
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // nx, ny가 범위 내에 있을때만 진행
                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) continue;
                
                // 방문한적 없고, 벽이 아니면 bfs 계속 수행!
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}