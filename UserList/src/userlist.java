import java.util.Scanner;
import java.io.*;
/**
 * 
 */

/**
 * @author Andriy_Yurchuk
 *
 */
public class userlist {

	/**
	 * 
	 */
	public userlist() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileOutputStream out;
		PrintStream p;
		String userid;
		System.out.println("Please insert the number of users you want to be generated");
		Scanner in = new Scanner(System.in);
		userid = in.nextLine();
		int useridint = Integer.parseInt(userid);
		System.out.println(useridint);
		int id;
		for (id = 100; id <= (100 + useridint); id++) {
			try 
			{
				out = new FileOutputStream("users.csv", true);
				p = new PrintStream(out);
				p.println ("user" + id + ",user" + id + "@example.com,user" + id + "123,User" + id);
				p.close();
			}
			catch (Exception e)
			{
                System.err.println ("Error writing to file");
			}

		System.out.println("user" + id + ",user" + id + "@exaple.com,user" + id + "123,User" + id);
		}
	}

}
