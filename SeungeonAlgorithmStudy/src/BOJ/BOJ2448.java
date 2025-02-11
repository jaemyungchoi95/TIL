package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정수 N
		
		StringBuffer sb = new StringBuffer(); // 별을 담아줄 stringBuffer
		sb.append("                       *"); // 먼저 공백 23개 + * 1개의 문자열을 담아준다.
		
		for (int i = N-1; i >= 1; i--) {
			
			System.out.println(i);
		}
		System.out.println(sb);
		
		
	}
}
