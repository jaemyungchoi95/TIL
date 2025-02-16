package SWEA.오목_판정_11315;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 하나의 정수
			sc.nextLine(); // 개행문자 제거
			String[][] board = new String[N][N]; // 오목판 상태를 담아줄 배열
			
			// 배열에 오목알의 상태를 담아준다
			for (int i = 0; i < N; i++) {
				board[i] = sc.nextLine().split("");
			}
			
			// 8방향 탐색을 위한 배열 선언
			// 상 우상 우 우하 하 좌하 좌 좌상
			int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
			int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
			String answer ="NO";
			
			// 보드를 탐색해주면서
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 만약 현재 위치에 "o"가 있지 않으면 다음 반복으로 넘어간다
					if (!board[i][j].equals("o")) continue;
					
					// 8방향 탐색
					for (int d = 0; d < 8; d++) {
						int cnt = 1;
						// 가중치 부여
						for (int k = 1; k < 5; k++) {
							int nx = i + k*dx[d];
							int ny = j + k*dy[d];
							
							// 범위를 벗어나면 탐색 중단
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
							
							// "o"를 만나면 cnt 하나씩 증가하는데 
							if (board[nx][ny].equals("o")) {
								cnt++;
								// 만약 cnt가 5가 되면 YES로 만들고 반복문 중단 
								if (cnt == 5) {
									answer = "YES";
									break;
								}
							}
						}
						if (answer.equals("YES")) break; // 이미 오목이 완성되면 중단
					}
					if (answer.equals("YES")) break;
				}
				if (answer.equals("YES")) break;
			}
			// 정답 출력
			System.out.printf("#%d %s\n", test_case, answer);
			
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝