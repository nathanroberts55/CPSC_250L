import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class LineNumbers {
	public static void process(File input, File output){
		
		try{
		Scanner scnr = new Scanner(input);
		PrintWriter out = new PrintWriter(output);
		
		Integer count = 1;
		
		while(scnr.hasNextLine()){
			String counter  = count.toString();
			String x = String.format("%3s",counter);
			
			out.print(x + " | ");
			out.println(scnr.nextLine() + "");
			count++;
		}
		
		scnr.close();
		out.close();
		
		} catch(IOException e){
			
		}
		
		
		
	}
}
