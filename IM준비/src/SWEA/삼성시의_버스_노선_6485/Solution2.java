package SWEA.삼성시의_버스_노선_6485;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 버스 노선의 개수
			int[][] lineArr = new int[N][]; // 버스노선의 개수를 담아줄 배열
			StringBuilder sb = new StringBuilder();
			int max = 0;
			
			// 노선을 운행하는 버스 노선을 받아준다
			for (int i = 0; i < N; i++) {
				int aLine = sc.nextInt(); // A노선 번호
				int bLine = sc.nextInt(); // B노선 번호
				
				lineArr[i] = new int[] {aLine, bLine};
			}
			
			int P = sc.nextInt(); // 정류장의 수를 입력받는다
			int[] pArr = new int[P+1]; // 정류장 번호를 받아줄 배열 선언
			// C1 ~ Cp 까지의 수 입력받는다
			for (int i = 1; i <= P; i++) {
				int tmp = sc.nextInt();
				pArr[i] = tmp;
			}
			
//			System.out.println(Arrays.toString(pArr));
			
			for (int i : pArr) {
				if (i > max) {
					max = i;
				}
			}
			
//			System.out.println(max);
			
			int[] arr = new int[max+1];
			
			for (int i = 0; i < N; i++) {
				for (int j = lineArr[i][0]; j <= lineArr[i][1]; j++) {
					if (j == pArr[j]) {
						arr[j]++;
					}
				}
			}
			
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != 0) {
					sb.append(" ").append(arr[i]);
				}
			}
			
			// 정답 출력
			System.out.printf("#%d%s\n", test_case, sb);

		} // 테스트케이스 끝
		
	} // main 끝
    
} // 클래스 끝