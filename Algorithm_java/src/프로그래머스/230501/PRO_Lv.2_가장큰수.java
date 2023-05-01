import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // int형 배열을 문자열 배열로 변환
        String []arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        
        // compareTo사용해서 내림차순 정렬해주기
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 0으로 이루어진 문자열이면 '0' return
        if (arr[0].equals("0")) return "0";
        
        // 정렬한 값 문자열로 바꿔주기
        return String.join("", arr);
    }
}