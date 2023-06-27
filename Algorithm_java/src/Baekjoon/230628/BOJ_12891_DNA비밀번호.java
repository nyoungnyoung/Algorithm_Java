import java.io.*;
import java.util.*;



public class BOJ_12891_DNA비밀번호 {
    static int check[];         // 비밀번호 체크에 사용할 배열 (전역변수로 선언해야 다른 함수 내에서도 사용 가능)
    static int now[];           // 현재 문자열의 상태 배열
    static int checkNum;        // 몇 개의 체크 요건을 통과했는지

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int cnt = 0;                    // 결과값 저장해줄 변수
        check = new int[4];
        now = new int[4];
        char Arr[] = new char[S];       // 입력받을 문자열
        checkNum = 0;

        // 데이터부터 받아주기
        Arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if (check[i] == 0) {
                // check[i]가 0이면 해당 문자열은 체크요건에 포함하지 않아도 됨(미리 반영)
                checkNum++;
            }
        }

        // 부분 문자열 처음 받을 때 세팅!
        for (int i =0; i < P; i++) {
            Add(Arr[i]);
        }

        // 처음에 받은 부분 문자열이 조건을 만족하는지 확인
        if (checkNum == 4) cnt++;

        // 슬라이딩 윈도우로 확인해주기(끝나는 지점 i, 시작지점 j 설정)
        for (int i = P; i < S; i++) {
            int j = i - P;
            // 새로 들어가는 문자열 now 배열에 추가
            Add(Arr[i]);
            // 빠져나가는 문자열 now 배열에서 삭제
            Remove(Arr[j]);
            // 조건 만족하면 cnt + 1
            if (checkNum == 4) cnt++;
        }
        System.out.println(cnt);
        br.close();
    }

    // 새로 now 배열에 추가될 문자를 처리해줄 함수 Add
    private static void Add(char c) {
        switch (c) {
            case 'A':
                now[0]++;
                if (now[0] == check[0]) checkNum++;
                break;
            case 'C':
                now[1]++;
                if (now[1] == check[1]) checkNum++;
                break;
            case 'G':
                now[2]++;
                if (now[2] == check[2]) checkNum++;
                break;
            case 'T':
                now[3]++;
                if (now[3] == check[3]) checkNum++;
                break;
        }
    }

    // now 배열에서 삭제될 문자를 처리해줄 함수 Remove
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (now[0] == check[0]) checkNum--;
                now[0]--;
                break;
            case 'C':
                if (now[1] == check[1]) checkNum--;
                now[1]--;
                break;
            case 'G':
                if (now[2] == check[2]) checkNum--;
                now[2]--;
                break;
            case 'T':
                if (now[3] == check[3]) checkNum--;
                now[3]--;
                break;
        }
    }
}
