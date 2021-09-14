import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리_0914 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][3];
		int res[][] = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		res[0][0] = arr[0][0];
		res[0][1] = arr[0][1];
		res[0][2] = arr[0][2];
		
		for (int i = 1; i < N; i++) {
			res[i][0] = Math.min(res[i-1][1], res[i-1][2]) + arr[i][0];
			res[i][1] = Math.min(res[i-1][0], res[i-1][2]) + arr[i][1];
			res[i][2] = Math.min(res[i-1][0], res[i-1][1]) + arr[i][2];
		}

		System.out.println(Math.min(Math.min(res[N-1][0], res[N-1][1]), res[N-1][2]));
		
	}

}
