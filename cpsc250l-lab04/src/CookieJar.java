import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CookieJar {
	
	public static void cashingIn(File input, File output) throws IOException{
		Scanner scnr = new Scanner(input);
		PrintWriter out = new PrintWriter(output);
		
		try{
			ArrayList<String> allCoins = new ArrayList<String>();
			
			while(scnr.hasNext()){
				allCoins.add(scnr.next());
			}
			
			BufferedReader br = new BufferedReader(new FileReader(input));
			
			if(input.length() == 0){
				out.print("You have no money in the jar");
				scnr.close();
				out.close();
			}
			
			Double sum = 0.0;
			
			for(int j = 0; j < allCoins.size(); j += 2){
				
			    int num = Integer.parseInt(allCoins.get(j));
			    String coin = allCoins.get(j + 1);
				
				
					if(coin.equals("penny") || coin.equals("pennies") ){
							sum += (num * 0.01);
						}
					if(coin.equals("nickel") || coin.equals("nickels")){
							sum += (num * 0.05);
						}
					if(coin.equals("dime") || coin.equals("dimes")){
							sum += (num * 0.10);
						}
					if(coin.equals("quarter") || coin.equals("quarters")){
							sum += (num * 0.25);
						}
				}
			
			
//			System.out.println(sum);
			if(sum == 0.0){
//				System.out.println("You have no money in the jar");
				out.print("You have no money in the jar");
			}
			
			if(sum > 0.0){
//				String sumString = sum.toString();
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
				String sumValue = formatter.format(sum);
//				System.out.println("You have " + sumValue + " in the jar");
				out.print("You have " + sumValue + " in the jar");
			}
			
			
			
		scnr.close();
		out.close();
		br.close();
		
		
			
			}catch(Exception e){
				throw new IOException();
			}
	}
	
		
	
}

