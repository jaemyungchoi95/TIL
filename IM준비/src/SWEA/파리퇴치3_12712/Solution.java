package SWEA.파리퇴치3_12712;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 영역의 크기
			int M = sc.nextInt(); // 파리 스프레이의 범위
			int[][] board = new int[N][N]; // 파리의 마리수를 담아줄 배열
			
			// 배열에 파리의 마리수를 담아준다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			// 상우하좌 탐색
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			
			// 대각선 우상 우하 좌하 좌상 탐색
			int[] dx2 = {-1, 1, 1, -1};
			int[] dy2 = {1, 1, -1, -1};
			
			int max = 0; // 최대값을 담아줄 변수 선언
			
			// 보드를 탐색해주면서
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int xy = board[i][j]; // 좌우 값을 담아줄 변수
					int xy2 = board[i][j]; // 대각선 값을 담아줄 변수
					
					// 4방향 탐색 (상하좌우)
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx = i + dx[d] * k;
                            int ny = j + dy[d] * k;

                            // 상하좌우 방향이 보드를 벗어나지 않으면 누적
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                xy += board[nx][ny];
                            }
                        }
                    }

                    // 4방향 대각선 탐색
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx2 = i + dx2[d] * k;
                            int ny2 = j + dy2[d] * k;

                            // 대각선 방향이 보드를 벗어나지 않으면 누적
                            if (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < N) {
                                xy2 += board[nx2][ny2];
                            }
                        }
                    }
					
					// 최대값 판별 후 업데이트
                    max = Math.max(max, Math.max(xy, xy2));
					
				}
				
			}
			// 정답
			System.out.printf("#%d %d\n", test_case, max);
			
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝