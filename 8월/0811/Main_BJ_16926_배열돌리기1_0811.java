import java.util.Scanner;

public class Main_BJ_16926_배열돌리기1_0811 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt(); // 배열 크기 N
		int M = sc.nextInt(); // 배열 크기 M
		int R = sc.nextInt(); // 수행해야하는 회전 수
		
		int arr[][] = new int [N][M]; // 배열
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		} // 데이터 입력

		// 		    <  ^  >  v 
		int []dx = {0, 1, 0, -1};
		int []dy = {1, 0, -1, 0};
		
		int range = Math.min(N, M) / 2; // 회전할 때마다 돌아야하는 사각형 수
		
		for(int r = 0; r < R; r++) {
			
			for(int idx = 0; idx < range; idx++) {
				int x = idx;
				int y = idx;

				int tmp = arr[x][y]; // 회전을 시작하는 값
				int dir = 0;
				
				while(dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if(idx <= nx && nx < N-idx && idx <= ny && ny < M-idx) { // 범위 체크
						arr[x][y] = arr[nx][ny]; 
						// [1, 2, 3, 4] -> [2, 3, 4, 4]
						
						x = nx;
						y = ny;
					}
					else dir++;
				}
				
				arr[idx+1][idx] = tmp;
			}
		} // R
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			} System.out.println();
		}
		sc.close();
	} // main

}
