// 불!
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 갯수
		
		// 상우하좌 탐색 배열
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		// 테스트케이스만큼 반복
		while (T > 0) {
			T--; //테스트케이스 진입하면서 차감
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 가로 길이
			int h = Integer.parseInt(st.nextToken()); // 세로 길이
			int m = w; // 가로길이 치환
			int n = h; // 세로길이 치환
			
			String[][] board = new String[n][m]; // 방의 배치를 담아줄 2차원 배열 선언
			int[][] vis = new int[n][m]; // 방문여부를 체크하기 위한 2차원 정수배열 선언
			// 최초 0으로 초기화되는데, 이는 미방문이고 1은 상근이, 2는 불이 방문한 것, 3은 벽으로 체크할 것
			// 상근이 조건 : 만약 방문하려는 곳이 board 배열에서 "#에 해당하지 않고" vis 배열에서 @ < 2 이면 갈 수 있다.
			// 불의 조건 : 만약 방문하려는 곳이 board 배열에서 "#에 해당하지 않고" vis 배열에서 * < 3 이면 갈 수 있다.

//			System.out.println(Arrays.deepToString(vis)); // 방문배열의 현황 확인
			
			int[] peopleLoc = new int[2]; // 상근이의 최초 위치
			List<int[]> fireLocArr = new ArrayList<>(); // 불의 최초 위치 배열
			
			// 벽, 불, 사람의 위치를 입력받아 준다.
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split("");
				for(int j = 0; j < m; j++) {
					board[i][j] = input[j];
					// 입력을 받는 중 @ 이면 사람 위치 배열에 담아주고
					if (input[j].equals("@")) {
						peopleLoc[0] = i;
						peopleLoc[1] = j;
						vis[i][j] = 1;
						// * 이면 불의 위치 배열에 담아준다
					} else if (input[j].equals("*")) {
						fireLocArr.add(new int[] {i, j});
						vis[i][j] = 2;
					} else if (input[j].equals("#")) {
						vis[i][j] = 3;
					}
				}
			}
			
//			불의 위치 잘 담겼는지 확인
//			System.out.println(Arrays.deepToString(peopleLocArr.toArray()));
//			System.out.println(Arrays.deepToString(fireLocArr.toArray()));
//			방문자 배열도 잘 감겼는지 확인
			System.out.printf("최초 vis 배열 : %s\n", Arrays.deepToString(vis));
			
			System.out.println();
			
			// 큐에 초기값으로 사람의 위치를 담아준다.
			Queue<int[]> qPeople = new LinkedList<>();
			qPeople.add(peopleLoc);
			
			// 큐에 초기값으로 사람의 위치와 불의 위치를 각각 담아준다
			Queue<int[]> qFire = new LinkedList<>();
			for (int i = 0; i < fireLocArr.size(); i++) {
				qFire.add(fireLocArr.get(i));
			}
			
			System.out.printf("최초 qPeople 값 : %s\n", Arrays.deepToString(qPeople.toArray()));
			System.out.printf("최초 qFire 값 : %s\n", Arrays.deepToString(qFire.toArray()));
			
			int cnt = 0;
			
			// 시작위치가 처음이 아니기 때문에 while문으로 배열을 순회해준다.
			boolean isTrue = true;
			while(isTrue) {
				// 사람의 현재 위치
				int[] curPeople = qPeople.remove();
				int curPX = curPeople[0];
				int curPY = curPeople[1];
				System.out.printf("curX : %d\n", curPX);
				System.out.printf("curY : %d\n", curPY);

				// 불의 현재 위치
				int[] curFire = qFire.remove();
				int curFX = curFire[0];
				int curFY = curFire[1];
				System.out.printf("curX : %d\n", curFX);
				System.out.printf("curY : %d\n", curFY);
				
				
				for (int i = 0; i < 4; i++) {
					int nPx = curPX + dx[i];
					int nPy = curPY + dy[i];
					System.out.printf("nPx : %d\n", nPx);
					System.out.printf("nPy : %d\n", nPy);
					int nFx = curFX + dx[i];
					int nFy = curFY + dy[i];
					System.out.printf("nFx : %d\n", nFx);
					System.out.printf("nFy : %d\n", nFy);
					// 탐색방향이 범위를 벗어나지 않도록 조건 설정
					if (nPx > 0 && nPx < n && nPy > 0 && nPy < m && nFx > 0 && nFx < n && nFy > 0 && nFy < m) {
						// 만약 현재 위치의 표시가 @ 이고, 탐색위치가 #가 아니면서 vis가 2 이하이면
						if (board[curX][curY].equals("@") && !board[nx][ny].equals("#") && vis[nx][ny] < 2) {
							queue.add(new int[] {nx, ny});
//							cnt++;
							System.out.printf("참일때 cnt : %d\n", cnt);
							// 만약 현재 위치의 표시가 * 이고, 탐색위치가 #가 아니면서 vis가 3 이하이면
						} else if (board[curX][curY].equals("*") && !board[nx][ny].equals("#") && vis[nx][ny] < 3) {
							queue.add(new int[] {nx, ny});
						}
						
						if (nx == 0 || ny == 0) {
							isTrue = false;
						}
					}
				}
				System.out.printf("while문 돌면서 queue 값 : %s\n", Arrays.deepToString(queue.toArray()));
			}
			System.out.printf("탈출에 걸린 시간 cnt : %d\n", cnt + 1);
		}
	}
}