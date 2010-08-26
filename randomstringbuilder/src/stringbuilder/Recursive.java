/**
 * 
 */
package stringbuilder;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author Andriy_Yurchuk
 *
 */
public class Recursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileOutputStream out;
		PrintStream p;
		String newline = System.getProperty("line.separator");
		String opentag = "<AccountID>";
		String closetag = "</AccountID>";
				
	try {
		out = new FileOutputStream("recursive.txt", true);
		p = new PrintStream(out);
		p.println("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:get=\"http://www.sportingbet.com/internal/xsd/getbalance\">" +
				newline + "   <soapenv:Header/>" +
				newline + "   <soapenv:Body>" +
				newline + "      <get:GetBalanceRequest>");
		
		for(int i = 1; i < 500; i++){
			p.println("         " + opentag);
		}
		
		for(int j = 1; j < 500; j++){
			p.println("         " + closetag);
		}
		
		p.println("         <SessionToken></SessionToken>" +
				newline + "         <BusinessUnitID>5</BusinessUnitID>" + 
				newline + "         <CurrencyID>USD</CurrencyID>" + 
				newline + "         <Language></Language>" + 
				newline + "      </get:GetBalanceRequest>" + 
				newline + "   </soapenv:Body>" + 
				newline + "</soapenv:Envelope>");
		
		p.close();
	} catch (Exception e)
	{
        System.err.println ("Error writing to file");
	}
		
	}
		

}
