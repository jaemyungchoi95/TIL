// 코드 
package SWEA.파리퇴치_2001;

import java.util.Scanner;

// 2001. 파리 퇴치 D2
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 배열의 크기
			int M = sc.nextInt(); // 파리채의 크기
			int max = -1; // 최대값을 담아줄 변수
			
			int[][] arr = new int[N][N]; // 파리의 개수를 담아줄 배열
			// 파리의 개수를 담아줄 반복문
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 첫번째부터 전체 배열의 길이에서 파리채의 범위만큼 뺀 구간을 탐색한다
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					int sum = 0; // 임시 합을 담아줄 변수 선언
					// 기준 칸에 도달할 때 마다 파리채 범위만큼 갯수 합을 구해준다
					for (int k = i; k < i+M; k++) {
						for (int l = j; l < j+M; l++) {
							sum += arr[k][l]; // 파리채의 범위만큼 sum에 값을 담아준다
						}
					}
					
					// 만약 현재 max 값보다 sum이 더 높으면 max값 업데이트
					if (sum > max) {
						max = sum;
					}
				}
			}
			
			// 테스트 케이스와 최대값을 출력해준다
			System.out.printf("#%d %d\n", test_case, max);
			
		} // 테스트 케이스 끝
		
	} // 메인함수 끝
	
} // 클래스 끝
