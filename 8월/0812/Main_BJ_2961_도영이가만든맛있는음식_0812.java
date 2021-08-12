import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_2961_도영이가만든맛있는음식_0812 {

	static Ingredient[] ing;
	static boolean[] isSelected;
	static int N;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 재료의 개수
		ing = new Ingredient[N]; // 신맛, 쓴맛

		isSelected = new boolean[N];
		res = Integer.MAX_VALUE; // 결과

		// 데이터 입력
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int B = sc.nextInt();
			ing[i] = new Ingredient(S, B); // 재료 클래스에 신맛, 쓴맛 입력
		}

		subset(0);

		System.out.print(res);

		sc.close();
	} // main

	// 재료 신맛, 쓴맛 클래스
	static class Ingredient {
		int S;
		int B;

		public Ingredient(int s, int b) {
			super();
			S = s;
			B = b;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(S);
			builder.append(", ");
			builder.append(B);
			builder.append("/");
			return builder.toString();
		}
	}

	private static void subset(int cnt) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(ing));
//			System.out.println(Arrays.toString(isSelected));
			
			int sumB = 0;
			int mulS = 1;
			
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					mulS *= ing[i].S; // 신맛 - 곱하기
					sumB += ing[i].B; // 쓴맛 - 더하기
//					System.out.println("food " + ing[i].S + " : " + ing[i].B + " / sum " + mulS + " : " + sumB);
					int tmp = Math.abs(mulS - sumB);
					res = (tmp < res) ? tmp : res;
				}
			}
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);

		isSelected[cnt] = false;
		subset(cnt + 1);

	}

}
