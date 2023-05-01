class Solution {
    public int solution(int[][] sizes) {
        int max_n = 0;
        int min_n = 0;
        for (int i = 0; i < sizes.length; i++) {
            max_n = Math.max(max_n, Math.max(sizes[i][0], sizes[i][1]));
            min_n = Math.max(min_n, Math.min(sizes[i][0], sizes[i][1]));
        }
        return max_n * min_n;
    }
}