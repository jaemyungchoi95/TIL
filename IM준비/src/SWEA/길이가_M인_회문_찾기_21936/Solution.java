package SWEA.길이가_M인_회문_찾기_21936;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 문자열의 길이
			int M = sc.nextInt(); // 찾을 회문문자의 길이
			String str = sc.next(); // 주어진 문자열
			String[] tmp = new String[N-M+1]; // 원본 문자열을 담아줄 배열
			String[] revTmp = new String[N-M+1]; // 변환한 문자열을 담아줄 배열
			
			// 대상 문자열만큼 반복하면서 
			for (int i = 0; i <= N-M; i++) {
				StringBuilder sb = new StringBuilder(str.substring(i, i+M)); // 스트링빌더에 찾을 길이만큼을 넣어주고
				tmp[i] = sb.toString(); // 문자열 원본 임시배열에 담아준다 
				sb.reverse(); // 문자를 뒤집어준 후
				revTmp[i] = sb.toString(); // 뒤집어진 문자열 임시배열에 담아준다
			}
			
			String answer = "";
			int cnt = 0;
			// 문자열들을 서로 비교하면서
			for (int i = 0; i <= N-M; i++) {
				// 같은 인덱스에 동일한 문자열이 있다면 회문이 있는 것임
				if (tmp[i].equals(revTmp[i])) {
					answer = tmp[i];
					cnt++;
				}
			}
			
			// 회문이 한개이상 나왔으면 회문 문자 출력
			if (cnt > 0) {
				System.out.printf("#%d %s\n", test_case, answer);
				// 한번도 회문이 나오지 않았으면 NONE을 출력
			} else {
				System.out.printf("#%d %s\n", test_case, "NONE");
			}
			
		} // 테스트케이스 끝
        
	} // main 끝

} // 클래스 끝
