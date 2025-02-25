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
		int[] arr = Stream.of(br.readLine().split(" ")) // 배열을 입력받아준다
						  .mapToInt(Integer::parseInt)
						  .toArray();
		// 이분탐색을 위해 배열을 정렬해준다
		Arrays.sort(arr);
		
		int left = 0; // 0번인덱스에서부터 시작할 것임
		int right = N-1; // 마지막 인덱스에서부터 시작할 것임
		int cnt = 0; // 목표값을 구하기 위해 필요한 변수
		int subTotal = 0;
		int ans = 0;
		
		int mid = arr[arr.length/2]; // 중간값
		
		System.out.println(Arrays.toString(arr));
		System.out.println(mid);
		
		// 좌우측이 교차할 때까지 돌면서
		while (left <= right) {
			// 좌측의 값에 대한 비교 시작
			if (arr[left] > mid) {
				subTotal += arr[left]-mid;
				left++;
				cnt++;
			} else {
				left++;
			}
			
			// 우측의 값에 대한 비교 시작
			if (arr[right] > mid) {
				subTotal += arr[right]-mid;
				right--;
				cnt++;
			} else {
				right--;
			}
			
			// 돌던 중 만약 중간합계값이 목표보다 크면
			if (subTotal > M) {
				mid -= subTotal/cnt;
				// 중간합계값이 목표보다 작으면
			} else if (subTotal < M) {
				mid += subTotal/cnt;
				// 같으면 
			} else if (subTotal == M) {
				ans = mid;
				break;
			}
			
		}
		
		System.out.println(ans);
		
	} // main 끝
	
} // 클래스 끝
