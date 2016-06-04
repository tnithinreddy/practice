import java.util.*;
public class NextGreaterELement{
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		int a[] = {11,13,21,3};
		int next = 1;
		int element;
		int top;
		s.push(a[0]);
		for (int i = 1; i < a.length; i++) {
			next = a[i];
			while(!s.isEmpty() && s.peek() < next){
				System.out.println(s.pop() + " => "+ next);
			}
			s.push(next);
		}
		while(!s.isEmpty()){
			System.out.println(s.pop() + " => -1");	
		}
	}
}