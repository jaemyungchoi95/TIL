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
		int[] arr = new int[K]; // 랜선의 길이를 받아줄 배열 선언
		
		// 이미 가지고 있는 랜선의 각 길이를 입력받는다
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 길이를 오름차순 정렬
		Arrays.sort(arr);
		
		int str = 1; // 시작 탐색값
		int end = arr[arr.length-1]; // 최대범위 탐색 값
		int mid; // 중간 매개변수?
		int cnt; // 랜선의 개수 카운트 변수
		
		// cnt가 N과 같지 않을동안 반복하면서
		while(str <= end) {
			// 중간값은 탐색의 시작값과 동일하게 설정해줍니다
			// 아래 조건에 의해 str 혹은 end 값이 변경됨에 따라 mid변수를 다시 설정해줍니다
			mid = (str+end)/2;
			cnt = 0; // 다시 반복할때마다 카운트가 0이 되도록 설정
			
			// 현재의 mid값으로 나눈 몫을 cnt에 누적해주었을때
			for (int i = 0; i < arr.length; i++) {
				cnt += arr[i]/mid;
			}
			
			// 만약 cnt값이 N보다 작으면 mid를 줄여줘야 한다 (현재의 end값을 mid로 주어서 절반으로 범위를 줄임
			if (cnt < N) {
				end = mid -1; // 끝값에 min - 1만큼 감소시켜 대입해주고
				// 반대의 경우라면 시작값을 mid + 1씩 증가시켜 대입해준다
			} else if (cnt > N) {
				str = mid +1;
			}
		}
		// 정답 출력
		System.out.println(end);
		
	} // main 끝
	
} // 클래스 끝

/* 입력
4 11
802
743
457
539

출력
200
*/