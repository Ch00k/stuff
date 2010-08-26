/**
 * Random string generator
 */

package stringbuilder;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class RandomStr
{
    private final char[] alphanumeric=alphanumeric();
    private final Random rand;

    public RandomStr(){this(null);}

    public RandomStr(Random rand){
      this.rand=(rand!=null) ? rand : new Random();
    }

    public String get(int len){
        StringBuffer out=new StringBuffer();

        while(out.length() < len){
            int idx=Math.abs(( rand.nextInt() % alphanumeric.length ));
            out.append(alphanumeric[idx]);
        }
        return out.toString();
    }

    // create alphanumeric char array
    private char[] alphanumeric(){
        StringBuffer buf=new StringBuffer(128);
        for(int i=48; i<= 57;i++)buf.append((char)i); // 0-9
        for(int i=65; i<= 90;i++)buf.append((char)i); // A-Z
        for(int i=97; i<=122;i++)buf.append((char)i); // a-z
        return buf.toString().toCharArray();
    }

    public static void main(String[] args){
        RandomStr rand=new RandomStr();
        FileOutputStream out;
		PrintStream p;
        try 
		{
			out = new FileOutputStream("attachment.bin", true);
			p = new PrintStream(out);
			p.println (rand.get(5000));
			p.close();
		}
		catch (Exception e)
		{
            System.err.println ("Error writing to file");
		}
		
		System.out.println("Done");
    }
    
}
