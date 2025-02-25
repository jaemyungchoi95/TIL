import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tue_boj_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); // 세로 길이
		int W = Integer.parseInt(st.nextToken()); // 가로 길이
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
//		System.out.println(Arrays.toString(arr));
		
		boolean isAboveZero = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				isAboveZero = false;
			}
		}
		
		if (isAboveZero) {
			for (int i = 0; i < arr.length; i++) {
				arr[i]--;
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		
		int n = H;
		int m = W;
		
		int sum = 0;
		
		for (int i = n; i > 0; i--) {
			int cnt = 0;
			int subTotal = 0;
//			System.out.printf("i : %d\n", i);
			for (int j = 0; j < m; j++) {
				if (arr[j] >= i) {
					cnt++;
				}
				
				if (cnt == 1) {
					subTotal++;
				}
				
				if (cnt == 2) {
					sum += subTotal -1;
					cnt = 0;
				}
				// 위에서부터 내려오면서
//				System.out.printf("j : %d\n", j);
//				System.out.printf("arr[j] : %d\n", arr[j]);
//				System.out.printf("cnt : %d\n", cnt);
//				System.out.printf("subTotal : %d\n", subTotal);
//				System.out.printf("sum : %d\n", sum);
			}
		}
		System.out.println(sum);
	}
}
