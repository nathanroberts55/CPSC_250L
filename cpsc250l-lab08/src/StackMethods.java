import java.io.*;

public class StackMethods {
	public static Stack<Integer> getEvenNumbers(Stack<Integer> stack) {
		Stack<Integer> copyStack = new Stack<Integer>();
		Stack<Integer> returnStack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();

		while(!(stack.isEmpty())){
			int num = stack.pop();
			
			tempStack.push(num);
			copyStack.push(num);
			
		}
		
		while(!(tempStack.isEmpty())){
			stack.push(tempStack.pop());
		}
		
		while(!(copyStack.isEmpty())) {
			int T = copyStack.pop();
			
			if(T % 2 == 0){
				returnStack.push(T);
			}
		}
		
		return returnStack;
	}
	
	public static boolean checkParentheses(String input) {
		Stack<Character> charStack = new Stack<Character>();
		boolean correct = false;
		
		if(input == null || input == ""){
			correct = true;
		}
		
		char[] in = input.toCharArray();
		
		for(int i = 0; i < in.length; i++){
			
			if(in[i] == '(' || in[i] == '[' || in[i] == '{'){
				charStack.push(in[i]);
			}
			
			if(in[i] == ')' || in[i] == ']' || in[i] == '}'){
				if(charStack.isEmpty()){
					return false;
				}
				char t = charStack.pop();
				
				if( t == '{' && in[i] == '}'){
					correct = true;
				}
				else if( t == '[' && in[i] == ']'){
					correct = true;
				}
				else if( t == '(' && in[i] == ')'){
					correct = true;
				}
				else{
					correct = false;
				}
			}
		}
		
		if(!(charStack.isEmpty())){
			correct = false;
		}
			
		return correct;
	}
	
	public static void reverse(Node<Integer> reverseMe, File out) {
		PrintWriter printer;
		
		try {
			
			printer = new PrintWriter(out);
			Stack<Integer> intStack = new Stack<Integer>();
			
			for(Node<Integer> n = reverseMe; n != null; n = n.next){
				intStack.push(n.value);
			}

			while(!(intStack.isEmpty())){
				printer.println(intStack.pop());
			}
			
			printer.close();
		} catch (Exception e) {
			
		}
		
		
	}
	
}
