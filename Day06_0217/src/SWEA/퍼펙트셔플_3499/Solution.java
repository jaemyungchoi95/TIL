package SWEA.퍼펙트셔플_3499;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 카드의 개수
			Queue<String> fQ = new LinkedList<>(); // 처음 절반 카드를 담아준다
			Queue<String> lQ = new LinkedList<>(); // 나머지 카드를 담아준다
			StringBuilder sb = new StringBuilder(); // 문자를 담아줄 스트링빌더
			
			// 입력을 받아주면서
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				// 앞의 절반만큼은 fQ
				if (i < N/2 + N%2) {
					fQ.add(tmp);
					// 뒷부분은 lQ 에 담아준다
				} else {
					lQ.add(tmp);
				}
			}
			
			// 두 큐가 빌때까지 교차하면서 sb에 카드를 담아주는데
			while (!fQ.isEmpty() && !lQ.isEmpty()) {
				sb.append(fQ.poll()).append(" ");
				sb.append(lQ.poll()).append(" ");
			}
			
			// N이 홀수일 경우 fQ에는 카드가 남아있을 수 있기 때문에 한번 더 fQ만 체크해준다
			while (!fQ.isEmpty()) {
				sb.append(fQ.poll()).append(" ");
			}
			
			// 테스트케이스와 함께 완성된 정답 출력
			System.out.printf("#%d %s\n", test_case, sb.toString().trim());
			
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝