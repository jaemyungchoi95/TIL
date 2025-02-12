package SWEA.재미있는_오셀로_게임_4615;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	// 8방향 탐색을 위한 배열 선언
	// 탐색 순서 {상, 우상, 우, 우하, 하, 좌하, 좌, 좌상}
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 보드의 한 변의 길이
			int M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수
			int[][] board = new int[N][N]; // 보드의 크기를 담아줄 2차원 정수배열 선언
			// board배열의 가운데 최초의 돌을 담아준다
			
			int tmp = 1; // 흑돌을 담아줄 때 값을 변화시켜줄 임시변수 선언
			for (int i = (N/2)-1; i <= N/2; i++) {
				board[i][i] = 2; // 백돌
				board[i][i+tmp] = 1; // 흑돌
				tmp -=2; // 흑돌을 1차로 잘 담았으면 tmp -2를 해줌
			}
			// 흑돌 : 1, 백돌 : 2
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}

			
			// 돌을 놓는 횟수만큼 돌면서 입력을 받아준다
			for (int i = 0; i < M; i++) {
				int n = sc.nextInt() - 1; // 세로 좌표
				int m = sc.nextInt() - 1; // 가로 좌표
				int color = sc.nextInt(); // 돌의 색상
				board[n][m] = color; // 보드의 각 좌표에 돌의 식을 입력해준다.
				
				Deque<int[]> stack = new ArrayDeque<>(); // Deque로 스택 자료구조를 사용한다
				
				// 돌을 놓은 위치를 기준으로 유효한 수가 맞는지 확인이 필요
				int K = 1; // 탐색범위 확장 변수
				boolean isTrue = true;
				while (isTrue) {
					// 8방향을 탐색하면서
					for (int j = 0; i < 8; j++) {
						// 현위치를 기준으로 설정해준다
						int nx = n + dx[j]*K;
						int ny = m + dy[j]*K;
						// 범위를 제한해주고
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
							// 만약 탐색 중 자신의 돌 색이 아닌 변수를 만나면
							if (board[nx][ny] != color) {
								stack.add(new int[] {nx, ny}); // 스택에 해당 좌표가 담긴 배열을 담아준다.
							}
						}
						if (nx < 0 && nx >= N && ny < 0 && ny >= M) isTrue = false;
					}
					K++; // 8방향의 탐색이 한번 끝날 때 마다 범위를 확장한다
				}
				
				// 수를 두고 stack에 상태 돌이 담겼으면 해당 돌에 대한 정보를 판단한다
				while (!stack.isEmpty()) {
					int[] temp = stack.removeFirst(); // stack에서 초기 변수를 꺼내준다
					int curX = temp[0];
					int curY = temp[1];
					
					
					
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
			
		} // 테스트케이스 끝
		
	} // main 끝
	
} // 클래스 끝
