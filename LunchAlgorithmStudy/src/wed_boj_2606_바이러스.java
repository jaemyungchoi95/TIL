import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class wed_boj_2606_바이러스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 대수
		int K = Integer.parseInt(br.readLine()); // 간선의 개수
		
		// 연결리스트 생성
		LinkedList<Integer>[] list = new LinkedList[N+1];
		for (int i = 0; i <= K; i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 가로 좌표
			int m = Integer.parseInt(st.nextToken()); // 세로 좌표
			// 리스트를 서로 양방향으로 연결한다
			list[n].add(m);
			list[m].add(n);
		}
		
		Queue<Integer> queue = new LinkedList<>(); //탐색을 위한 queue 설정
		boolean[] vis = new boolean[N+1]; // 방문여부 배열 선언
		int cnt = 0; // 감염된 컴퓨터의 수
		// 1번부터 탐색을 시작하기 위해 queue에 1을 넣고 vis에 1번 true 선언
		queue.add(1);
		vis[1] = true;
		
		// 큐가 비워져있지 않은 동안 탐색
		while(!queue.isEmpty()) {
			int cur = queue.poll(); // 현재 위치는 첫번째 탐색 대상
			// 리스트의 다음위치를 계속 탐색하면서
			for (int idx : list[cur]) {
				// 만약 지금 탐색한 위치가 탐색하지 않은 위치라면
				if (!vis[idx]) {
					queue.add(idx); // 큐에 담아주고
					vis[idx] = true; // 방문 표시를 해주고
					cnt++; // 횟수를 더해준다.
				}
			}
		}
		System.out.println(cnt);
	} // main 끝
	
} // 클래스 끝
