package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 자연수 N
		int M = Integer.parseInt(st.nextToken()); // 수열의 길이
		
		// 재귀함수 호출
		calc(N, M);
		
	}
	
	static void calc(int n, int m) {
		int cnt = m;
		
		for (int i = 1; i <= n; i++) {
			StringBuffer sb = new StringBuffer(Integer.toString(i));
			// 수열의 길이가 1 이상이면 j는 1부터 m까지 순환
			if (m != 1) {
				for (int j = 1; j <= m; j++) {
					
				}
			}
			System.out.println(sb);
		}
		
	}
}
