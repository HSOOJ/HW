import java.util.Scanner;

public class Main_BJ_2839_설탕배달_0817 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int res = 0;
		
		while(true) {
			if(N % 5 == 0) {
				res += N / 5;
				System.out.println(res);
				break;
			}
			
			else {
				N -= 3;
				res++;
			}
			
			if(N < 0) {
				System.out.println(-1);
				break;
			}
		}
		sc.close();
	}
}
