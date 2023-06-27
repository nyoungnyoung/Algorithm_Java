import java.util.*;

public class BOJ_2018_수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 1;
        int start_i = 0;
        int end_i = 0;
        int sum = 0;
        while (end_i != N) {
            if (sum == N) {
                cnt++;
                end_i++;
                sum+= end_i;
            } else if (sum > N) {
                sum -= start_i;
                start_i++;
            } else {
                end_i++;
                sum += end_i;
            }
        }
        System.out.println(cnt);
    }
}
