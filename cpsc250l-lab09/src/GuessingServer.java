import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GuessingServer {
	public static void main(String[] args){
		try{
			ServerSocket socket = new ServerSocket(5150);
			boolean serverOpen = false;
			int first = 0;
			int midPoint = 0;
			int second = 0;
			int tries = 0;
			
			while(!serverOpen){
				Socket client = socket.accept();
				Scanner scnr = new Scanner(client.getInputStream());
				PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
				String string = scnr.nextLine();
				Scanner scnr2 = null;
				
				if(string.equals("SHUT DOWN")){
					break;
				}
				
				else{
					try{
						scnr2 = new Scanner(string);
						second = scnr2.nextInt();
						first = scnr2.nextInt();
					} catch(Exception e){
						
					}
				}
				
				tries = 0;
				
				while(tries != 9){
					midPoint = (first + second) / 2;
					writer.println(midPoint);
					string = scnr.next();
					
					if(string.equals("high")){
						first = midPoint;
						tries++;
					}
					else if(string.equals("low")){
						second = midPoint;
						tries++;
					}
					else if(string.equals("won") || string.equals("lost")){
						tries = 9;
					}
					else if(string.equals("SHUT DOWN")){
						serverOpen = true;
					}
					
				}
				
				scnr.close();
				scnr2.close();
				client.close();
				writer.close();
				
				
			}
			socket.close();
		} catch(IOException e){
//			socket.close();
		}
	}

	
}
