package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A나누기B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        System.out.println(a/b);
        br.close();
    }
}
