import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {

	static Stack<Integer> operand = new Stack<>();
	static Stack<Character> operator = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				
				// 숫자면 operand에 추가
				if (48 <= c && c <= 57)
					operand.push(c - '0');
				
				// 연산자일때
				else { 
					if (operator.isEmpty()) // 스택이 비었으면 바로 추가
						operator.push(c);
					else {
						if (c == '+') { // 덧셈이면 연산자 우선순위가 낮기 때문에 무조건 앞에꺼 먼저 연산
							calculate(operator.pop());
							operator.push(c);
						} else { // 곱셈이면 앞에 연산이 곱셈일 경우에만 먼저 연산
							if (operator.peek() == '*')
								calculate(operator.pop());
							operator.push(c); // 바로 앞이 더하기면 그냥 push
						}
					}
				} // end 연산자
			} // end for
			
			// 입력되는 값 끝났으면 스택에 들어있는 나머지 연산자 출력
			while (!operator.isEmpty()) {
				calculate(operator.pop());
			}
			
			// 출력문
			System.out.println("#" + t + " " + operand.pop());

		}

		// 스택 초기화
		operand.clear();
		operator.clear();

	} // end main

	// 계산하기
	private static void calculate(Character c) {
		int t2 = operand.pop();
		int t1 = operand.pop();

		if (c == '*')
			operand.push(t1 * t2);
		else
			operand.push(t1 + t2);
	} // end calculate

} 
