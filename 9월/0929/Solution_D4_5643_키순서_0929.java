import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서_0929 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int shorter[][] = new int[N][N];
			int taller[][] = new int[N][N];
			
			int res = 0;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				shorter[a][b] = 1;
				taller[b][a] = 1;
			}
			
			// 나보다 키가 작은 학생
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(shorter[i][k] == 1 && shorter[k][j] == 1) {
							shorter[i][j] = 1;
						}
					}
				}
			}
			
			// 나보다 키가 큰 학생
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(taller[i][k] == 1 && taller[k][j] == 1) {
							taller[i][j] = 1;
						}
					}
				}
			}
			
			// 자신의 키가 몇 번째인지 정확하게 아는 경우 => 자신보다 키가 작은 사람, 큰 사람을 다 아는 경우
			// 키가 작은 학생 수 + 키가 큰 학생 수 = 전체 학생 수 - 1 (자기 자신 제외)
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					tmp += shorter[i][j] + taller[i][j];
				}
				
				if(tmp == N-1) res++;
			}
			// 출력
			System.out.println("#" + t + " " + res);
		}
	}
}
