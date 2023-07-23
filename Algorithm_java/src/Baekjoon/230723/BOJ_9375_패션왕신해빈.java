import java.util.*;

public class BOJ_9375_패션왕신해빈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            HashMap<String, Integer> cloth = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String A = sc.next(), B = sc.next();
                cloth.put(B, cloth.getOrDefault(B, 0) + 1);
            }

            int result = 1;
            for (int val : cloth.values()) {
                result *= val + 1;
            }
            System.out.println(result - 1);
        }
    }
}
