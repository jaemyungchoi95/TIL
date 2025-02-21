package SWEA.힙_2930;

import java.util.PriorityQueue;
import java.util.Scanner;
// 2930. 힙
public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 테스트케이스 만큼 반복한다
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 연산의 수 N을 입력받는다
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
			StringBuilder sb = new StringBuilder(); // 연산결과를 담아줄 스트링빌더 선언
			
			// 주어진 연산의 수만큼 입력받는다
			for (int i = 0; i < N; i++) {
				int cmd = sc.nextInt(); // 연산유형
				int num = 0; // 연산의 숫자를 0으로 초기화 해준다
				// 만약 연산유형이 1이며, 다음 입력이 있으면
				if (cmd == 1) {
					num = sc.nextInt(); // num에 입력받은 숫자를 넣어준다
					pq.add(num); // 업데이트 된 num을 힙에 넣어준다
					// 입력받은 숫자가 2라면
				} else {
					// 스트링빌더에 수를 담아준다
					if (!pq.isEmpty()) {
						sb.append(" ").append(pq.poll());
					} else {
						sb.append(" ").append("-1");
					}
				}
			}
			
			// 스트링빌더를 문자열에 담아준다.
			String str = sb.toString();
			
			// 테스트케이스 
			System.out.printf("#%d%s\n",test_case, str);
			
		} // 테스트케이스 끝
        sc.close();
	} // main 끝
    
} // 클래스 끝
