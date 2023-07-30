import java.util.*;
public class PRO_Lv0_주사위게임3 {
    class Solution {
        public int solution(int a, int b, int c, int d) {
            int answer = 0;
            // HashMap 쓰면 되는구나.. 멍청
            HashMap<Integer, Integer> map = new HashMap<>();
            // a, b, c, d 해시맵에 넣어주기
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
            map.put(d, map.getOrDefault(d, 0) + 1);
            // map의 key값 리스트로 만들어주기
            List<Integer> keys = new ArrayList<>(map.keySet());
            // map의 size에 따라 조건 분기
            switch (map.size()) {
                case 1:
                    return 1111 * a;
                case 2:
                    // keys의 첫번째 값이나 두번째 값이 1이면
                    if (map.get(keys.get(0)) == 1 || map.get(keys.get(1)) == 1) {
                        // 3개가 p, 1개가 q
                        int p = map.get(keys.get(0)) == 3? keys.get(0) : keys.get(1);
                        int q = map.get(keys.get(0)) == 1? keys.get(0) : keys.get(1);
                        return (int) Math.pow((10 * p) + q, 2);
                    }
                    // 아니면 2:2로 같음
                    else {
                        return (keys.get(0) + keys.get(1)) * Math.abs(keys.get(0) - keys.get(1));
                    }
                    // 두개 p, 나머지는 각각 q, r
                case 3:
                    // q, r값 구하기
                    int result = 0;
                    for (Integer key: map.keySet()) {
                        if (map.get(key) != 2) {
                            if (result == 0) {
                                result = key;
                            } else {
                                return result * key;
                            }
                        }
                    }
                    // 모두 다른 수일 경우 가장 작은 수
                case 4:
                    Collections.sort(keys);
                    return keys.get(0);
            }
            return answer;
        }
    }
}

