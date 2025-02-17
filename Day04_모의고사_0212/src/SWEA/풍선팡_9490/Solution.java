package SWEA.풍선팡_9490;

import java.util.Scanner;

// 제1회 IM 대비 (3) => pass
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 세로 길이
			int M = sc.nextInt(); // 가로 길이
			int[][] arr = new int[N][M]; // 꽃가루 풍선을 받아줄 정수 배열
			
			// 입력을 받으며 배열에 값을 넣어준다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 상우하좌 순으로 탐색
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			
			int max = -1; // 최대값을 담아줄 배열 선언
			
			// 전 배열을 순회하면서
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int sum = arr[i][j]; // 부분합을 담아줄 변수 선언, 자기 자신으로 초기화
					// 자기 자신의 위치만큼 반복하면서 탐색범위를 넓힐 예정
					for (int k = 1; k <= arr[i][j]; k++) { // k는 가중치
						// 4방향으로 탐색을 돌아준다
						for (int d = 0; d < 4; d++) {
							// 탐색 방향과 범위를 설정해주는데
							// 만약 자기위치에 꽃가루가 1이면 k는 1이기 때문에 한칸씩만 탐색
							// 음수를 고려하여 가중치의 범위는 배수로 부여한다. (원 수의 절대값이 1이기 때문에 가능)
							int nx = i + dx[d]*k;
							int ny = j + dy[d]*k;
							// 원 배열의 범위를 넘어지 않았을때만
							if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
								sum += arr[nx][ny];
							}
						}
					}
					// 만약 합계가 max보다 크다면 max를 업데이트 해준다
					if (sum > max) max = sum;
				}
			}
			// 정답 출력
			System.out.printf("#%d %d\n", test_case, max);
			
		} // 테스트케이스 끝
		
	} // main 끝
	
} // 클래스 끝
