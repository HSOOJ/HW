import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2_0916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			int D[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					D[i][j] = Integer.parseInt(st.nextToken());
					
					if(i!=j && D[i][j] == 0)
						D[i][j] = 987654321;
				}
			}
			
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k) continue;
					for (int j = 0; j < N; j++) {
						if (i == k || i == j) continue;
						if(D[i][j] > D[i][k] + D[k][j]) {
							D[i][j] = D[i][k] + D[k][j];
						}
					}
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += D[i][j];
				}
				min = Math.min(min, sum);
			}
			
			System.out.println("#" + t + " " + min);
		}
	}

}

//		5
//		0 1 1 0 0 
//		1 0 1 1 1 
//		1 1 0 0 0 
//		0 1 0 0 0 
//		0 1 0 0 0

//3
//0 1 0
//1 0 1 
//0 1 0

/*



 */
