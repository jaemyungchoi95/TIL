package SWEA.삼성시의_버스_노선_6485;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {
	static Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			if (a[0]==b[0]) {
				return a[1]-b[1];
			} else {
				return a[0]-b[0];	
			}
		}
	});
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		pq.add(new int[] {1,1});
		pq.add(new int[] {5,-1});
		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			int time = item[0];
			boolean isStart = item[1]==1?true:false;
			
			if (time>3) break;
			if (isStart) {
				cnt++;
			} else {
				cnt--;
			}
		}
		System.out.println(cnt);
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 버스 노선의 개수
			int[][] lineArr = new int[N][]; // 버스노선의 개수를 담아줄 배열
			StringBuilder sb = new StringBuilder();
			
			// 노선을 운행하는 버스 노선을 받아준다
			for (int i = 0; i < N; i++) {
				int aLine = sc.nextInt(); // A노선 번호
				int bLine = sc.nextInt(); // B노선 번호
				
				lineArr[i] = new int[] {aLine, bLine};
			}
			
			int P = sc.nextInt(); // 정류장의 수를 입력받는다
			int[] pArr = new int[P+1]; // 정류장 번호를 받아줄 배열 선언
			int max = 0;
			// C1 ~ Cp 까지의 수 입력받는다
			for (int i = 1; i <= P; i++) {
				pArr[i] = sc.nextInt();
				if (pArr[i] > max) {
					max = pArr[i];
				}
			}
			
//			System.out.println(Arrays.toString(pArr));
			
//			System.out.println(max);
			
			int[] arr = new int[max+1];
			
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= P; j++) {
					if (pArr[j] >= lineArr[i][0] && pArr[j] <= lineArr[i][1]) {
						arr[pArr[j]]++;
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
		sc.close();
	} // main 끝
    
} // 클래스 끝