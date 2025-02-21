package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 나무 자르기
public class BOJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이
		int[] arr = Stream.of(br.readLine().split(" "))
						  .mapToInt(Integer::parseInt)
						  .toArray();
		
		int maxHeight = Arrays.stream(arr).max().orElse(0); // 톱니 높이의 후보로 최대값을 선정해준다
		
		int low = 0; // 시작 인덱스
		int high = maxHeight; // 끝 인덱스
		int mid = (low + high)/2; // 중간값 변수
		int ans = 0;
		
		// 두 길이가 교차할 때 까지 반복하면서
		while (low >= high) {
			int subTotal = 0; // 절단된 합계를 구하는 변수
			
			// 지속적으로 탐색해준다
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					subTotal += arr[i]-mid;
				}
			}
			
			// 중간 합계가 M보다 크다면
			if (subTotal > M) {
				low = mid; // 낮은 구간을 mid로 올려주고
				mid = (low + high)/2; // mid를 또 올려줍니다
				high = maxHeight;
				// 중간 합계가 M보다 작다면
			} else if (subTotal < M) {
				low = 0;
				high = mid;
				mid = (low + high)/2;
			} else if (subTotal == M) {
				ans = subTotal;
			}
		}
		
		System.out.println(ans);
		
		
	} // main 끝
	
} // 클래스 끝
