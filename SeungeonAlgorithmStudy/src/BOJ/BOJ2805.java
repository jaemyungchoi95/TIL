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
		
		int str = 0; // 탐색을 시작할 값
		int end = arr[N-1]; // 탐색의 끝 값
		
//		System.out.println(Arrays.toString(arr));
		
		// 좌우측이 교차할 때까지 돌면서
		while (str <= end) {
			int cnt = 0; // 획득할 수 있는 나무의 수
			int mid = (str+end)/2; // 중간값은 조정된 시작값과 끝값을 바탕으로 업데이트
//			System.out.println("mid : " + mid);
			
			// 배열을 순회하면서
			for (int i = 0; i < arr.length; i++) {
				// 해당위치의 값이 중간값보다 클 경우에만
				if (mid < arr[i]) {
					// 나무길이 - 중간값을 뺀 값을 cnt에 더해준다
					cnt += arr[i]-mid;
				}
			}
//			System.out.println("cnt : " + cnt);
			
			// 만약 cnt가 필요한 나무의 수보다 적을 경우
			if (cnt < M) {
				end = mid -1; // 끝값을 mid -1로 조정해주고
			} else {
				str = mid +1; // 반대의 경우 시작값을 mid +1로 조정해준다
			}
			System.out.println("str : "+str);
			System.out.println("end : "+end);
			
		}
		
//		System.out.println("end : " + end);
		
		// 정답 출력
		System.out.println(end);
		
	} // main 끝
	
} // 클래스 끝
