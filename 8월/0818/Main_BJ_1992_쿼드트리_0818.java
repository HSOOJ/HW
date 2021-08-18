import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1992_쿼드트리_0818 {
	
	static StringBuilder sb = new StringBuilder();
	static int [][] arr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		arr = new int[T][T];
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			for(int j = 0; j < T; j++) {
				arr[i][j] = (int)(str.charAt(j)-'0'); // 스트링 -> 캐릭터 -> 인티저
			}
		}
		solve(0, 0, T);
		
		System.out.println(sb);
	}

	private static void solve(int x, int y, int t) {
		if(compress(x, y, t)) {
				sb.append(arr[x][y]); // 압축되는거면 압축된거 하나만 올리기
			return;
		}

		else {
			// 압축 안되면 4개로 쪼개서 다시 확인해보기
			t /= 2; // 4개로 쪼개기 때문에 길이 반으로
			sb.append("(");
			solve(x, y, t); // 좌상
			solve(x, y + t, t); // 우상
			solve(x + t, y, t); // 좌하
			solve(x + t, y + t, t); // 우하
			sb.append(")");
		}
		
	}

	// 압축하기
	private static boolean compress(int x, int y, int t) {
		// 제일 좌상단의 값이랑 범위의 내용이랑 비교해서 다른 값이면 압축 불가
		int pivot = arr[x][y];
		for(int i = x; i < x+t; i++) {
			for(int j = y; j < y+t; j++) {
//				System.out.println(x + " " + y);
				if(pivot != arr[i][j])
					return false;
			}
		}
		return true;
	}
}
