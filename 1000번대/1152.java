package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		
		if(test.length() == 0) {
			System.out.print(0);

		}
		else if(test.toCharArray()[0] == ' ' && test.toCharArray().length == 1) {
			System.out.print(0);
		}
		else {
			String test2 = test.trim();
			String[] test3 = test2.split(" ");
			System.out.print(test3.length);
		}
	}

}
