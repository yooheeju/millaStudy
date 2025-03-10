import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int M = scanner.nextInt();
		int cup = 1;
		for(int i=0; i<M; i++) {
			int X = scanner.nextInt();
			int Y = scanner.nextInt();
			
			if(cup == X)	
				cup = Y;
			else if(cup == Y)
				cup = X;
		}
		System.out.println(cup);
		scanner.close();
	}
}