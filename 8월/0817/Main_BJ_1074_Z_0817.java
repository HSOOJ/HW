import java.util.Scanner;

public class Main_BJ_1074_Z_0817 {

	static int N, r, c, res;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = (int)Math.pow(2, sc.nextInt());
		r = sc.nextInt();
		c = sc.nextInt();
	
		solve(N, 0, 0);
		
		sc.close();
	}

	private static void solve(int n, int x, int y) {
		 if(y == r && x == c) {
			System.out.println(res);
			return;
		}

		if(y <= r && r < (y + n) && x <= c && c < (x + n)) {
			int nn = n / 2;
			solve(nn, x, y);
			solve(nn, x+nn, y);
			solve(nn, x, y+nn);
			solve(nn, x+nn, y+nn);
		}

		else
			res += n*n;
	}
	
}
