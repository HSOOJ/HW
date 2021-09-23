import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JOUNOL_1681_해밀턴순환회로_0923 {

	static int N, arr[][], res[], ans = Integer.MAX_VALUE;
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 배달 장소의 수
		arr = new int[N][N];				 // 장소
		isSelected = new boolean[N];		 // 배달 장소 선택 유무
		res = new int[N];					 // 배달 장소 순열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				// 최소 비용을 구해야하기 때문에 이동 방법이 없는 곳은 0이 아닌 integer 범위를 넘지 않는 적당히 큰 수로 지정
				if (tmp == 0) 
					arr[i][j] = 123456789;
				else
					arr[i][j] = tmp;
			}
		}

		// 배달지 순열
		permu(1, 0);
		
		// 결과 출력
		System.out.println(ans);

	}

	private static void permu(int cnt, int tmpsum) {
		// ans : 회사 ~ 모든 배달지 ~ 회사 의 비용
		// tmpsum : 회사 ~ 현재 배달지 의 비용
		
		// 모든 배달지를 돌기도 전에 다 돌고 회사로 도착한 것보다 비용이 크면 return
		if (ans < tmpsum)
			return;
		
		// 모든 배달지를 다 돌았으면 회사로 복귀하는 비용 추가하기
		if (cnt == N) {
			
			// 마지막 배달지 ~ 회사 비용 추가
			tmpsum += arr[res[N - 1]][0];
			
			// 그 중에서 최소값으로 지정
			ans = Math.min(tmpsum, ans);
			
			return;
		}

		// 회사는 0 배달지는 1이상이기 때문에 1부터
		// 회사를 제외한 배달 장소 순열만 생성
		for (int i = 1; i < N; i++) {
			if (!isSelected[i]) {
				res[cnt] = i;
				isSelected[i] = true;
				
				// 직전 배달지 -> 현재 배달지 비용을 추가해서 넘겨줌
				// 여기서 cnt-1 값이 사용되기 때문에 처음에 permu 메서드를 호출할 때 cnt 값을 1로 지정
				permu(cnt + 1, tmpsum + arr[res[cnt - 1]][res[cnt]]);

				isSelected[i] = false;

			}
		}
	}

}
