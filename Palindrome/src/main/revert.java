package main;
import java.util.Scanner;
public class revert {
	public static void main(String[] args) {
		String pal;
		Scanner in = new Scanner(System.in);
		pal = in.nextLine();
		String pallow = pal.toLowerCase();
		String palesc = pallow.replaceAll("[^A-Za-z]", "");
		char[] palar = palesc.toCharArray();
		String palindrome = "";
		for (int i = palar.length-1; i>=0; i--) {
			palindrome+= palar[i];
		}
		if (palesc.equals(palindrome)) {
			System.out.println("String "+"\""+pal+"\""+" is a palindrome");
		}
		else {
			System.out.println("String "+"\""+pal+"\""+" is not a palindrome");
		}
	}
}
