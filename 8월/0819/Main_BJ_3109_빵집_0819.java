import java.util.Scanner;

public class Main_BJ_3109_빵집_0819 {

	static int R, C, res;
	static boolean checked[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); 
		C = sc.nextInt();
		res = 0; // 파이프라인  개수

		checked = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				if (c == 'x')
					checked[i][j] = true; // 건물이 있는 곳이 true
			}
		}
		
		for (int i = 0; i < R; i++)
			findRoot(i, 0);

		sc.close();

		System.out.println(res);
//		for(int i = 0; i < R; i++) {
//			for(boolean b : checked[i])
//				System.out.print(b + " ");
//			System.out.println();
//		}
	}

	private static boolean findRoot(int r, int c) {
		for (int i = -1; i < 2; i++) { 
			// 우상(-1, 1), 우(0, 1), 우하(1, 1)
			int nr = r + i;
			int nc = c + 1;
			
			if (0 <= nr && nr < R && checked[nr][nc] == false) { // 배열 안이고 내용이 아무것도 없으면
				if (nc == C - 1) { // 빵집에 도착하면 끝
					res++;
					return true;
				}

				checked[nr][nc] = true; // 가스관이 지나감
				
				if (findRoot(nr, nc))
					return true;
			}
		}
		return false;
	}
}
