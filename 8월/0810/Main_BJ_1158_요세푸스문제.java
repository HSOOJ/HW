import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_BJ_1158_요세푸스문제_0810_BufferedReader {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 1;
		
		Queue<Integer> q = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		// 사람 입력
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			if(cnt % K == 0) // K번째마다 제거
				sb.append(q.poll() + ", ");
			else
				q.offer(q.poll());
			cnt++;
		}
		
		sb.setLength(sb.length() - 2); // ", "이기 때문에 -2
		sb.append(">");
		
		System.out.println(sb);
	} // main
	
}