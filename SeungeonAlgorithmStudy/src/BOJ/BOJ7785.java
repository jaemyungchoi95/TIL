package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 출입기록의 수
		HashMap<String, String> map = new HashMap<>(); // 출근현황을 담아줄 해시맵 선언
		
		// 출입기록에 해당하는 사람을 담아준다
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken(); // 이름과
			String status = st.nextToken(); // 상태를 입력받아서
			map.put(name, status); // map에 이름이 key 상태가 value로 구분하여 넣어준다
		}
		
		ArrayList<String> arr = new ArrayList<>(); // 퇴근못한 사람들을 담아줄 배열
		
		for (String key : map.keySet()) { // 맵에 저장된 key들을 순회하면서
			if (map.get(key).equals("enter")) // 키값을 바탕으로 불러온 value가 "enter"과 일치하면
				arr.add(key); // 불쌍한 배열에 key값인 이름을 담아준다
		}
		
		Collections.sort(arr , Collections.reverseOrder()); // 리스트를 사전의 역순으로 정렬
		
		// 리스트를 순회하면서 답안 출력
		for (String name : arr) System.out.println(name);
	}
}
