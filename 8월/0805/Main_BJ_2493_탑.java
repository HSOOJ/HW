// 강사님 코드 참고했습니다.....

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 탑의 수
		StringTokenizer st = new StringTokenizer(br.readLine()); // 탑의 높이 정보
		Stack<int[]> stack = new Stack<>();
		/*
		  	새롭게 알게 된 것
		  	stack<int[]> : 스택에 integer 배열도 들어갈 수 있음
 			stack => [ (1,6) (2,9) (3,5) (4,7) (5,4) ]
		 */

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken()); // num: 탑의 높이

			while (!stack.empty()) { // 스택에 비교할 값이 존재한다면
				if (stack.peek()[1] > num) {
					// 수신할 수 있는 탑의 조건
					// 스택에 마지막으로 입력된 탑의 높이 > 새로 입력된 탑의 높이
					sb.append(stack.peek()[0] + " ");
					break;
				}
				stack.pop(); // remove
			}

			if (stack.empty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] { i, num });

		}
		System.out.println(sb);
	} // main
} // end class