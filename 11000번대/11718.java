import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			String input = null;
			
			input = sc.nextLine();
			input += "\n";
			
			
			while(sc.hasNextLine()) {
				input += sc.nextLine();
				input += "\n";
			}
			System.out.print(input);
	}

}
