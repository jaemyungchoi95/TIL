package SWEA.준홍이의_카드놀이_7102;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 첫번째 카드세트
            int M = sc.nextInt(); // 두번째 카드세트
            int max = 0; // 빈도수의 최대값을 담아줄 변수 선언
            StringBuilder sb = new StringBuilder();
             
            // 계산결과의 빈도수를 더해주기 위한 배열 선언
            int[] arr = new int[N+M+1];
             
            // 배열에 계산결과를 담아준다
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    arr[i+j]++;
                }
            }
             
            // 배열을 돌면서 최대값을 찾아 max에 넣어주고
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
            }
             
            // max와 일치하는 인덱스를 sb에 공백과 함께 담아준다
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] == max) {
                    sb.append(" " + Integer.toString(i));
                }
            }
             
            // 테스트케이스 정답 출력
            System.out.println("#" + test_case + sb.toString());
             
        } // 테스트케이스 끝
         
    } // main 끝
     
} // 클래스 끝