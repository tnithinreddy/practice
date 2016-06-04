import java.util.Stack;
public class InfixToPostFix{
	public static void main(String[] args) {
		String s = "1+2*3^4";
		s = "1+2*(3^4-5)^(6+7*8)-9";
		toPostFix(s);
	}
	public static void toPostFix(String s){
		Stack<Character> stack = new Stack<Character>();
		char c;
		// int precedence = -1;
		for ( int i = 0;i<s.length() ; i++ ) {
			c = s.charAt(i);
			if (Character.isDigit(c)) {
				System.out.print(c);
				continue;
			}
			if (c == '(') {
				stack.push(c);
				continue;
			}
			if (c == ')') {
				while(!stack.isEmpty()){
					char x = stack.pop();
					if (x == '(') {
						break;
					}
					System.out.print(x);
				}
				continue;
			}
			// precedence = getPrecedence(c);
			// char top = s.top();
			// int topPrecdence = getPrecedence(top);
			// System.out.println("here = "+ c);
			while(!stack.isEmpty()&& getPrecedence(c) < getPrecedence(stack.peek())){
				System.out.print(stack.pop());
				// s.pop();
			}
			stack.push(c);
			// if operand print
			// if operator check for the previous operator on stack
		}
		while(!stack.isEmpty()){
							System.out.print(stack.pop());

		}
	}
	public static int getPrecedence(char c){
		switch(c){
				case '+':
				case '-':
					return 1;
				case '*':
				case '/':
					return 2;
				case '^':
					return 3;
				default:
					return -1;
			}
	}
}