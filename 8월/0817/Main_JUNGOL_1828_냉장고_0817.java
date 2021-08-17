import java.util.Arrays;
import java.util.Scanner;

public class Main_JUNGOL_1828_냉장고_0817 {
	
	// Chemical 클래스 
	static class Chemical implements Comparable<Chemical> {
		int minTemp;
		int maxTemp;

		public Chemical(int minTemp, int maxTemp) {
			super();
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
		}
		
		@Override
		public String toString() {
			return "Chemical [minTemp=" + minTemp + ", maxTemp=" + maxTemp + "]";
		}

		@Override
		public int compareTo(Chemical o) {
			return this.maxTemp - o.maxTemp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N : 화학 물질 개수
		
		Chemical[] ch = new Chemical[N]; // 화학 물질들
		
		for(int i = 0; i < N; i++) {
			ch[i] = new Chemical(sc.nextInt(), sc.nextInt());
		}
		
		// 최고 보관 온도 순으로 정렬
		Arrays.sort(ch);
		
		int res = 1; // 개수
		
		// 첫번째 최고 보관 온도 저장
		int curMax = ch[0].maxTemp;
		
		// 최고 보관 온도보다 다음 최저 보관온도가 작으면 개수+1 하고 그 값으로 변경하기
		for(int i = 1; i < N; i++) {
			if(curMax < ch[i].minTemp) {
				res++;
				curMax = ch[i].minTemp;
			}
		}
		
		System.out.println(res);
		
//		System.out.println(Arrays.toString(ch));
		
		sc.close();
		
	}

}
