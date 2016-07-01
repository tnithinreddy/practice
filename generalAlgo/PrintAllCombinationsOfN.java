import java.util.*;

public class PrintAllCombinationsOfN{
	public static void main(String[] args) {
		int N = 3;
		ArrayList<Integer> list = new ArrayList<Integer>();
		printCombinations(list,N);
	}

	public static void printCombinations(ArrayList<Integer> list, int N){
		if (N < 0) {
			return;
		}
		if (N == 0) {
			print(list);
			return;
		}
		list.add(1);
		printCombinations(list,N-1);
		list.remove(list.size()-1);

		list.add(2);
		printCombinations(list,N-2);
		list.remove(list.size()-1);

		list.add(3);
		printCombinations(list,N-3);
		list.remove(list.size()-1);
	}

	public static void print(ArrayList<Integer> list){
		for (int i : list ) {
			System.out.print(i);
		}
			System.out.println();

	}

}