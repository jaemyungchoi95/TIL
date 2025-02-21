package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선 자르기
public class BOJ1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		int[] arr = new int[K+1];
		int sum = 0;
		int cnt = 0;
		
		// 이미 가지고 있는 랜선의 각 길이를 입력받는다
		for (int i = 1; i <= K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		int avg = sum/N;
		// 3 + 3 + 1 + 2 => 9개 / 11 - 9 = 2
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
		System.out.println(avg);
		
		while(cnt < N) {
			for (int i = 1; i < arr.length; i++) {
				cnt += arr[i]/avg;
				System.out.println(cnt);
				if (i == arr.length-1) cnt = N;
			}
		}
	}
}
