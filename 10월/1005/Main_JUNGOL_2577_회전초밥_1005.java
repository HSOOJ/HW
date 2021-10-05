import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JUNGOL_2577_회전초밥_1005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int C = Integer.parseInt(st.nextToken());// 쿠폰 번호

		int arr[] = new int[N + K]; // 회전 초밥
		int visited[] = new int[D + 1];   // 숫자 세는 배열

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 회전 표시하기 
		System.arraycopy(arr, 0, arr, N, K - 1);
		
		int cnt = 0;
		int max = 0;
		
		// 처음부터
		for (int i = 0; i < K; i++) {
			if(visited[arr[i]] == 0) { // 앞에서 나온 적 없으면
				cnt++; // 길이 추가
			}
			visited[arr[i]]++; // 방문 표시
		}
		
		max = cnt;
		
		for (int i = 1; i < N; i++) {
			if(max <= cnt) {
				if(visited[C] == 0)
					max = cnt + 1;
				else
					max = cnt;
			}
			visited[arr[i - 1]]--;
			if(visited[arr[i - 1]] == 0)
				cnt--;
			
			if(visited[arr[i + K - 1]] == 0)
				cnt++;
			visited[arr[i + K - 1]]++;
		}
		
		System.out.println(max);
		
	}

}
