import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class thur_boj_9375_패션왕_신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		// 테스트케이스만큼 반복한다
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 해빈이의 의상 수
			List<String[]> garmentArr = new ArrayList<>(); // 의상을 담아줄 배열
			Set<String> whereArr = new HashSet<>(); // 부위를 담아줄 배열
			
			int cnt = n; // 총 횟수를 카운트 해주는데 n만큼은 한번씩만 딱 입어도 문제없어서 n으로 초기화
			
			// 주어지는 의상의 수만큼 반복하면서
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String clothing = st.nextToken();
				String where = st.nextToken();
				
				garmentArr.add(new String[] {where, clothing}); // 의류 배열에 키로 부위, 값으로 의복이름을 넣는다
				whereArr.add(where); // 부위는 set에 넣는다.
			}
			
			System.out.printf("germentArr : %s\n", Arrays.deepToString(garmentArr.toArray()));
			System.out.printf("whereArr : %s\n", whereArr);
			
			for (int i = 0; i < whereArr.size(); i++) {
				for (int j = 0; j < getment )
			}
			
			
		}
		
	}
	
}
